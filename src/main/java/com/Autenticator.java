package com;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Autenticator {

    @FXML
    private TextField Login;
    
    @FXML
    private TextField Senha;
    
    Dao<Usuario> dao;

    @FXML
    public void initialize() {
        dao = new Dao(Usuario.class);
    }

    @FXML
    private void TelaCadastro() throws IOException {
        App.setRoot("Register");
        limparEspacos();
    }
    
    @FXML
    private void TelaMenu() throws IOException {
        Usuario user = dao.buscarPorChave("login", Login.getText());
        if(user != null && Senha.getText().equals(user.getSenha())){
            UsuarioAuth usuario = new UsuarioAuth(user);
            App.setRoot("Home");
        }
        limparEspacos();
    }
    
    private void limparEspacos(){
        Login.setText("");
        Senha.setText("");
    }
}
