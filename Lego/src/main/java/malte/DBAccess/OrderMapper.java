/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.DBAccess;

import malte.FunctionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import malte.FunctionLayer.LoginSampleException;
import malte.FunctionLayer.User;

/**
 *
 * @author Malte
 */
public class OrderMapper {
    
    public static void createOrder( Order order ) throws LoginSampleException {
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
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}
