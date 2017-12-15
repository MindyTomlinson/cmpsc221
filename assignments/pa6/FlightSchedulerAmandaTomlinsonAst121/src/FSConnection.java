import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FSConnection {

    private static final String URL = "jdbc:derby://localhost:1527/FlightSchedulerDBAmandaTomlinsonAst121";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
