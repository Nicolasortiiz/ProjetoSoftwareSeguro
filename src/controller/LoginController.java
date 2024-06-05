package controller;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;
import dao.UsuarioDAO;
import model.Usuario;
import view.LoginView;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
    private LoginView lv;
    private Usuario usuario;
    private UsuarioDAO uDAO;
    private ArrayList<String> inputs;

    public LoginController() {
        this.lv = new LoginView();
        String CLIENT_ID = "5vinuvibjslrtqseo7bad6qeu5";
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
                AWSCognitoIdentityProvider cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                        .withRegion(Regions.US_EAST_1)
                        .build();
                Map<String, String> authParams = new HashMap<>();
                authParams.put("USERNAME", email);
                authParams.put("PASSWORD", senha);
                InitiateAuthRequest authRequest = new InitiateAuthRequest()
                        .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
                        .withAuthParameters(authParams)
                        .withClientId(CLIENT_ID);
                try {
                    InitiateAuthResult authResponse = cognitoClient.initiateAuth(authRequest);
                    AuthenticationResultType authResult = authResponse.getAuthenticationResult();

                    if (authResult != null) {
                        this.uDAO = new UsuarioDAO();
                        this.usuario = uDAO.retornaUsuario(email);
                        status = 1;
                    } else {
                        this.lv.entradaInvalida();
                    }
                } catch (NotAuthorizedException e) {
                    lv.entradaInvalida();
                }
            } else {
                this.lv.entradaInvalida();
            }
        } while ((!email.isBlank() || !senha.isBlank()) && status == 0);
    }
    public Usuario logar(){
        return this.usuario;
    }
}
