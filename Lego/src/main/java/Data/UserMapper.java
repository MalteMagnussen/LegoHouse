package Data;

import Data.Entities.User;
import Data.Exceptions.LoginException;
import Data.Exceptions.ShopException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDAO
 *
 * @author Malte
 */
class UserMapper
{

    private static UserMapper instance = null;

    synchronized static UserMapper getInstance()
    {
        if (instance == null)
        {
            instance = new UserMapper();
        }
        return instance;
    }

    /**
     * Create User Method.
     *
     * Inputs a User into the SQL database.
     *
     * @param user Entity
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     */
    void createUser(User user) throws LoginException
    {
        try
        {
            Connection con = new Connector().getConnection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | LoginException ex)
        {
            throw new LoginException("User already exists: " + ex.getMessage());
        }
    }

    /**
     * Login Method.
     *
     * Pulls a User entity from the SQL if the User input correct info into the
     * form. Else throws an exception and returns User to the index page.
     *
     * @param email Users email
     * @param password Users password
     * @return User entity
     * @throws LoginException Custom Exception. Caught in FrontController. Sends
     * User back to index.jsp.
     * @throws Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    User login(String email, String password) throws LoginException, ShopException
    {
        try
        {
            Connection con = new Connector().getConnection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                if (user.getRole().equals("customer"))
                {
                    OrderMapper db = new OrderMapper();
                    user.setOrders(db.getOrders(user));
                }
                return user;
            } else
            {
                throw new LoginException("Could not validate user");
            }
        } catch (SQLException | LoginException ex)
        {
            throw new LoginException(ex.getMessage());
        }
    }

    /**
     * Get all Users
     *
     * @return List of all Users.
     * @throws Data.Exceptions.ShopException Custom Exception. Caught in
     * FrontController. Sends User back to /WEB-INF/customerpage.jsp
     */
    List<User> getUsers() throws ShopException
    {
        List<User> users = new ArrayList<>();
        try
        {

            Connection con = new Connector().getConnection();
            String SQL = "SELECT * FROM useradmin.users;";
            ResultSet rs = con.prepareStatement(SQL).executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                User user = new User(email, password, role);
                user.setId(id);
                OrderMapper db = new OrderMapper();
                user.setOrders(db.getOrders(user));

                users.add(user);

            }

        } catch (SQLException | LoginException ex)
        {
            throw new ShopException(ex.getMessage());
        } 
        return users;
    }
}
