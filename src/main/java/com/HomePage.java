package com;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HomePage {

    @FXML 
    private TextField Brinco;
    
    @FXML 
    private TextField NomeVaca;
    
    @FXML 
    private TextField RacaVaca;
    
    Dao<Vaca> dao;
    @FXML
    public void initialize() {
        dao = new Dao(Vaca.class);
    } 
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Autenticator");
    }
    
    @FXML
    private void cadastrarVaca() {
        Vaca vaca = new Vaca();
        vaca.setBrinco(Brinco.getText());
        vaca.setNome(NomeVaca.getText());
        vaca.setRaca(RacaVaca.getText());
        dao.inserir(vaca);
    }

    @FXML
    private void alterarVaca() {
        
    }

    @FXML
    private void removerVaca() {
        
    }
    
    @FXML
    private void limparCadastro(){
        Brinco.setText("");
        NomeVaca.setText("");
        RacaVaca.setText("");
    }
    
    @FXML
    private void sair() throws IOException{
        App.setRoot("Autenticator");
    }
}