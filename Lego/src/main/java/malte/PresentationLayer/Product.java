/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import malte.FunctionLayer.LogicFacade;
import malte.FunctionLayer.CustomException;
import malte.entities.Order;

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
        request.getSession().setAttribute("order", order);
        
        // TO DO - Return proper String for where you want user to go now.
        return null;
    }
    
}
