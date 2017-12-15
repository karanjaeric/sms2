/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.beans;

import com.sms.inventorymodels.User;
import java.util.List;
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
public class AuthenticationBean implements AuthenticationBeanI {

    @PersistenceContext(unitName = "SMSPU")
    private EntityManager em;

    @Override
    public User login(String username, String password) {
        User user = null;
        List<User> loggingUser = em.createQuery("SELECT u FROM User u WHERE u.userName = :username AND u.passWord = :password").setParameter("username", username).setParameter("password", password).getResultList();
        if (!loggingUser.isEmpty()) {
            user = loggingUser.get(0);
            user.setValid(true);

        }
        return user;

    }

}
