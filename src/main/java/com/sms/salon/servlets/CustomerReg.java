/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.salon.servlets;

import com.sms.salon.beans.CustomerI;
import com.sms.salon.models.CustomerModel;
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
@WebServlet(name = "CustomerReg", urlPatterns = {"/customerReg"})
public class CustomerReg extends HttpServlet {
      @EJB
    private CustomerI customerBean;

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            CustomerModel salonCustomer = new CustomerModel();
            String customerName = request.getParameter("customerName");
            String customerPhoneNumber = request.getParameter("customerPhoneNumber");
            String salonPhoneNumber = request.getParameter("salonPhoneNumber");
            //use salon phone number to get salon object
            
            System.out.println("customer name is " + customerName);
            System.out.println("customer phone number " + customerPhoneNumber);
            System.out.println("salon phone is " + salonPhoneNumber);
            
          salonCustomer.setCustomerName(customerName);
          salonCustomer.setCustomerPhoneNumber(customerPhoneNumber);
          customerBean.save(salonCustomer);

            out.println("Customer has been registered Successfully");

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
        processRequest(request, response);
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
