/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.salon.beans;

import com.sms.salon.models.SalonModel;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ekaranja
 */
@Stateless
@Local
public class SalonImpl implements SalonI {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;

    @Override
    public void save(SalonModel salon) {
        try {

            em.persist(salon);

        } catch (Exception e) {
        }

    }

}
