/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.View;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.Controller.LogicFacade;
import malte.Controller.LoginException;
import malte.Controller.ShopException;
import malte.Model.entities.BOM;
import malte.Model.entities.Order;
import malte.Model.entities.User;

/**
 * Product class. Contains methods to do with the orders. Add Product, Order,
 * Show all orders, Send an order.
 *
 * @author Malte
 */
public class Product extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, ShopException
    {
        String origin = request.getParameter("origin");

        switch (origin)
        {
            // Adds an Order to the SQL - From customerpage.jsp
            case "addProduct":
            {
                return addProduct(request);
            }
            // Get one order - From customerpage.jsp
            case "order":
            {
                return order(request);
            }
            // Get one order - From employeepage.jsp
            case "employeeorders":
            {
                return employeeorder(request);
            }
            // Mark an order as sent - From employeepage.jsp
            case "sendOrder":
            {
                return sendOrder(request);
            }

        }
        throw new LoginException("Something went wrong in Product.java");

    }

    /**
     * Adds an Order to the SQL.
     *
     * @param request
     * @return
     * @throws LoginException
     */
    private String addProduct(HttpServletRequest request) throws LoginException, ShopException
    {
        String tempid = request.getParameter("id");
        int id = Integer.parseInt(tempid);

        String tempLength = request.getParameter("length");
        int length = Integer.parseInt(tempLength);

        String tempWidth = request.getParameter("width");
        int width = Integer.parseInt(tempWidth);

        String tempHeight = request.getParameter("height");
        int height = Integer.parseInt(tempHeight);

        if (height < 4 || width < 5 || length < 8)
        {
            throw new ShopException("Too low width, height or length. Try again.");
        }

        User user = putOrderOnUser(request, id, length, width, height);

        return user.getRole() + "page";
    }

    private User putOrderOnUser(HttpServletRequest request, int id, int length, int width, int height) throws LoginException
    {
        HttpSession session = request.getSession();
        Order order = LogicFacade.createOrder(id, length, width, height);
        User user = (User) session.getAttribute("user");
        List<Order> orders = user.getOrders();
        orders.add(order);
        user.setOrders(orders);
        session.setAttribute("orders", orders);
        return user;
    }

    /**
     * Get one Order.
     *
     * @param request
     * @return
     */
    private String order(HttpServletRequest request)
    {
        HttpSession session = request.getSession();

        String tempid = request.getParameter("id");
        int id = Integer.parseInt(tempid);
        User user = (User) session.getAttribute("user");
        
        orderlogic(user, id, session);

        return user.getRole() + "page";
    }

    private void orderlogic(User user, int id, HttpSession session)
    {
        List<Order> orders = user.getOrders();
        if (orders == null){
            orders = new ArrayList<>();
        }
        for (Order order : orders)
        {
            if (order.getId() == id)
            {
                session.setAttribute("order", order);
                BOM bom = LogicFacade.getBOM(order);
                session.setAttribute("BOM", bom);
            }
        }
    }

    /**
     * Used by a logged in Employee to get an order.
     *
     * @param request
     * @return
     * @throws LoginException
     */
    private String employeeorder(HttpServletRequest request) throws LoginException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int id = Integer.parseInt(request.getParameter("id"));

        Order order = LogicFacade.getOrder(id);

        session.setAttribute("order", order);
        BOM bom = LogicFacade.getBOM(order);
        session.setAttribute("BOM", bom);
        
        session.setAttribute("users", LogicFacade.getUsers(user));

        return user.getRole() + "page";
    }

    /**
     * Sends an order to the customer. Used by Employee to mark an order as
     * sent.
     *
     * @param request
     * @return
     * @throws LoginException
     */
    private String sendOrder(HttpServletRequest request) throws LoginException
    {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        LogicFacade.sendOrder(id);
        
        Order order = LogicFacade.getOrder(id);
        order.setSent(true);
        session.setAttribute("order", order);
        BOM bom = LogicFacade.getBOM(order);
        session.setAttribute("BOM", bom);
        
        User user = (User) session.getAttribute("user");
        session.setAttribute("users", LogicFacade.getUsers(user));

        return user.getRole() + "page";
    }

}
