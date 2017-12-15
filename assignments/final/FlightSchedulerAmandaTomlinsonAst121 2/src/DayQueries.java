
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DayQueries {

    private Connection connection;
    private PreparedStatement selectAllDays;
    private PreparedStatement insertNewDay;
    public static final int DUPKEY = 0;
    public static final int FAIL = -1;

    public DayQueries() {

        try {
            connection = FSConnection.getConnection();
            selectAllDays = connection.prepareStatement(
                    "SELECT * FROM DAYS "
                            + "ORDER BY DATE ASC");
            insertNewDay = connection.prepareStatement(
                    "INSERT INTO DAYS (DATE) VALUES (?)");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LocalDate> getAllDays() {
        ArrayList<LocalDate> days = new ArrayList<>();
        ResultSet resultSet;

        try {
            resultSet = selectAllDays.executeQuery();

            while (resultSet.next()) {
                days.add(resultSet.getDate("Date").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return days;
    }

    public int addDay(LocalDate day) {
        int result;
        try {
            insertNewDay.setDate(1, java.sql.Date.valueOf(day));
            result = insertNewDay.executeUpdate(); // 1 if day added
        }
        catch (SQLIntegrityConstraintViolationException e) {
            result = DUPKEY; // Day already exists
        }

        catch (SQLException e) {
            e.printStackTrace();
            result = FAIL; // Failed
        }

        return result;
    }
}
