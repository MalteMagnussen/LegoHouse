package malte.FunctionLayer;

import malte.DBAccess.OrderMapper;
import malte.entities.User;
import malte.DBAccess.UserMapper;
import malte.entities.Order;

/**
 * Facade Class.
 * @author Malte
 */
public class LogicFacade {

    /**
     * User Login Facade.
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws CustomException 
     */
    public static User login( String email, String password ) throws CustomException {
        return UserMapper.login( email, password );
    } 

    /**
     * Create User Facade.
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws CustomException 
     */
    public static User createUser( String email, String password ) throws CustomException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    /**
     * Create Order Facade.
     * @param id Users ID
     * @param length LegoHouse Length
     * @param width LegoHouse Width
     * @param height LegoHouse Height
     * @return Order entity.
     * @throws CustomException
     */
    public static Order createOrder(int id, int length, int width, int height) throws CustomException {
        Order order = new Order();
        order.setIdorders(id);
        order.setLength(length);
        order.setWidth(width);
        order.setHeight(height);
        OrderMapper.createOrder(order);
        return order;
    }

}
