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
    public ArrayList<Vaquinha> listarVaquinhasUsuario(Usuario usuario) {
        ArrayList<Vaquinha> vaquinhas = new ArrayList<>();
        Vaquinha vaquinha = new Vaquinha(null,null,0);

        try {
            query = "SELECT id,nome_vaquinha,data_criacao FROM vaquinha WHERE usuario_id = (SELECT id FROM usuario WHERE email = ?)";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setString(1, usuario.getEmail());
            rs = ps.executeQuery();
            while (rs.next()) {
                vaquinha.setIdVaquinha(rs.getInt("id"));
                vaquinha.setNomeVaquinha(rs.getString("nome_vaquinha"));
                vaquinha.setData(rs.getString("data_criacao"));
                vaquinhas.add(vaquinha);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaquinhas;
    }
    public ArrayList<Vaquinha> listarVaquinhas() {
        ArrayList<Vaquinha> vaquinhas = new ArrayList<>();

        try {
            query = "SELECT id,nome_vaquinha,data_criacao,usuario_id FROM vaquinha";
            ps = conexao.getConexao().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vaquinha vaquinha = new Vaquinha(rs.getString("nome_vaquinha"),null,0);
                vaquinha.setIdUsuario(rs.getInt("usuario_id"));
                vaquinha.setIdVaquinha(rs.getInt("id"));
                vaquinha.setData(rs.getString("data_criacao"));
                vaquinhas.add(vaquinha);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaquinhas;
    }
    public Vaquinha listarDetalhesVaquinhas(int idVaquinha) {
        Vaquinha vaquinha = new Vaquinha(null,null,0);

        try {
            query = "SELECT id,nome_vaquinha,descricao,valor_meta,valor_arrecadado,data_criacao,usuario_id FROM vaquinha WHERE vaquinha.id = ?";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setInt(1, idVaquinha);
            rs = ps.executeQuery();
            if (rs.next()) {
                vaquinha.setIdUsuario(rs.getInt("usuario_id"));
                vaquinha.setIdVaquinha(rs.getInt("id"));
                vaquinha.setNomeVaquinha(rs.getString("nome_vaquinha"));
                vaquinha.setData(rs.getString("data_criacao"));
                vaquinha.setDescricao(rs.getString("descricao"));
                try {
                    vaquinha.setValorMeta(Float.parseFloat(rs.getString("valor_meta")));
                    vaquinha.setValorArrecadado(Float.parseFloat(rs.getString("valor_arrecadado")));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vaquinha;
    }
    public void adicionarPagamento(Vaquinha vaquinha, float valor) {
        float valorArrecadado = 0;
        try {
            query = "SELECT valor_arrecadado FROM vaquinha WHERE id = ?";
            ps = conexao.getConexao().prepareStatement(query);
            ps.setInt(1, vaquinha.getIdVaquinha());
            rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    valorArrecadado = Float.parseFloat(rs.getString("valor_arrecadado")) + valor;

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                query = "UPDATE valor_arrecadado FROM vaquinha  SET valor_arrecadado = ? WHERE id = ?";
                ps = conexao.getConexao().prepareStatement(query);
                ps.setString(1, Float.toString(valorArrecadado));
                ps.setInt(2, vaquinha.getIdVaquinha());
                rs = ps.executeQuery();
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
