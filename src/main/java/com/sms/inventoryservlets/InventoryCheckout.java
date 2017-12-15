/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.inventoryservlets;

import com.sms.beans.InventoryBeanI;
import com.sms.inventorymodels.Item;
import com.sms.util.JsonUtil;
import com.sms.util.ResponseObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ekaranja
 */
@WebServlet(name = "InventoryCheckout", urlPatterns = {"/inventoryCheckout"})
public class InventoryCheckout extends HttpServlet {
          @EJB
    private InventoryBeanI inventoryBean;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                      response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            ResponseObject obj= new ResponseObject();
            String code=request.getParameter("code");
            int unitsToCheckOut=Integer.parseInt(request.getParameter("unitsToCheckout"));
            
      
       
          Item i=inventoryBean.findByItemCode(code)==null?new Item():inventoryBean.findByItemCode(code);

            System.err.println("testing item fetching:::::::::::: "+i.getItemCode());
             int currentItems=i.getRemaining();
             int total=currentItems-unitsToCheckOut;
             i.setRemaining(total);
             System.err.println("Units to checkout:::::::::::: "+unitsToCheckOut);
             inventoryBean.updateItemRemains(total, code);
            
            

            String message = "Checkout is Successfully";
            obj.setMessage(message);
            response.getWriter().write(JsonUtil.convertObjectsToJson(obj));

        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
