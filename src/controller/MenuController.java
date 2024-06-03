package controller;

import model.Usuario;
import view.MenuView;

public class MenuController {
    private MenuView mv;
    private ListaVaquinhasController lvc;
    private ListaVaquinhasUsuarioController lvuc;
    private CriarVaquinhaController cvc;
    private LoginController lc;
    private CadastroController cc;
    private int opcao;
    private Usuario usuario;
    public MenuController(){
        mv = new MenuView();
        this.usuario = null;
        this.opcao = 0;
        while(this.opcao != 9){
            this.opcao = mv.menu();
            if(this.opcao == 1){
                lc = new LoginController();
                this.usuario = lc.logar();
            }else if(this.opcao == 2){
                cc = new CadastroController();
            }else{
                mv.opcaoInvalida();
            }
            while(this.usuario != null) {
                this.opcao = mv.menuLogado();
                if (this.opcao == 1) {
                    lvc = new ListaVaquinhasController(this.usuario);
                } else if (this.opcao == 2) {
                    lvuc = new ListaVaquinhasUsuarioController(this.usuario);
                } else if (this.opcao == 3) {
                    cvc = new CriarVaquinhaController(this.usuario);
                } else if (this.opcao == 4) {
                    this.usuario = null;
                }else {
                    mv.opcaoInvalida();
                }
            }
        }


    }

}
