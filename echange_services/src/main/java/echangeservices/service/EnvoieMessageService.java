/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.service;

import echangeservices.entity.Message;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class EnvoieMessageService {
    
    @Autowired
    private UtilisateurService userv;
    
    public void envoieMessage(long idDest, long idEmet,String titre, String messsage ){
        
        Message m = new Message(titre, messsage, Timestamp.from(Instant.now()), Boolean.FALSE, userv.findOne(idDest), userv.findOne(idEmet));
        userv.findOne(idEmet).getMessagesEnvoyes().add(m);
        userv.findOne(idDest).getMessagesRecus().add(m);
        
    }
    
}
