//package datasqltest;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class TableController implements Initializable {
//
//    public DatabaseConnection databaseConnection;
//
//    @FXML
//    private TableView<ModelTable> table;
//    @FXML
//    private TableColumn<ModelTable, String> table_id;
//    @FXML
//    private TableColumn<ModelTable, String> table_name;
//    @FXML
//    private TableColumn<ModelTable, String> table_addess;
//    @FXML
//    private TableColumn<ModelTable, String> table_phone;
//
//    ObservableList<ModelTable> observableList = FXCollections.observableArrayList();
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        try {
//            Connection connection = DatabaseConnection.getConnect();
//
//            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM restadvisor.name");
//
//            while (resultSet.next()){
//                observableList.add(new ModelTable(resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getString("addess"),
//                        resultSet.getString("phone")));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TableController.class.getName()).log(Level.SEVERE, null, ex );
//        }
//        table_id.setCellValueFactory(new PropertyValueFactory<>("id"));
//        table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        table_addess.setCellValueFactory(new PropertyValueFactory<>("addess"));
//        table_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
//
//        table.setItems(observableList);
//
//    }
//}
