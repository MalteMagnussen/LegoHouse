/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.PresentationLayer;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import malte.FunctionLayer.LogicFacade;
import malte.FunctionLayer.CustomException;
import malte.entities.Order;
import malte.entities.User;

/**
 *
 * @author Malte
 */
public class Product extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CustomException {
        String origin = (String) request.getParameter("origin");

        switch (origin) {
            // Adds an Order to the SQL.
            case "addProduct": {
                return addProduct(request);
            }
            case "order": {
                return order(request);
            }
            
        }
        return null;

    }

    /**
     * Adds an Order to the SQL.
     * @param request
     * @return
     * @throws CustomException 
     */
    private String addProduct(HttpServletRequest request) throws CustomException {
        String tempid = (String) request.getParameter("id");
        int id = Integer.parseInt(tempid);
        
        String tempLength = (String) request.getParameter("length");
        int length = Integer.parseInt(tempLength);
        
        String tempWidth = (String) request.getParameter("width");
        int width = Integer.parseInt(tempWidth);
        
        String tempHeight = (String) request.getParameter("height");
        int height = Integer.parseInt(tempHeight);
        
        Order order = LogicFacade.createOrder(id, length, width, height);
        HttpSession session = request.getSession();
        session.setAttribute("order", order);
        User user = (User) session.getAttribute("user");
        return user.getRole() + "page";
    }

    private String order(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        String date = (String) request.getParameter("date");
        
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        
        for (Order order: orders){
            if (order.getDate().equals(date)){
                session.setAttribute("order", order);
            }
        }
        
        User user = (User) session.getAttribute("user");
        return user.getRole() + "page";
    }
    
}
