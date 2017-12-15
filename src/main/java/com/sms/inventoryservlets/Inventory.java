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
import java.util.List;
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
@WebServlet(name = "Inventory", urlPatterns = {"/inventory"})
public class Inventory extends HttpServlet {

    @EJB
    private InventoryBeanI inventoryBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //inventoryBean.save(i);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            List<Item> itemList = inventoryBean.getAllItems();

            response.getWriter().write(JsonUtil.convertObjectsToJson(itemList));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            ResponseObject obj= new ResponseObject();
            String categoryCode=request.getParameter("categoryCode");
            Item i = new Item();
            i.setItemCode(request.getParameter("itemCode"));
            i.setItemName(request.getParameter("itemName"));
            i.setReorderPoint(Integer.parseInt(request.getParameter("reorderPoint")));
            i.setCategory(inventoryBean.findCategoryByCode(categoryCode).get(0));
       
            inventoryBean.save(i);
            String message = "Data Saved Successfully";
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
