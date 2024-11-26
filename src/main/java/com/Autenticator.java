package com;

import com.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Autenticator {

    @FXML
    private TextField Login;
    
    @FXML
    private TextField Senha;
    
    @FXML
    private void TelaCadastro() throws IOException {
        App.setRoot("Register");
        limparEspacos();
    }
    
    @FXML
    private void TelaMenu() throws IOException {
        App.setRoot("Home");
        limparEspacos();
    }
    
    private void limparEspacos(){
        Login.setText("");
        Senha.setText("");
    }
}
