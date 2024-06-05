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
    private ArrayList<String> inputs;

    public LoginController() {
        this.lv = new LoginView();
        String email;
        String senha;
        int status = 0;

        do {
            this.inputs = this.lv.loginInput();
            email = this.inputs.get(0);
            senha = this.inputs.get(1);

            email = Normalizer.normalize(email, Normalizer.Form.NFKC);
            email = email.trim();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.]+$");
            Matcher matcher = pattern.matcher(email);
            if (email.length() <= 255 && matcher.matches() && !senha.isBlank()) {
                this.uDAO = new UsuarioDAO();
                this.usuario = uDAO.retornaUsuario(email);
                status = 1;
            } else {
                this.lv.entradaInvalida();
            }
        } while ((!email.isBlank() || !senha.isBlank()) && status == 0);
    }
    public Usuario logar(){
        return this.usuario;
    }
}
