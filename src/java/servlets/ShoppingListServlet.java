/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Item;
import business.ShoppingList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author 725899
 */
public class ShoppingListServlet extends HttpServlet {


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
            String actionParam = request.getParameter("action");
            String usernameParam = (String) request.getParameter("username");
            String itemParam = (String) request.getParameter("item");
            
            //initalizing session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*2);
            ShoppingList shoppingList = (ShoppingList) session.getAttribute("shoppingList");
            if (shoppingList == null) {
                shoppingList = new ShoppingList();
            }
            
            //action = register
            if (actionParam != null && actionParam.equals("register") && usernameParam != null && !usernameParam.equals("")) {
                session.setAttribute("username", usernameParam);
            }
            
            //action = add
            else if (actionParam != null && actionParam.equals("add")) {
                Item item = new Item();
                item.setName(itemParam);
                shoppingList.addItem(item);
               
                session.setAttribute("shoppingList", shoppingList);
            }
            
            //action = delete
            else if (actionParam != null && actionParam.equals("delete")) {
                Item item = new Item();
                item.setName(itemParam);
                shoppingList.removeItem(item);
                
                session.setAttribute("shoppingList", shoppingList);
            }
            
            //action = logout
            else if (actionParam != null && actionParam.equals("logout")) {
                request.setAttribute("message", "You are logged out.");
                session.invalidate();
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            
            //no action command
            else {
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            
            request.setAttribute("username", (String)session.getAttribute("username"));
            request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
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
