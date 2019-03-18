/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.FunctionLayer;

import malte.entities.BOM;
import malte.entities.Order;

/**
 *
 * @author Malte
 */
public interface BillOfOrder
{
    
    public BOM billOfOrder(Order order);
    
    public Order Order(BOM bom);
    
}
