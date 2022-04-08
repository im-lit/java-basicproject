/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import longntn.category.CategoryDAO;
import longntn.category.CategoryDTO;
import longntn.vegetable.VegetableDAO;
import longntn.vegetable.VegetableDTO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "SearchCategoryController", urlPatterns = {"/SearchCategoryController"})
public class SearchCategoryController extends HttpServlet {
    public static final String SUCCESS = "admin.jsp";
    public static final String ERROR = "error.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        CategoryDAO categoryDAO = new CategoryDAO();
        VegetableDAO vegetableDAO = new VegetableDAO();
        String cateID = request.getParameter("categoryID");
        try {
            List<CategoryDTO> listCategory = categoryDAO.getAllCategory();
            List<VegetableDTO> listVeg = vegetableDAO.getVegetableByCateID(cateID);
            request.setAttribute("LIST_VEGETABLE", listVeg);
            request.setAttribute("LIST_CATEGORY", listCategory);
            url = SUCCESS;
            
        } catch (Exception e) {
            log("Error at SearchCategoryController");
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
