package model;

public class Usuario {
    private final String email;
    private final String nomeUsuario;

    public Usuario(String email, String nomeUsuario) {
        this.email = email;
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}