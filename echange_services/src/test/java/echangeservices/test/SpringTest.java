/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.test;

import echangeservices.entity.Categorie;
import echangeservices.entity.Lieu;
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
import org.junit.Before;
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
    private EnvoieMessageService envoieMessageService;

    @Autowired
    private TransfertService transfertService;

   // @Before
    public void before() {
        dBService.deleteAll();

        //Ajout des lieux
        {
            Lieu l = new Lieu(1L, "Bordeaux");
            lieuService.save(l);
        }
        {
            Lieu l = new Lieu(2L, "Lille");
            lieuService.save(l);
        }
        {
            Lieu l = new Lieu(3L, "Lyon");
            lieuService.save(l);
        }
        {
            Lieu l = new Lieu(4L, "Toulouse");
            lieuService.save(l);
        }
        {
            Lieu l = new Lieu(5L, "Paris");
            lieuService.save(l);
        }

        //Ajout des catégories
        {
            Categorie c = new Categorie(1L, "Bricolage");
            categorieService.save(c);
        }
        {
            Categorie c = new Categorie(2L, "Jardinage");
            categorieService.save(c);
        }
        {
            Categorie c = new Categorie(3L, "Cours");
            categorieService.save(c);
        }
        {
            Categorie c = new Categorie(4L, "Informatique");
            categorieService.save(c);
        }
        {
            Categorie c = new Categorie(4L, "Dépannage");
            categorieService.save(c);
        }
        {
            Categorie c = new Categorie(5L, "Services à la personne");
            categorieService.save(c);
        }

        {
            Utilisateur u = new Utilisateur(1L, "audrey", "coucou", TypeUtil.Normal, 100, lieuService.findOne(2L));
            utilisateurService.save(u);
        }
        {
            Utilisateur u = new Utilisateur(2L, "olga", "coucou", TypeUtil.Normal, 100, lieuService.findOne(1L));
            utilisateurService.save(u);
        }
        {
            Utilisateur u = new Utilisateur(3L, "agathe", "coucou", TypeUtil.Normal, 100, lieuService.findOne(3L));
            utilisateurService.save(u);
        }
        {
            Utilisateur u = new Utilisateur(4L, "romain", "coucou", TypeUtil.Administrateur, 100, lieuService.findOne(4L));
            utilisateurService.save(u);
        }

    }

    //@Test
    public void envoiMessageOK() {

        envoieMessageService.envoieMessage(1L, 2L, "Hello", "Bonjour Audrey");
    }
    
    @Test
    public void transfertOK(){
        transfertService.transfert(1L, 3L, 50, "Transfert effectue");
    }

}
