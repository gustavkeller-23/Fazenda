package com;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomePage {

    // CAMPOS RELACIONADOS A ADICAO DE VACAS
    @FXML private TextField Brinco;
    @FXML private TextField NomeVaca;
    @FXML private TextField RacaVaca;
    @FXML private ComboBox<String> comboVacas;

    Dao<Vaca> daoVaca;



    // CAMPOS RELACIONADOS AO GERENCIADOR DE VACAS
    @FXML private TextField NomeVacaGerenciar;
    @FXML private TextField RacaVacaGerenciar;



    // CAMPOS RELACIONADOS AO GERENCIADOR DE USUARIO
    @FXML private TextField NomeUsuario;
    @FXML private TextField LoginUsuario;
    @FXML private TextField SenhaUsuario;

    Dao<Usuario> daoUsuario;



    // CAMPOS RELACIONADOS A PRODUCAO
    @FXML private TextField quantidadeProducao;
    @FXML private DatePicker dataProducao;
    @FXML private ComboBox<String> comboVacasProducao;


    // CAMPOS RELACIONADOS AO GERENCIADOR DA PRODUCAO
    @FXML private TextField quantidadeTotalProducao;
    @FXML private DatePicker dataProducaoGerenciar;
    @FXML private ComboBox<String> comboVacasProducaoGerenciar;

    @FXML private TableView<Producao> tabelaProducao;
    @FXML private TableColumn<Producao, String> colunaProducaoVaca;
    @FXML private TableColumn<Producao, String> colunaProducaoData;
    @FXML private TableColumn<Producao, Double> colunaProducaoQuantidade;

    Dao<Producao> daoProducao;

    Usuario usuarioAutenticado;

    @FXML
    public void initialize() {
        daoVaca = new Dao(Vaca.class);
        daoUsuario = new Dao(Usuario.class);
        daoProducao = new Dao(Producao.class);

        colunaProducaoVaca.setCellValueFactory(new PropertyValueFactory<>("vacaBrinco"));
        colunaProducaoData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaProducaoQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        
        carregarUsuario();
        carregarComboBoxes();
    } 


    private void carregarComboBoxes() {
        carregarVacas();
        carregarProducao();
        carregarProducaoGerenciar();
    }    


    @FXML
    private void cadastrarVaca() {
        if(daoVaca.buscarPorChave("brinco", Brinco.getText()) == null){
            Vaca vaca = new Vaca();
            vaca.setBrinco(Brinco.getText());
            vaca.setNome(NomeVaca.getText());
            vaca.setRaca(RacaVaca.getText());
            daoVaca.inserir(vaca);

            carregarComboBoxes();
            limparCadastroVaca();
        }
    }

    @FXML
    private void alterarVaca() {
        String brinco = comboVacas.getSelectionModel().getSelectedItem();;
        if (brinco == null) return;

        String novoNome = NomeVacaGerenciar.getText();
        String novaRaca = RacaVacaGerenciar.getText();

        Vaca vacaAtualizada = new Vaca(brinco, novoNome, novaRaca);
        daoVaca.alterar("brinco", brinco, vacaAtualizada);
    }

    @FXML
    private void atualizarCamposGerenciar() {
        String brinco = comboVacas.getSelectionModel().getSelectedItem();;
        if (brinco == null) return;

        Vaca vaca = daoVaca.buscarPorChave("brinco", brinco);
        if (vaca != null) {
            NomeVacaGerenciar.setText(vaca.getNome());
            RacaVacaGerenciar.setText(vaca.getRaca());
        }
    }

    @FXML
    private void removerVaca() {
        String brinco = comboVacas.getSelectionModel().getSelectedItem();;
        if (brinco == null) return;
        
        daoVaca.excluir("brinco", brinco);
        carregarComboBoxes(); 
        NomeVacaGerenciar.clear();
        RacaVacaGerenciar.clear();
    }
    
    private void carregarVacas() {
        comboVacas.getItems().clear();
        daoVaca.listarTodos().forEach(vaca -> comboVacas.getItems().add(vaca.getBrinco()));
    }

    @FXML
    private void limparCadastroVaca(){
        Brinco.setText("");
        NomeVaca.setText("");
        RacaVaca.setText("");
    }

    @FXML
    private void limparCadastroVacaGerenciar(){
        String brinco = comboVacas.getSelectionModel().getSelectedItem();;
        if (brinco == null) return;

        Vaca vaca = daoVaca.buscarPorChave("brinco", brinco);
        if (vaca != null) {
            NomeVacaGerenciar.setText(vaca.getNome());
            RacaVacaGerenciar.setText(vaca.getRaca());
        }
    }






    private void carregarUsuario() {
       usuarioAutenticado = UsuarioAuth.getUsuario();
       
       NomeUsuario.setText(usuarioAutenticado.getNome());
       LoginUsuario.setText(usuarioAutenticado.getLogin());
       SenhaUsuario.setText(usuarioAutenticado.getSenha());
    }

    @FXML
    private void alterarUsuario() {
        String Login = usuarioAutenticado.getLogin();
        if (Login == null) return;

        String newNome = NomeUsuario.getText();
        String newLSenha = SenhaUsuario.getText();

        Usuario usuarioAtualizado = new Usuario(Login, newNome, newLSenha);
        daoUsuario.alterar("login", Login, usuarioAtualizado);
    }

    @FXML
    private void removerUsuario() throws IOException {
        String Login = usuarioAutenticado.getLogin();
        if (Login == null) return;

        daoUsuario.excluir("login", Login);
        App.setRoot("Autenticator");
    }

    @FXML
    private void limparAlteracoesUsuario(){
        NomeUsuario.setText(usuarioAutenticado.getNome());
        SenhaUsuario.setText(usuarioAutenticado.getSenha());
    }

    @FXML
    private void sair() throws IOException{
        App.setRoot("Autenticator");
    }








    @FXML
    private void registrarProducao() {
        Producao producao = new Producao();
        
        String brinco = comboVacasProducao.getSelectionModel().getSelectedItem();;
        if (brinco == null) return;
        Vaca vaquinha = daoVaca.buscarPorChave("brinco", brinco);

        LocalDate data = dataProducao.getValue();      
        if (data == null) return;    

        producao.setVaca(vaquinha);
        producao.setData(data);
        producao.setQuantidade(quantidadeProducao.getText());
        daoProducao.inserir(producao);

        carregarProducaoGerenciar();
        limparRegistroProducao();
    }

    @FXML
    private void filtrarProducao() {
        String brinco = comboVacasProducaoGerenciar.getSelectionModel().getSelectedItem();
        LocalDate data = dataProducaoGerenciar.getValue();      

        if(brinco == null && data == null) return;
    
        if (data == null) {
            ObservableList<Producao> producoesFiltradas = FXCollections.observableArrayList(
                daoProducao.listarTodos().stream()
                    .filter(producao -> producao.getVacaBrinco() != null && producao.getVacaBrinco().equalsIgnoreCase(brinco))
                    .collect(Collectors.toList())
            );

            tabelaProducao.setItems(producoesFiltradas);
            atualizarTotalProducao(producoesFiltradas);
        
        } else if(brinco == null) {
            ObservableList<Producao> producoesFiltradas = FXCollections.observableArrayList(
            daoProducao.listarTodos().stream()
                .filter(producao -> producao.getData() != null && producao.getData().equals(data))
                .collect(Collectors.toList())
            );

            tabelaProducao.setItems(producoesFiltradas);
            atualizarTotalProducao(producoesFiltradas);

        } else {
            ObservableList<Producao> producoesFiltradas = FXCollections.observableArrayList(
            daoProducao.listarTodos().stream()
                .filter(producao -> producao.getVacaBrinco() != null && 
                        producao.getVacaBrinco().equalsIgnoreCase(brinco) && 
                        producao.getData() != null && 
                        producao.getData().equals(data))
                .collect(Collectors.toList())
            );

            tabelaProducao.setItems(producoesFiltradas);
            atualizarTotalProducao(producoesFiltradas);
        }
    }
    
    private void carregarProducao() {
        comboVacasProducao.getItems().clear();
        daoVaca.listarTodos().forEach(vaca -> comboVacasProducao.getItems().add(vaca.getBrinco()));
    }

    private void carregarProducaoGerenciar() {
        comboVacasProducaoGerenciar.getItems().clear();
        daoVaca.listarTodos().forEach(vaca -> comboVacasProducaoGerenciar.getItems().add(vaca.getBrinco()));
    }

    private void atualizarTotalProducao(ObservableList<Producao> producoes) {
        double total = producoes.stream()
            .mapToDouble(producao -> Double.parseDouble(producao.getQuantidade()))
            .sum();
        quantidadeTotalProducao.setText(String.format("%.2f", total));
    }

    @FXML
    private void limparRegistroProducao(){
        quantidadeProducao.setText("");
        dataProducao.setValue(null);
    }

    @FXML
    private void limparRegistroProducaoGerenciar(){
        tabelaProducao.getItems().clear();
        quantidadeTotalProducao.setText("");
        dataProducaoGerenciar.setValue(null);
        comboVacasProducaoGerenciar.setValue(null);
    }
}