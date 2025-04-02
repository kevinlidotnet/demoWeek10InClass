module org.example.demoweek10inclass {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.dynalink;


    opens org.example.demoweek10inclass to javafx.fxml;
    exports org.example.demoweek10inclass;
}