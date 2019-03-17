package malte.FunctionLayer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import malte.DBAccess.OrderMapper;
import malte.entities.User;
import malte.DBAccess.UserMapper;
import malte.entities.Order;

/**
 * Facade Class.
 *
 * @author Malte
 */
public class LogicFacade {

    /**
     * User Login Facade.
     *
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws CustomException
     */
    public static User login(String email, String password) throws CustomException {
        return UserMapper.login(email, password);
    }

    /**
     * Create User Facade.
     *
     * @param email Users email.
     * @param password Users password.
     * @return User entity.
     * @throws CustomException
     */
    public static User createUser(String email, String password) throws CustomException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    /**
     * Create Order Facade.
     *
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

    /**
     * Get a List of all Orders for one User.
     *
     * @param user
     * @return
     * @throws CustomException
     */
    public static List<Order> getOrders(User user) throws CustomException {
        return OrderMapper.getOrders(user);
    }

    /**
     * 
     * @param user
     * @return
     * @throws CustomException 
     */
    public static List<User> getUsers(User user) throws CustomException {
        if (user.getRole().equals("employee")) {
            return UserMapper.getUsers();
        } else {
            throw new CustomException("Can't do this. You're not an employee.");
        }
    }

    public static Order getOrder(int id) throws CustomException {
        return OrderMapper.getOrder(id);
    }

    public static void sendOrder(int id) {
        OrderMapper.sendOrder(id);
    }
}
