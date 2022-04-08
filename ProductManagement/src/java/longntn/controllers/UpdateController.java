/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longntn.vegetable.VegetableDAO;
import longntn.vegetable.VegetableDTO;
import longntn.vegetable.VegetableErrorDTO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    public static final String ERROR = "admin.jsp";
    public static final String SUCCESS = "SearchController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        VegetableErrorDTO vegError = new VegetableErrorDTO();
        try {
            String vegID = request.getParameter("vegID");
            String vegName = request.getParameter("vegName");
            String vegPrice = request.getParameter("vegPrice");
            String vegQuantity = request.getParameter("vegQuantity");
            String vegImage = request.getParameter("vegImage");
            String vegStatus = request.getParameter("vegStatus");
            String vegCategory = request.getParameter("vegCategory");
            boolean check = true;
            VegetableDAO dao = new VegetableDAO();

            if (vegName.length() < 5 || vegName.length() > 20) {
                vegError.setVegetableNameError("Vegetable Name must be in [5,20]");
                check = false;
            }
            if (vegName.trim().isEmpty()) {
                vegError.setVegetableNameError("Name can not be empty");
                check = false;
            }
            if (vegPrice.isEmpty()) {
                vegError.setPriceError("Price not empty");
                check = false;
            }
            String regexNumber = "^[.0-9]{0,}$";
            Pattern pattern = Pattern.compile(regexNumber);
            Matcher matcher = pattern.matcher(vegPrice);
            if (!matcher.find()) {
                vegError.setPriceError("Price must be number and positve");
                check = false;
            }
            if (vegQuantity.isEmpty()) {
                vegError.setQuantityError("Quantity not empty ");
                check = false;
            }
            Matcher matcherQuantity = pattern.matcher(vegQuantity);
            if (!matcherQuantity.find()) {
                vegError.setQuantityError("Quantity must be number and positve");
                check = false;
            }

            if (vegStatus.equals("Active") || vegStatus.equals("InActive")) {

            } else {
                vegError.setStatusError("Status must be Active or InActive");
                check = false;
            }
            if (vegImage.isEmpty()) {
                vegError.setImageError("Enter a file image");
                check = false;
            }
            if (vegCategory.trim().isEmpty()) {
                vegError.setCategoryIDError("Category not empty");
                check = false;
            }
            if (!vegCategory.equals("vegetable") || vegCategory.equals("fruit") || vegCategory.equals("yogurt")){
                vegError.setCategoryIDError("Category is only in one of these: vegetable, fruit, yogurt");
                check = false;
            }
            if (check) {
                VegetableDTO vegetable = new VegetableDTO(vegID, vegName, vegStatus, vegImage, vegCategory, Integer.parseInt(vegQuantity), Float.parseFloat(vegPrice));
                dao.updateVegetable(vegetable);
                url = SUCCESS;
            } else {
                List<VegetableDTO> listVeg = dao.getAllVegetable();
                request.setAttribute("LIST_VEGETABLE", listVeg);
                request.setAttribute("VEGETABLE_ERROR", vegError);
            }

        } catch (Exception e) {
            log("Error at Update Controller" + e.toString());
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
