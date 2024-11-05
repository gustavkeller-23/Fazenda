package com.mycompany;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomePage {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Autenticator");
    }
}