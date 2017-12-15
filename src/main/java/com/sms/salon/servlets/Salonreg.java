/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.salon.servlets;

import com.sms.salon.beans.SalonI;
import com.sms.salon.models.SalonModel;
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
@WebServlet(name = "Salonreg", urlPatterns = {"/salonReg"})
public class Salonreg extends HttpServlet {

    @EJB
    private SalonI salonBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SalonModel salon = new SalonModel();
            String salonLocation = request.getParameter("salonLocation");
            String salonName = request.getParameter("salonName");
            String salonPhoneNumber = request.getParameter("salonPhoneNumber");
            int numberOfEmployees = Integer.parseInt(request.getParameter("numberOfEmployees"));
            System.out.println("salon name is " + salonName);
            System.out.println("salon Location is " + salonLocation);
            System.out.println("salon phone is " + salonPhoneNumber);
            System.out.println("number of employees is " + numberOfEmployees);
            salon.setLocation(salonLocation);
            salon.setNumberOfEmployees(numberOfEmployees);
            salon.setPhoneNumber(salonPhoneNumber);
            salon.setSalonName(salonName);
            salonBean.save(salon);

            out.println("Salon has been registered Successfully");

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
