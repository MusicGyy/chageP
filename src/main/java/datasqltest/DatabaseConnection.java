package datasqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

//    public static Connection getConnect() throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/restadvisor","root","90090080zZ.");
//
//        return connection;
//    }

    public Connection dataLink;

    public Connection getConnection(){
        String databaseName = "microchip";
        String databaseUser = "";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" +databaseName;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dataLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
        }

        return dataLink;

    }
}

