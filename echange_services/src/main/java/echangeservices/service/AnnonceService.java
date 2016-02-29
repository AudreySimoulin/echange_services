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

    public List<Annonce> findByCategorieId(Long id);

    public List<Annonce> findByPosteParId(Long id);
    
    public List<Annonce> findByPosteParLieuId(Long id);
    
    public List<Annonce> findByTypeAnnonce(TypeAnnonce typeAnnonce);
    
    public List<Annonce> findByTitreContaining(String str);
    
    //public List<Annonce> findByTitreLike(String str);
    
   

}
