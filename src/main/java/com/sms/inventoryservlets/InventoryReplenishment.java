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
@WebServlet(name = "InventoryReplenishment", urlPatterns = {"/inventoryReplenishment"})
public class InventoryReplenishment extends HttpServlet {
        @EJB
    private InventoryBeanI inventoryBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InventoryReplenishment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InventoryReplenishment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
              response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            ResponseObject obj= new ResponseObject();
            String code=request.getParameter("code");
            int itemsToAdd=Integer.parseInt(request.getParameter("itemsToAdd"));
            
      
       
          Item i=inventoryBean.findByItemCode(code)==null?new Item():inventoryBean.findByItemCode(code);

            System.err.println("testing item fetching:::::::::::: "+i.getItemCode());
             int currentItems=i.getRemaining();
             int total=currentItems+itemsToAdd;
             i.setRemaining(total);
             System.err.println("items to add:::::::::::: "+itemsToAdd);
             inventoryBean.updateItemRemains(total, code);
            
            

            String message = "Replenishment is Successfully";
            obj.setMessage(message);
            response.getWriter().write(JsonUtil.convertObjectsToJson(obj));

        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
