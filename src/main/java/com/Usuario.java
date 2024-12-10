package com;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Usuario {

    @BsonProperty(value="login")
    private String Login;
    
    @BsonProperty(value="nome")
    private String Nome;
    
    @BsonProperty(value="senha")
    private String Senha;
    
    
    public Usuario(){}

    public Usuario(String Login, String Nome, String Senha) {
        this.Login = Login;
        this.Nome = Nome;
        this.Senha = Senha;
    }
    

    public String getLogin(){
        return Login;
    }
    public void setLogin(String Login){
        this.Login = Login;
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
