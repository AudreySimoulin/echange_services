/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.service;

import echangeservices.entity.Annonce;
import echangeservices.enumeration.TypeAnnonce;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface AnnonceService extends CrudRepository<Annonce, Long> {

    public List<Annonce> findByCategorieIdOrderByDateCreationDesc(Long id);

    public List<Annonce> findByPosteParIdOrderByDateCreationDesc(Long id);
    
    public List<Annonce> findByPosteParLieuIdOrderByDateCreationDesc(Long id);
    
    public List<Annonce> findByTypeAnnonceOrderByDateCreationDesc(TypeAnnonce typeAnnonce);
    
    public List<Annonce> findByTitreContainingIgnoreCaseOrderByDateCreationDesc(String str);
    
    //public List<Annonce> findByTitreLike(String str);
    
    public List<Annonce> findByTypeAnnonceAndPosteParIdOrderByDateCreationDesc(TypeAnnonce typeAnnonce, Long id);
    
    public List<Annonce> findByTypeAnnonceAndPosteParLieuIdOrderByDateCreationDesc(TypeAnnonce typeAnnonce, Long id);
    
    public List<Annonce> findByTypeAnnonceAndCategorieIdOrderByDateCreationDesc(TypeAnnonce typeAnnonce, Long id);
    
    public List<Annonce> findByTypeAnnonceAndPosteParLieuIdAndCategorieIdOrderByDateCreationDesc(TypeAnnonce typeAnnonce, Long idLieu,Long idCategorie);

    public List<Annonce> findByTitreOrContenuContainingOrderByDateCreationDesc(String rechercheTitre, String rechercheContenu);
   

}
