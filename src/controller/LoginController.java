package controller;

import dao.UsuarioDAO;
import model.Usuario;
import view.LoginView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
    private LoginView lv;
    private Usuario usuario;
    private UsuarioDAO uDAO;
    public LoginController() {
        this.lv = new LoginView();
        // adicionar cognito
        ArrayList<String> inputs;
        do {
            inputs = this.lv.loginInput();
            String email = inputs.get(0);
            String senha = "";
            try {
                senha = getSHA256Hash(inputs.get(1));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                System.err.println("Erro: " + e.getMessage());
            }
            email = Normalizer.normalize(email, Normalizer.Form.NFKC);
            email = email.trim();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.]+$");
            Matcher matcher = pattern.matcher(email);
            if (email.length() <= 255 && matcher.matches() && !senha.isBlank()) {
                uDAO = new UsuarioDAO();
                uDAO.retornaUsuario(usuario);
            } else {
                this.lv.entradaInvalida();
            }
        } while (inputs.get(0).isEmpty() || inputs.get(1).isEmpty());
    }
    public static String getSHA256Hash(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public Usuario logar(String email){
        String nomeUsuario = "";
        return new Usuario(email, nomeUsuario);
    }

}
