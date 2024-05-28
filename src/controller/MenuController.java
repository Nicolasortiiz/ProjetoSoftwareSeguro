package controller;

import view.MenuView;

public class MenuController {
    private MenuView mv;
    private ListaVaquinhasController lvc;
    private ListaVaquinhasUsuarioController lvuc;
    private CriarVaquinhaController cvc;
    private LoginController lc;
    private CadastroController cc;
    private int opcao;
    public MenuController(){
        mv = new MenuView();
        this.opcao = 0;
        while(this.opcao != 9){
            this.opcao = mv.menu();
            if(this.opcao == 1){
                lc = new LoginController();
            }else if(this.opcao == 2){
                cc = new CadastroController();
            }else{
                mv.opcaoInvalida();
            }
        }
        while(this.opcao != 9) {
            this.opcao = mv.menuLogado();
            if (this.opcao == 1) {
                lvc = new ListaVaquinhasController();
            } else if (this.opcao == 2) {
                lvuc = new ListaVaquinhasUsuarioController();
            } else if (this.opcao == 3) {
                cvc = new CriarVaquinhaController();
            } else if (this.opcao == 4) {

            }else {
                mv.opcaoInvalida();
            }
        }

    }

}
