package servlets;

import business.Item;
import business.ShoppingList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = (String) request.getParameter("username");
        String action = request.getParameter("action");
        String basketItem = (String) request.getParameter("item");

        HttpSession session = request.getSession();

        ShoppingList shoppingList = (ShoppingList) session.getAttribute("shoppingList");
        if (shoppingList == null) {

            shoppingList = new ShoppingList();
        }

        if (action != null && action.equals("register") && user != null) {
            if (user == "") {
                request.setAttribute("message", "ENTER A USERNAME, WHATCHU TRYNA PULL WITH THIS BLANK CRAP?");
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            session.setAttribute("username", user);

        } else if (action != null && action.equals("add")) {
            if (basketItem == "") {
                
                request.setAttribute("message", "WHAT IS THIS, A SHOPPING LIST FOR WIZARDS?! NO BLANK ITEMS");
                request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            } else {
                
                Item item = new Item();
                item.setName(basketItem);
                shoppingList.addItem(item);
                session.setAttribute("shoppingList", shoppingList);
            }
        } else if (action != null && action.equals("delete")) {

            Item item = new Item();
            item.setName(basketItem);
            shoppingList.removeItem(item);
            session.setAttribute("shoppingList", shoppingList);

        } else if (action != null && action.equals("logout")) {

            request.setAttribute("message", "You are logged out.");
            session.invalidate();
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;

        } else {

            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        request.setAttribute("username", (String) session.getAttribute("username"));
        request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
