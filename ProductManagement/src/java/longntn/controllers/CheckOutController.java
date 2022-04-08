/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longntn.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longntn.detail.DetailDAO;
import longntn.detail.DetailDTO;
import longntn.order.OrderDAO;
import longntn.order.OrderDTO;
import longntn.users.UserDAO;
import longntn.users.UserDTO;
import longntn.users.UserErrorDTO;
import longntn.vegetable.VegetableDAO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "UserController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        VegetableDAO vegDAO = new VegetableDAO();
        OrderDAO orderDAO = new OrderDAO();
        UserDAO userDAO = new UserDAO();
        DetailDAO detailDAO = new DetailDAO();
        HttpSession session = request.getSession();
        ArrayList<DetailDTO> list = (ArrayList<DetailDTO>) session.getAttribute("CART");
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        try {
            if (user == null) {
                url = "LogoutController";
            } else {

                if (list != null) {
                    float total = Float.parseFloat(request.getParameter("total"));
                    String userID = request.getParameter("userID");
                    String userName = request.getParameter("name");
                    String phone = request.getParameter("phone");
                    String address = request.getParameter("address");
                    UserErrorDTO err = new UserErrorDTO();

                    if (address.isEmpty()) {
                        err.setAddressError("Address not empty");
                        check = false;
                    }
                    if (userName.isEmpty()) {
                        err.setFullNameError("UserName not empty");
                        check = false;
                    }
                    String regexPhone = "(03|09|08)+([0-9]{8})\\b";
                    Pattern pattern = Pattern.compile(regexPhone);
                    Matcher matcher = pattern.matcher(phone);
                    if (!matcher.find()) {
                        err.setPhoneError("Phease input phone number valid format [0865601931] Length[10] ");
                        check = false;
                    }
                    for (DetailDTO detailDTO1 : list) {
                        int checkQuantity = vegDAO.getQuantityByID(detailDTO1.getVeg().getVegetableID());
                        if (detailDTO1.getVeg().getStatus().equals("Active")) {
                            if (detailDTO1.getQuantity() > checkQuantity) {
                                request.setAttribute("ERR", "The number of " + detailDTO1.getVeg().getVegetableName() + " is not enough");
                                check = false;
                                url = "cart.jsp";
                            }
                        } else {
                            request.setAttribute("ERR", detailDTO1.getVeg().getVegetableName() + " product is no longer active");
                            check = false;
                            url = "cart.jsp";
                        }
                    }
                    if (check) {

                        if (orderDAO.insertOrder(new OrderDTO(0, userID, userName, phone, address, new Date(), total)) != -1) {
                            for (DetailDTO detailDTO : list) {
                                int orderID = orderDAO.getOrderID();
                                detailDTO.setOrderID(orderID);
                                if (detailDAO.insertDetail(detailDTO) != -1) {
                                    int CurQuantity = vegDAO.getQuantityByID(detailDTO.getVeg().getVegetableID());
                                    String vegetableID = detailDTO.getVeg().getVegetableID();
                                    int Quantity = CurQuantity - detailDTO.getQuantity();
                                    boolean result = vegDAO.updateQuantity(vegetableID, Quantity);
                                }
                            }
                            session.setAttribute("CART", null);
                            request.setAttribute("CHECK_OUT", "Buy Successfully!");
                            url = SUCCESS;

                        }
                    } else {
                        request.setAttribute("ERROR_CREATE", err);
                    }

                }

            }
        } catch (Exception e) {
            log("Error: " + e.getMessage());
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
