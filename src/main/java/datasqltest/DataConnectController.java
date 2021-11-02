package datasqltest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataConnectController {

//    @FXML
//    private Label showUserNameLabel;
//
//    public void connectButton(ActionEvent event){
//
//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectionDB = connectNow.getConnect();
//
//        String connectQuery = "SELECT name FROM `restadvisor`.`restaurant`";
//
//        try {
//
//            Statement statement = connectionDB.createStatement();
//            ResultSet queryOutput = statement.executeQuery(connectQuery);
//
//            while (queryOutput.next()){
//                showUserNameLabel.setText(queryOutput.getString("name"));
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
