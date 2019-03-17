package malte.DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import malte.FunctionLayer.CustomException;
import malte.entities.User;

public class UserMapper {

    /**
     * Create User Method.
     * 
     * Inputs a User into the SQL database.
     * 
     * @param user Entity
     * @throws CustomException 
     */
    public static void createUser( User user ) throws CustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new CustomException( ex.getMessage() );
        }
    }

    /**
     * Login Method.
     * 
     * Pulls a User entity from the SQL if the User input correct info into the form.
     * Else throws an exception and returns User to the index page.
     * 
     * @param email Users email
     * @param password Users password
     * @return User entity
     * @throws CustomException 
     */
    public static User login( String email, String password ) throws CustomException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new CustomException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new CustomException(ex.getMessage());
        }
    }

}
