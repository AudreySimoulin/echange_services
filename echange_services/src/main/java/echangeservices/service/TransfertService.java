/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.service;

import echangeservices.entity.Paiement;
import echangeservices.entity.Utilisateur;
import echangeservices.exception.SoldeInsuffisantException;
import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class TransfertService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PaiementService pserv;

    @Autowired
    private UtilisateurService userv;
    
    @Autowired
    private ConfigService configService;

    public void transfert(long idEmet, long idDest, int montant, String msg) throws SoldeInsuffisantException{

        Utilisateur emetteur = em.find(Utilisateur.class, idEmet);
        Utilisateur destinataire = em.find(Utilisateur.class, idDest);
        
        if((emetteur.getSolde() - montant) < configService.getPlafond()){
            throw new SoldeInsuffisantException();
        }
        emetteur.setSolde(emetteur.getSolde() - montant);
        userv.save(emetteur);
        destinataire.setSolde(destinataire.getSolde() + montant);
        userv.save(destinataire);

        Paiement p = new Paiement(montant, Timestamp.from(Instant.now()), destinataire, emetteur, msg);

        emetteur.getPaiementsEmis().add(p);
        destinataire.getPaiementsRecus().add(p);

        pserv.save(p);

    }
}
