/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class ConfigService {
    
    private Integer plafond = -200;
    
    public Integer getPlafond() {
        return plafond;
    }

    public void setPlafond(Integer plafond) {
        this.plafond = plafond;
    }
    
    
    
}
