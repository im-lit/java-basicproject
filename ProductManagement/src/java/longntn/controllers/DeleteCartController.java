/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longntn.category.CategoryDAO;
import longntn.detail.DetailDTO;
import longntn.users.UserDAO;
import longntn.users.UserDTO;
import longntn.vegetable.VegetableDAO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "DeleteCartController", urlPatterns = {"/DeleteCartController"})
public class DeleteCartController extends HttpServlet {

    private static final String SUCCESS = "cart.jsp";
    private static final String ERROR = "MainController?action=Logout";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS;
        VegetableDAO vegDAO = new VegetableDAO();
        UserDAO userDAO = new UserDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");

        try {
            if (user == null) {
                url = ERROR;
            } else {
                String vegetableID = request.getParameter("vegetableID");
                ArrayList<DetailDTO> list = (ArrayList<DetailDTO>) session.getAttribute("CART");
                for (DetailDTO d : list) {
                    if (vegetableID.equals(d.getVeg().getVegetableID())) {
                        list.remove(d);
                        session.setAttribute("CART", list);
                        url = SUCCESS;
                    }
                }

            }
        } catch (Exception e) {
            log("Error :" + e.getMessage());
        } finally {
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
