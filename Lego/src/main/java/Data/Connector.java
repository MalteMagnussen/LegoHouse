package Data;

import Data.Exceptions.LoginException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Connector Class.
 * 
 */
class Connector
{

    /** 
     * Only change these to fit your personal SQL.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/useradmin";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // Don't touch anything below this line.
    private Connection singleton = null;

    public Connector() throws LoginException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Properties props = new Properties();
            props.put("user", USERNAME);
            props.put("password", PASSWORD);
            props.put("allowMultiQueries", true);
            props.put("useUnicode", true);
            props.put("autoReconnect", true);
            props.put("useJDBCCompliantTimezoneShift", true);
            props.put("useLegacyDatetimeCode", false);
            props.put("serverTimezone", "CET");
            this.singleton = DriverManager.getConnection(URL, props);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex)
        {
            throw new LoginException("Connector went wrong: " + ex.getMessage());
        }  
    }
    
    public Connection getConnection() {
        return this.singleton;
    }
    
    

}
