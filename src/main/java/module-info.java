module com.mycompany {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany to javafx.fxml;
    exports com.mycompany;
    requires org.mongodb.driver.core;
    requires java.base;
}