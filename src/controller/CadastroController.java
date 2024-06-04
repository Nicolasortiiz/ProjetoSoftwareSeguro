package controller;

import dao.UsuarioDAO;
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
    private UsuarioDAO uDAO;

    public CadastroController() {
        this.cv = new CadastroView();
        ArrayList<String> inputs;
        String email;
        String nomeUsuario;
        String senha;
        do {
            inputs = this.cv.cadastroInput();
            email = inputs.get(0);
            nomeUsuario = inputs.get(1);
            senha = inputs.get(2);
            email = Normalizer.normalize(email, Normalizer.Form.NFKC);
            nomeUsuario = Normalizer.normalize(nomeUsuario, Normalizer.Form.NFKC);
            email = email.trim();
            nomeUsuario = nomeUsuario.trim();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.]+$");
            Matcher matcherEmail = pattern.matcher(email);
            Matcher matcherNome = pattern.matcher(nomeUsuario);
            if(email.length() <= 255 && matcherEmail.matches() && matcherNome.matches()){
                Usuario usuario = new Usuario(email,nomeUsuario);
                this.uDAO.criarUsuario(usuario);
            }else{
                cv.entradaInvalida();
            }
            // adicionar cognito if = then cool :D
        } while (!inputs.get(0).isBlank() || !inputs.get(1).isBlank());
    }

}
