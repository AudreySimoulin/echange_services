/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.service;

import echangeservices.entity.Paiement;
import echangeservices.entity.Utilisateur;
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

    public void transfert(long idEmet, long idDest, int montant, String msg) {

        Utilisateur emetteur = em.find(Utilisateur.class, idEmet);
        Utilisateur destinataire = em.find(Utilisateur.class, idEmet);
        emetteur.setSolde(emetteur.getSolde() - montant);
        destinataire.setSolde(destinataire.getSolde() + montant);

        userv.save(emetteur);
        userv.save(destinataire);

        Paiement p = new Paiement(montant, Timestamp.from(Instant.now()), destinataire, emetteur, msg);

        emetteur.getPaiementsEmis().add(p);
        destinataire.getPaiementsRecus().add(p);

        pserv.save(p);

    }
}
