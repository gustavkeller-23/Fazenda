package com;

import java.time.LocalDate;

public class Producao {

    private Vaca vaca;
    private LocalDate data;
    private String quantidade;
    
    public Producao(){}

    public Producao(Vaca vaca, LocalDate data, String quantidade) {
        this.vaca = vaca;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Vaca getVaca() {
        return vaca;
    }

    public void setVaca(Vaca vaca) {
        this.vaca = vaca;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getVacaBrinco() {
        return vaca.getBrinco();  
    }
}