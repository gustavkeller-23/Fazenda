package com.mycompany;

import java.io.IOException;
import javafx.fxml.FXML;

public class Autenticator {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("Home");
    }
}
