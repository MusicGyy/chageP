module com.example.datasqltest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens datasqltest to javafx.fxml;
    exports datasqltest;
//    exports com.example.datasqltest.controller;
//    opens com.example.datasqltest.controller to javafx.fxml;
////    exports com.example.datasqltest.servise;
//    opens com.example.datasqltest.servise to javafx.fxml;
}