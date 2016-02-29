/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.test;

import echangeservices.entity.Categorie;
import echangeservices.entity.Utilisateur;
import echangeservices.enumeration.TypeUtil;
import echangeservices.service.AnnonceService;
import echangeservices.service.CategorieService;
import echangeservices.service.CommentaireService;
import echangeservices.service.DBService;
import echangeservices.service.EnvoieMessageService;
import echangeservices.service.LieuService;
import echangeservices.service.MessageService;
import echangeservices.service.PaiementService;
import echangeservices.service.TransfertService;
import echangeservices.service.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import echangeservices.spring.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private DBService dBService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private PaiementService paiementService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private LieuService lieuService;

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private EnvoieMessageService envoieMessage;
    
    @Autowired
    private TransfertService transfertService;

    @Test
    public void doNadaOK() {

        Utilisateur u1 = new Utilisateur();
        u1.setId(1L);

        Utilisateur u2 = new Utilisateur();
        u1.setId(2L);

        envoieMessage.envoieMessage(1L, 2L, "Hello", "Bonjour 1L");

    }

}
