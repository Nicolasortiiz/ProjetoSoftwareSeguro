package dao;

import model.Usuario;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    public UsuarioDAO(){
        conexao = conexao.getInstance();
    }
    public Usuario retornaUsuario(String emailLogin) {
        String email = null;
        String nomeUsuario = null;
        try {
            query = "SELECT email, nome_usuario FROM usuario WHERE email = ?";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setString(1, emailLogin);
            rs = ps.executeQuery();
            if (rs.next()) {
                email = rs.getString("email");
                nomeUsuario = rs.getString("nome_usuario");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Usuario(email, nomeUsuario);
    }
    public int retornaIdUsuario(Usuario usuario){
        int id = 0;
        try {
            query = "SELECT id FROM usuario WHERE email = ?";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setString(1, usuario.getEmail());
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    public void criarUsuario(Usuario usuario){
        try {
            query = "INSERT INTO usuario (email,nome_usuario) VALUES (?, ?)";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getNomeUsuario());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String retornaNomeUsuario(int id){
        String nome = null;
        try {
            query = "SELECT nome_usuario FROM usuario WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                nome = rs.getString("nome_usuario");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nome;
    }
}
