/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DBService {

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

    public void deleteAll() {
        messageService.deleteAll();
        commentaireService.deleteAll();
        paiementService.deleteAll();
        annonceService.deleteAll();
        utilisateurService.deleteAll();
        lieuService.deleteAll();
        categorieService.deleteAll();

    }

}
