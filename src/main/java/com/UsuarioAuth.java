package com;

public class UsuarioAuth {

    private static Usuario usuario;

    public UsuarioAuth() {}

    public UsuarioAuth(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioAuth.usuario = usuario;
    }
}
