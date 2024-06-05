package controller;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.SignUpRequest;
import com.amazonaws.services.cognitoidp.model.SignUpResult;
import com.amazonaws.services.cognitoidp.model.UsernameExistsException;
import dao.UsuarioDAO;
import model.Usuario;
import view.CadastroView;

import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
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
    private ArrayList<String> inputs;

    public CadastroController() {
        this.cv = new CadastroView();
        this.uDAO = new UsuarioDAO();
        String email;
        String nomeUsuario;
        String senha;
        String CLIENT_ID = "5vinuvibjslrtqseo7bad6qeu5";
        int status = 0;
        do {
            this.inputs = this.cv.cadastroInput();
            email = this.inputs.get(0);
            nomeUsuario = this.inputs.get(1);
            senha = this.inputs.get(2);
            email = Normalizer.normalize(email, Normalizer.Form.NFKC);
            nomeUsuario = Normalizer.normalize(nomeUsuario, Normalizer.Form.NFKC);
            email = email.trim();
            nomeUsuario = nomeUsuario.trim();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9@_.]+$");
            Matcher matcherEmail = pattern.matcher(email);
            Matcher matcherNome = pattern.matcher(nomeUsuario);
            if(email.length() <= 255 && matcherEmail.matches() && matcherNome.matches()){
                AWSCognitoIdentityProvider cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                        .withRegion(Regions.US_EAST_1)
                        .build();
                SignUpRequest signUpRequest = new SignUpRequest()
                        .withClientId(CLIENT_ID)
                        .withUsername(email)
                        .withPassword(senha);


                try {
                    SignUpResult result = cognitoClient.signUp(signUpRequest);

                    status = 1;
                    this.usuario = new Usuario(email, nomeUsuario);
                    this.uDAO.criarUsuario(usuario);

                } catch (UsernameExistsException | com.amazonaws.services.cognitoidp.model.InvalidParameterException e) {
                    cv.entradaInvalida();

                }

            }else {
                cv.entradaInvalida();
            }
        } while ((!inputs.get(0).isBlank() || !inputs.get(1).isBlank()) && status == 0);
    }

}
