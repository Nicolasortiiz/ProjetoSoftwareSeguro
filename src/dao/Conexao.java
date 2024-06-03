package dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Conexao {
    private static Conexao conex;
    private final String con_banco;
    private Connection conn;
    private Conexao() {
        conex = null;
        con_banco = "jdbc:mysql://127.0.0.1:3306/projetobd?useSSL=false";
        char[] usuario = new char[4];
        char[] senha = new char[4];
        BufferedReader br = null;
        try {
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream("src/arquivos/poema.txt")));
                int numLinha = 0;
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    content.append(line);

                    for (int i = 0; i < line.length(); i++) {
                        char letra = line.charAt(i);
                        if (numLinha == 2 && i == 26) {
                            usuario[0] = letra;
                        } else if (numLinha == 5 && i == 21) {
                            usuario[1] = letra;
                        } else if (numLinha == 6 && i == 9) {
                            usuario[2] = letra;
                        } else if (numLinha == 1 && i == 23) {
                            usuario[3] = letra;
                        }
                        if (numLinha == 2 && i == 26) {
                            senha[0] = letra;
                        } else if (numLinha == 5 && i == 21) {
                            senha[1] = letra;
                        } else if (numLinha == 6 && i == 9) {
                            senha[2] = letra;
                        } else if (numLinha == 1 && i == 23) {
                            senha[3] = letra;
                        }
                    }
                    content.append(System.lineSeparator());
                    numLinha++;

                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = (Connection) DriverManager.getConnection(con_banco, new String(usuario), new String(senha));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                Arrays.fill(usuario, (char) 0);
                Arrays.fill(senha, (char) 0);
                br.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static Conexao getInstance(){
        if(conex == null){
            conex = new Conexao();
        }
        return conex;
    }
    public Connection getConexao(){
        return this.conn;
    }
}
