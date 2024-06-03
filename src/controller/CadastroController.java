package controller;

import model.Usuario;
import view.CadastroView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroController {
    private CadastroView cv;
    private Usuario usuario;

    public CadastroController() {
        this.cv = new CadastroView();
        ArrayList<String> inputs;
        do {
            inputs = this.cv.cadastroInput();
            String email = inputs.get(0);
            String senha = "";
            try {
                senha = getSHA256Hash(inputs.get(1));
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                System.err.println("Erro: " + e.getMessage());
            }
            // adicionar cognito if = then cool :D
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
}
