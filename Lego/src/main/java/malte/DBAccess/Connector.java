package malte.DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    private static final String URL = "jdbc:mysql://localhost:3306/useradmin";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties props = new Properties();
            props.put("user", USERNAME);
            props.put("password", PASSWORD);
            props.put("allowMultiQueries", true);
            props.put("useUnicode", true);
            props.put("useJDBCCompliantTimezoneShift", true);
            props.put("useLegacyDatetimeCode", false);
            props.put("serverTimezone", "CET");
            singleton = DriverManager.getConnection(URL, props);
            Connector.setConnection(singleton);
        }
        return singleton;
    }

}
