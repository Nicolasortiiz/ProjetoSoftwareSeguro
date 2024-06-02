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
    public Usuario retornaUsuario(Usuario usuario) {
        String email = null;
        String nomeUsuario = null;
        try {
            query = "SELECT email, nome_usuario FROM usuario WHERE email = ?";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setString(1, usuario.getEmail());
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

}
