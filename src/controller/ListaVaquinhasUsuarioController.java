package controller;

import dao.VaquinhaDAO;
import model.Usuario;
import model.Vaquinha;
import view.ListaVaquinhasUsuarioView;

import java.util.ArrayList;

public class ListaVaquinhasUsuarioController {

    public ListaVaquinhasUsuarioController(Usuario usuario){
        ListaVaquinhasUsuarioView lvuv = new ListaVaquinhasUsuarioView();
        VaquinhaDAO vDAO = new VaquinhaDAO();
        int opcao = 1;
        ArrayList<Vaquinha> vaquinhas = vDAO.listarVaquinhasUsuario(usuario);

        for (Vaquinha vaquinha : vaquinhas) {
            lvuv.listar(vaquinha.getIdVaquinha(), vaquinha.getNomeVaquinha(), vaquinha.getData());
        }
        while(opcao != 0) {
            if(!vaquinhas.isEmpty()) {
                opcao = lvuv.acessarVaquinha();
                for(int i = 0; i < vaquinhas.size();i++){
                    if(this.opcao == vaquinhas.get(i).getIdVaquinha()) {
                        vaquinhas.clear();
                        new DetalhesVaquinhaController(opcao);
                    }
                }
                lvuv.opcaoInvalida();
            }else{
                opcao = 0;
            }

        }
        vaquinhas.clear();
    }


}
