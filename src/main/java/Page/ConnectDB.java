package Page;

import java.sql.*;

/**
 * Created by Admin on 06.09.2017.
 */
public class ConnectDB {

    static final String DB_URL = "jdbc:postgresql://192.168.1.65:5432/osbb";
    static final String USER = "postgres";
    static final String PASS = "a8f59cc9c8";
    Connection connection;
    public ConnectDB() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public boolean executeQuery(String SQL) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                System.out.print("Столбец 1 возвращен");
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int executeUpdate(String SQL) {
        int result = -1;
        try {
            Statement st = connection.createStatement();
            result = st.executeUpdate(SQL);
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
//"SELECT * FROM users WHERE login = 'autotestosbb@gmail.com'"
