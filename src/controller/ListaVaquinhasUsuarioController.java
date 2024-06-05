package controller;

import dao.VaquinhaDAO;
import model.Usuario;
import model.Vaquinha;
import view.ListaVaquinhasUsuarioView;

import java.util.ArrayList;

public class ListaVaquinhasUsuarioController {
    private DetalhesVaquinhaController dvc;
    private ListaVaquinhasUsuarioView lvuv;
    private VaquinhaDAO vDAO;
    private int opcao;

    public ListaVaquinhasUsuarioController(Usuario usuario){
        this.lvuv = new ListaVaquinhasUsuarioView();
        this.vDAO = new VaquinhaDAO();
        this.opcao = 1;
        ArrayList<Vaquinha> vaquinhas = vDAO.listarVaquinhasUsuario(usuario);
        for (Vaquinha vaquinha : vaquinhas) {
            this.lvuv.listar(vaquinha.getIdVaquinha(), vaquinha.getNomeVaquinha(), vaquinha.getData());
        }
        while(this.opcao != 0) {
            if(!vaquinhas.isEmpty()) {
                this.opcao = this.lvuv.acessarVaquinha();
                for(int i = 0; i < vaquinhas.size();i++){
                    if((this.opcao-1) == vaquinhas.get(i).getIdVaquinha()) {
                        vaquinhas.clear();
                        this.dvc = new DetalhesVaquinhaController(this.opcao);
                    }
                }
                this.lvuv.opcaoInvalida();
            }else{
                this.opcao = 0;
            }

        }
        vaquinhas.clear();
    }


}
