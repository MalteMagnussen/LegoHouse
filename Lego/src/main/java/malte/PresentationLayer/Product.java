/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import malte.FunctionLayer.LogicFacade;
import malte.FunctionLayer.LoginSampleException;
import malte.entities.Order;

/**
 *
 * @author Malte
 */
public class Product extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String origin = (String) request.getParameter("origin");

        switch (origin) {
            case "addProduct": {
                return addProduct(request);
            }
            

        }
        return null;

    }

    private String addProduct(HttpServletRequest request) {
        String tempid = (String) request.getParameter("id");
        int id = Integer.parseInt(tempid);
        
        String tempLength = (String) request.getParameter("length");
        int length = Integer.parseInt(tempLength);
        
        String tempWidth = (String) request.getParameter("width");
        int width = Integer.parseInt(tempWidth);
        
        String tempHeight = (String) request.getParameter("height");
        int height = Integer.parseInt(tempHeight);
        
        Order order = LogicFacade.createOrder(id, length, width, height);
        
        
        
        return null;
    }
    
}
