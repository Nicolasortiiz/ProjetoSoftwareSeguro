package controller;

import dao.UsuarioDAO;
import dao.VaquinhaDAO;
import model.Vaquinha;
import view.ListaVaquinhasView;
import java.util.ArrayList;


public class ListaVaquinhasController {

    public ListaVaquinhasController(){
        ListaVaquinhasView lvv = new ListaVaquinhasView();
        VaquinhaDAO vDAO = new VaquinhaDAO();
        UsuarioDAO uDAO = new UsuarioDAO();
        int opcao = 1;
        ArrayList<Vaquinha> vaquinhas = vDAO.listarVaquinhas();

        for (Vaquinha vaquinha : vaquinhas) {
            lvv.listar(vaquinha.getIdVaquinha(), vaquinha.getNomeVaquinha(),
                    uDAO.retornaNomeUsuario(vaquinha.getIdUsuario()), vaquinha.getData());
        }

        while(opcao != 0) {
            if(!vaquinhas.isEmpty()) {
                opcao = lvv.acessarVaquinha();
                for (int i = 0; i < vaquinhas.size(); i++) {
                    if (opcao == vaquinhas.get(i).getIdVaquinha()) {
                        vaquinhas.clear();
                        new DetalhesVaquinhaController(opcao);
                    }
                }
                lvv.opcaoInvalida();
            }else{
                opcao = 0;
            }
        }
        vaquinhas.clear();
    }
}
