/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import com.Dao;


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
        if(getSenha().equals(getConfirmarSenha())){
            App.setRoot("Home");
            Usuario usuario = new Usuario();
            usuario.setLogin(Login.getText());
            usuario.setSenha(Senha.getText());
            usuario.setNome(Nome.getText());
            dao.inserir(usuario);
            
            limparTextos();
        }
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