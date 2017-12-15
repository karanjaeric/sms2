/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.inventoryservlets;

import com.sms.beans.InventoryBeanI;
import com.sms.inventorymodels.Item;
import com.sms.inventorymodels.ItemCategory;
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
@WebServlet(name = "SaveCategory", urlPatterns = {"/saveCategory"})
public class SaveCategory extends HttpServlet {

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
            out.println("<title>Servlet SaveCategory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveCategory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            String code = request.getParameter("code");
            List<ItemCategory> categories = inventoryBean.getAllCategories();

            response.getWriter().write(JsonUtil.convertObjectsToJson(categories));
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            ResponseObject obj = new ResponseObject();
            ItemCategory category = new ItemCategory();
            category.setCategoryCode(request.getParameter("categoryCode"));
            category.setCategoryName(request.getParameter("categoryName"));

            inventoryBean.saveCategory(category);
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
