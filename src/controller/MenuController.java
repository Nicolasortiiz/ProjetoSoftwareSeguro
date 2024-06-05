package controller;

import model.Usuario;
import view.MenuView;

public class MenuController {

    public MenuController(){
        MenuView mv = new MenuView();
        Usuario usuario = null;
        int opcao = 0;
        while(opcao != 9){
            opcao = mv.menu();
            if(opcao == 1){
                LoginController lc = new LoginController();
                usuario = lc.logar();
            }else if(opcao == 2){
                new CadastroController();
            }else{
                mv.opcaoInvalida();
            }
            while(usuario != null) {
                opcao = mv.menuLogado(usuario.getNomeUsuario());
                if (opcao == 1) {
                    new ListaVaquinhasController();
                } else if (opcao == 2) {
                    new ListaVaquinhasUsuarioController(usuario);
                } else if (opcao == 3) {
                    new CriarVaquinhaController(usuario);
                } else if (opcao == 4 || opcao == 9) {
                    usuario = null;
                }else {
                    mv.opcaoInvalida();
                }
            }
        }


    }

}
