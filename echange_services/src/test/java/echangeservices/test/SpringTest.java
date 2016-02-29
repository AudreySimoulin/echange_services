/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.test;

import echangeservices.entity.Annonce;
import echangeservices.entity.Categorie;
import echangeservices.entity.Lieu;
import echangeservices.entity.Utilisateur;
import echangeservices.enumeration.TypeAnnonce;
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
import java.util.Date;
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

    //@Before
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
            Categorie c = new Categorie(5L, "Dépannage");
            categorieService.save(c);
        }
        {
            Categorie c = new Categorie(6L, "Services à la personne");
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
        
        //Ajout d'annonces
        
        {
            Annonce a = new Annonce(1L, TypeAnnonce.Demande, "Recherche electricien", "blabla", 20, new Date(), categorieService.findOne(1L), utilisateurService.findOne(1L));
            annonceService.save(a);
            categorieService.findOne(1L).getAnnonces().add(a);
            utilisateurService.findOne(1L).getAnnonces().add(a);
        }
        {
            Annonce a = new Annonce(2L, TypeAnnonce.Demande, "Recherche cours", "blabla", 20, new Date(), categorieService.findOne(3L), utilisateurService.findOne(2L));
            annonceService.save(a);
            categorieService.findOne(3L).getAnnonces().add(a);
            utilisateurService.findOne(2L).getAnnonces().add(a);
        }
        {
            Annonce a = new Annonce(3L, TypeAnnonce.Offre, "Donne cours", "blabla", 20, new Date(), categorieService.findOne(3L), utilisateurService.findOne(3L));
            annonceService.save(a);
            categorieService.findOne(3L).getAnnonces().add(a);
            utilisateurService.findOne(3L).getAnnonces().add(a);
        }
        {
            Annonce a = new Annonce(4L, TypeAnnonce.Offre, "Propose ménage", "blabla", 30, new Date(), categorieService.findOne(6L), utilisateurService.findOne(1L));
            annonceService.save(a);
            categorieService.findOne(5L).getAnnonces().add(a);
            utilisateurService.findOne(1L).getAnnonces().add(a);
        }
        {
            Annonce a = new Annonce(5L, TypeAnnonce.Demande, "Recherche dépannage informatique", "blabla", 50, new Date(), categorieService.findOne(4L), utilisateurService.findOne(4L));
            annonceService.save(a);
            categorieService.findOne(5L).getAnnonces().add(a);
            utilisateurService.findOne(1L).getAnnonces().add(a);
        }

    }

    //@Test
    public void envoiMessageOK() {

        envoieMessageService.envoieMessage(1L, 2L, "Hello", "Bonjour Audrey");
    }
    
    //@Test
    public void transfertOK(){
        transfertService.transfert(1L, 3L, 50, "Transfert effectue");
    }

    //@Test
    public void findByCategorieOK(){
        for(Annonce a : annonceService.findByCategorieIdOrderByDateCreationDesc(3L))
            System.out.println(a.getTitre());
    }

    //@Test
    public void findByUtilisateurOK(){
        for(Annonce a : annonceService.findByPosteParIdOrderByDateCreationDesc(1L))
            System.out.println(a.getTitre());
    }
    
//    @Test
    public void findByTitreOK(){
       // for(Annonce a : annonceService.findByTitre("Recherche electricien"))
       //     System.out.println("******"+a.getTitre()+"**********");
    }
    
    //@Test
    public void findByLieuOK(){
        for(Annonce a : annonceService.findByPosteParLieuIdOrderByDateCreationDesc(2L))
            System.out.println("******"+a.getTitre()+"**********"); 
    }
    
   // @Test
    public void findByTypeAnnonceOK(){
        for(Annonce a : annonceService.findByTypeAnnonceOrderByDateCreationDesc(TypeAnnonce.Demande))
            System.out.println("******"+a.getTitre()+"**********"); 
    }
    
//    @Test
    public void findByTitreContainingOK(){
        for(Annonce a : annonceService.findByTitreContainingIgnoreCaseOrderByDateCreationDesc("ELEC"))
            System.out.println("******"+a.getTitre()+"**********"); 
    }
    
    //@Test
    public void findByTypeAnnonceAndPosteParOK(){
        for(Annonce a : annonceService.findByTypeAnnonceAndPosteParIdOrderByDateCreationDesc(TypeAnnonce.Demande, 2L))
            System.out.println("******"+a.getTitre()+"**********"); 
    }
    
    //@Test
    public void findByTypeAnnonceAndLieuOK(){
        for(Annonce a : annonceService.findByTypeAnnonceAndPosteParLieuIdOrderByDateCreationDesc(TypeAnnonce.Offre, 2L))
            System.out.println("******"+a.getTitre()+"**********"); 
    }
    
    //@Test
    public void findByTypeAnnonceAndCategorieOK(){
        for(Annonce a : annonceService.findByTypeAnnonceAndCategorieIdOrderByDateCreationDesc(TypeAnnonce.Offre, 6L))
            System.out.println("******"+a.getTitre()+"**********"); 
    }
    
    //@Test
    public void findByTypeAnnonceAndPosteParLieuIdAndCategorieIdOK(){
        for(Annonce a : annonceService.findByTypeAnnonceAndPosteParLieuIdAndCategorieIdOrderByDateCreationDesc(TypeAnnonce.Offre, 2L,6L))
            System.out.println("******"+a.getTitre()+"**********"); 
    }
    
    @Test
    public void findByTitreOrContenuOK(){
        for(Annonce a : annonceService.findByTitreOrContenuContainingOrderByDateCreationDesc("blabla","blabla"))
            System.out.println("******"+a.getTitre()+"**********");     
            
    }
    
    
    
    
    
    
}
