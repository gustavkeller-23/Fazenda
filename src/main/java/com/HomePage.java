package com;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class HomePage {

    // CAMPOS RELACIONADOS A ADICAO DE VACAS
    @FXML private TextField Brinco;
    @FXML private TextField NomeVaca;
    @FXML private TextField RacaVaca;
    @FXML private ComboBox<Vaca> comboVacas;

    Dao<Vaca> dao;
    Dao<Vaca> daoVaca;



    // CAMPOS RELACIONADOS AO GERENCIADOR DE VACAS
    @FXML private TextField NomeVacaGerenciar;
    @FXML private TextField RacaVacaGerenciar;

    Dao<Producao> daoProducao;



    // CAMPOS RELACIONADOS AO GERENCIADOR DE USUARIO
    @FXML private TextField NomeUsuario;
    @FXML private TextField LoginUsuario;
    @FXML private TextField SenhaUsuario;

    Dao<Usuario> daoUsuario;



    // CAMPOS RELACIONADOS A PRODUCAO
    @FXML private TextField quantidadeProducao;
    @FXML private DatePicker dataProducao;
    @FXML private ComboBox<Vaca> comboVacasProducao;


    // CAMPOS RELACIONADOS AO GERENCIADOR DA PRODUCAO
    @FXML private TextField quantidadeProducaoGerenciar;
    @FXML private DatePicker dataProducaoGerenciar;
    @FXML private ComboBox<Vaca> comboVacasProducaoGerenciar;




    @FXML
    public void initialize() {
        daoVaca = new Dao(Vaca.class);

        carregarVacas();
    } 
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Autenticator");
    }
    
    //ObservableList<Vaca> itensComboBox = FXCollections.observableArrayList(vacasCadastradas);
    //comboVacas.setItems(itensComboBox);


    @FXML
    private void cadastrarVaca() {
        if(dao.buscarPorChave("brinco:", Brinco.getText()) != null){
            Vaca vaca = new Vaca();
            vaca.setBrinco(Brinco.getText());
            vaca.setNome(NomeVaca.getText());
            vaca.setRaca(RacaVaca.getText());
            dao.inserir(vaca);
        }
    }

    @FXML
    private void alterarVaca() {
        NomeVaca.getText();
        RacaVaca.getText();
        //dao.alterar("brinco", vaca.brinco, Brinco.getText());
    }

    @FXML
    private void atualizarCampos() {
        //selecionada = comboVacas.getValue();
    }

    @FXML
    private void removerVaca() {
        //dao.excluir("brinco", comboVacas.getText());
    }
    
    private void carregarVacas() {
        comboVacas.getItems().clear();
        // daoVaca.listarTodos().forEach(vaca -> comboVacas.getItems().add(vaca.getBrinco()));
    }

    @FXML
    private void limparCadastroVaca(){
        Brinco.setText("");
        NomeVaca.setText("");
        RacaVaca.setText("");
    }







    @FXML
    private void alterarUsuario() {
       
    }

    @FXML
    private void removerUsuario() {
        //dao.excluir("brinco", comboVacas.getText());
    }

    @FXML
    private void limparCadastroUsuario(){
        NomeUsuario.setText("");
        LoginUsuario.setText("");
        SenhaUsuario.setText("");
    }







    @FXML
    private void registrarProducao() {
        if(dao.buscarPorChave("brinco:", Brinco.getText()) != null){
            Vaca vaca = new Vaca();
            vaca.setBrinco(Brinco.getText());
            vaca.setNome(NomeVaca.getText());
            vaca.setRaca(RacaVaca.getText());
            dao.inserir(vaca);
        }
    }

    @FXML
    private void alterarProducao() {
        
    }

    @FXML
    private void atualizarCamposProducao() {
    }

    @FXML
    private void removerProducao() {

    }
    
    @FXML
    private void limparRegistroProducao(){
    }


    @FXML
    private void limparRegistroProducaoGerenciar(){
    }




    
    @FXML
    private void sair() throws IOException{
        App.setRoot("Autenticator");
    }
}