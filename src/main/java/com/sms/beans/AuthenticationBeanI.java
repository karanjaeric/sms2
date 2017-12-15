/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.beans;

import com.sms.inventorymodels.User;

/**
 *
 * @author ekaranja
 */
public interface AuthenticationBeanI {
    User login(String username,String password);
    
}
