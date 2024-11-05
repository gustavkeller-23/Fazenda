package com.mycompany;

import org.bson.codecs.pojo.annotations.BsonProperty;


public class Usuario {
    @BsonProperty(value="CPF")
    private Integer CPF;
    
    @BsonProperty(value="nome")
    private String Nome;
    
    @BsonProperty(value="senha")
    private String Senha;
    
    
    public Integer getCPF(){
        return CPF;
    }
    public void setCPF(Integer CPF){
        this.CPF = CPF;
    }
    
    
    public String getNome(){
        return Nome;
    }
    public void setNome(String Nome){
        this.Nome = Nome;
    }
    
    
    public String getSenha(){
        return Senha;
    }
    public void setSenha(String Senha){
        this.Senha = Senha;
    }
}
