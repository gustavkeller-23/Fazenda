package com;

import java.io.IOException;

import javafx.scene.control.TextField;

public class HomePage_VacaFunctions {

    private TextField Brinco;
    private TextField NomeVaca;
    private TextField RacaVaca;
    
    Dao<Vaca> dao;

    private void cadastrarVaca() {
        if(!dao.buscarPorChave("brinco:", Brinco.getText())){
            Vaca vaca = new Vaca();
            vaca.setBrinco(Brinco.getText());
            vaca.setNome(NomeVaca.getText());
            vaca.setRaca(RacaVaca.getText());
            dao.inserir(vaca);
        }
    }

    private void alterarVaca() {
        
    }

    private void removerVaca() {
        
    }
    
}