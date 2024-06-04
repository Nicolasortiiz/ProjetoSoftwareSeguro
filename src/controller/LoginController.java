package controller;

import dao.UsuarioDAO;
import model.Usuario;
import view.LoginView;
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
        String email;
        String senha;
        ArrayList<String> inputs;
        do {
            inputs = this.lv.loginInput();
            email = inputs.get(0);
            senha = inputs.get(1);

            email = Normalizer.normalize(email, Normalizer.Form.NFKC);
            email = email.trim();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.]+$");
            Matcher matcher = pattern.matcher(email);
            if (email.length() <= 255 && matcher.matches() && !senha.isBlank()) {
                this.uDAO = new UsuarioDAO();
                this.usuario = uDAO.retornaUsuario(email);
            } else {
                this.lv.entradaInvalida();
            }
        } while (!email.isBlank() || !senha.isBlank());
    }
    public Usuario logar(){
        return this.usuario;
    }
}
