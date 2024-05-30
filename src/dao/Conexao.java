package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

public class Conexao {
    private static Conexao conex;
    private final String con_banco;
    private final String usuario_mysql;
    private final String senha_mysql;
    private Connection conn;
    private Conexao() throws IOException {
        conex = null;
        usuario_mysql = "root";
        senha_mysql = "root";
        char[] usuario = new char[100];
        char[] senha = new char[100];
        int offset = 0;
        int charsRead = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("serveripaddress.txt")));
            while ((charsRead = br.read(usuario, offset, usuario.length - offset))
                    != -1) {
                offset += charsRead;
                if (offset >= usuario.length) {
                    break;
                }
            }
            con_banco = "jdbc:mysql://127.0.0.1:3306/projetobd?useSSL=false";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(con_banco,usuario_mysql,senha_mysql);
            }catch(Exception e){
                e.printStackTrace();
            }

        } finally {
            Arrays.fill(usuario,  (char) 0);
            br.close();
        }


    }
    public static Conexao getInstance() throws IOException{
        if(conex == null){
            conex = new Conexao();
        }
        return conex;
    }
    public Connection getConexao(){
        return this.conn;
    }
}
