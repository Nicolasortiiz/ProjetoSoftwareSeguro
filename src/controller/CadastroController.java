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
            String senha = inputs.get(1);
            email = Normalizer.normalize(email, Normalizer.Form.NFKC);
            email = email.trim();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.]+$");
            Matcher matcher = pattern.matcher(email);
            if(email.length() <= 255){

            }
            // adicionar cognito if = then cool :D
        } while (inputs.get(0).isEmpty() || inputs.get(1).isEmpty());
    }

}
