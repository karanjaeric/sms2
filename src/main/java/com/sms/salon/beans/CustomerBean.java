/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.salon.beans;

import com.sms.salon.models.CustomerModel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ekaranja
 */
@Stateless
public class CustomerBean implements CustomerI{
    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;

    @Override
    public void save(CustomerModel customer) {
                try {

            em.persist(customer);

        } catch (Exception e) {
        }
        
    }

    
}
