package com;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class RegisterController{

    @FXML
    private TextField Login;
    
    @FXML
    private TextField Senha;
    
    @FXML
    private TextField ConfirmarSenha;
    
    @FXML
    private TextField Nome;
    
    Dao<Usuario> dao;

    @FXML
    public void initialize() {
        dao = new Dao(Usuario.class);
    }    
    
    @FXML
    private void cancelarCadastro() throws IOException {
        App.setRoot("Autenticator");
        limparTextos();
    }

    @FXML
    private void concluirCadastro() throws IOException {
        if(getSenha().equals(getConfirmarSenha()) &&
           dao.buscarPorChave("login", Login.getText()) == null){
            Usuario usuario = new Usuario();
            usuario.setLogin(Login.getText());
            usuario.setSenha(Senha.getText());
            usuario.setNome(Nome.getText());
            dao.inserir(usuario);
            
            App.setRoot("Home");
        }
        limparTextos();
    }    
    
    
    public String getLogin() {
        return Login.getText();
    }

    public String getSenha() {
        return Senha.getText();
    }

    public String getConfirmarSenha() {
        return ConfirmarSenha.getText();
    }

    public String getNome() {
        return Nome.getText();
    }
    
    public void limparTextos(){
        Nome.setText("");
        Login.setText("");
        Senha.setText("");
        ConfirmarSenha.setText("");
    }
}
