package dao;

import model.Usuario;
import model.Vaquinha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VaquinhaDAO {
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;
    public VaquinhaDAO(){
        conexao = conexao.getInstance();
    }
    public ArrayList<Vaquinha> listarVaquinhas() {
        ArrayList<Vaquinha> vaquinhas = new ArrayList<>();
        Vaquinha vaquinha = new Vaquinha(null,null,0);
        Usuario usuario = new Usuario(null,null);

        try {
            query = "SELECT nome_vaquinha,data_criacao,usuario_id FROM vaquinha";
            ps = conexao.getConexao().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                vaquinha.setNomeVaquinha(rs.getString("nome_vaquinha"));
                vaquinha.setData(rs.getString("data_criacao"));
                vaquinha.setNomeUsuario(this.retornaUsuarioID(usuario, rs.getInt("usuario_id")).getNomeUsuario());
                vaquinhas.add(vaquinha);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaquinhas;
    }
    public ArrayList<Vaquinha> listarDetalhesVaquinhas() {
        ArrayList<Vaquinha> vaquinhas = new ArrayList<>();
        Vaquinha vaquinha = new Vaquinha(null,null,0);
        Usuario usuario = new Usuario(null,null);

        try {
            query = "SELECT nome_vaquinha,descricao,valor_meta,valor_arrecadado,data_criacao,usuario_id FROM vaquinha";
            ps = conexao.getConexao().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                vaquinha.setNomeVaquinha(rs.getString("nome_vaquinha"));
                vaquinha.setData(rs.getString("data_criacao"));
                vaquinha.setDescricao(rs.getString("descricao"));
                vaquinha.setNomeUsuario(this.retornaUsuarioID(usuario, rs.getInt("usuario_id")).getNomeUsuario());
                try {
                    vaquinha.setValorMeta(Float.parseFloat(rs.getString("valor_meta")));
                    vaquinha.setValorArrecadado(Float.parseFloat(rs.getString("valor_arrecadado")));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                vaquinhas.add(vaquinha);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaquinhas;
    }
    public Usuario retornaUsuarioID(Usuario usuario, int id){

        try {
            query = "SELECT email, nome_usuario FROM usuario WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email"));

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
