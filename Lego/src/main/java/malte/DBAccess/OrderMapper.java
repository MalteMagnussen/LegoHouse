/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malte.DBAccess;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import malte.FunctionLayer.LoginSampleException;

/**
 *
 * @author Malte
 */
public class OrderMapper {
    
    public static void createOrder( Order order ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (idorders, length, width, height) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
//            ps.setString( 1, order.getEmail() );
//            ps.setString( 2, order.getPassword() );
//            ps.setString( 3, user.getRole() );
//            ps.executeUpdate();
//            ResultSet ids = ps.getGeneratedKeys();
//            ids.next();
//            int id = ids.getInt( 1 );
//            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}
