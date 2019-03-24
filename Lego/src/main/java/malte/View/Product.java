package malte.View;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.Controller.ControllerFacade;
import malte.Model.Exceptions.LoginException;
import malte.Model.Exceptions.ShopException;
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
        String tempWidth = request.getParameter("width");
        String tempHeight = request.getParameter("height");

        int length = 0;
        int width = 0;
        int height = 0;

        if (((((tempLength == null || tempWidth == null) || tempHeight == null) || tempLength.isEmpty()) || tempWidth.isEmpty()) || tempHeight.isEmpty())
        {
            throw new ShopException("Neither length, width, or height can be empty.");
        } else
        {
            length = Integer.parseInt(tempLength);
            width = Integer.parseInt(tempWidth);
            height = Integer.parseInt(tempHeight);
        }

        User user = putOrderOnUser(request, id, length, width, height);

        return user.getRole() + "page";
    }

    /**
     * Help Method for addProduct.
     *
     * @param request
     * @param id
     * @param length
     * @param width
     * @param height
     * @return
     * @throws LoginException
     * @throws ShopException
     */
    private User putOrderOnUser(HttpServletRequest request, int id, int length, int width, int height) throws LoginException, ShopException
    {
        HttpSession session = request.getSession();
        Order order = ControllerFacade.createOrder(id, length, width, height);
        User user = (User) session.getAttribute("user");
        List<Order> orders = user.getOrders();
        if (orders == null)
        {
            orders = new ArrayList<>();
        }
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

    /**
     * Help method for order.
     *
     * @param user
     * @param id
     * @param session
     */
    private void orderlogic(User user, int id, HttpSession session)
    {
        List<Order> orders = user.getOrders();
        for (Order order : orders)
        {
            if (order.getId() == id)
            {
                session.setAttribute("order", order);
                BOM bom = ControllerFacade.getBOM(order);
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
    private String employeeorder(HttpServletRequest request) throws LoginException, ShopException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int id = Integer.parseInt(request.getParameter("id"));

        Order order = ControllerFacade.getOrder(id);

        session.setAttribute("order", order);
        BOM bom = ControllerFacade.getBOM(order);
        session.setAttribute("BOM", bom);

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
    private String sendOrder(HttpServletRequest request) throws LoginException, ShopException
    {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        ControllerFacade.sendOrder(id);

        orderOnSessionSent(session, id);

        User user = (User) session.getAttribute("user");
        return user.getRole() + "page";
    }

    /**
     * Help method for sendOrder.
     *
     * @param session
     * @param id
     */
    private void orderOnSessionSent(HttpSession session, int id)
    {
        List<User> users = (List<User>) session.getAttribute("users");
        for (User user : users)
        {
            for (Order order : user.getOrders())
            {
                if (order.getId() == id)
                {
                    order.setSent(true);
                    session.setAttribute("order", order);
                }
            }
        }
        session.setAttribute("users", users);
    }

}
