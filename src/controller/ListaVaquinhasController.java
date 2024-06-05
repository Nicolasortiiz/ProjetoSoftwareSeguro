package controller;

import dao.UsuarioDAO;
import dao.VaquinhaDAO;
import model.Usuario;
import model.Vaquinha;

import view.ListaVaquinhasView;

import java.util.ArrayList;


public class ListaVaquinhasController {
    private DetalhesVaquinhaController dvc;
    private ListaVaquinhasView lvv;
    private VaquinhaDAO vDAO;
    private UsuarioDAO uDAO;
    private int opcao;

    public ListaVaquinhasController(Usuario usuario){
        this.lvv = new ListaVaquinhasView();
        this.vDAO = new VaquinhaDAO();
        ArrayList<Vaquinha> vaquinhas = vDAO.listarVaquinhas();
        for (Vaquinha vaquinha : vaquinhas) {
            this.lvv.listar(vaquinha.getIdVaquinha(), vaquinha.getNomeVaquinha(),
                    this.uDAO.retornaNomeUsuario(vaquinha.getIdUsuario()), vaquinha.getData());
        }
        while(this.opcao != 0) {
            this.opcao = this.lvv.acessarVaquinha();
            for(int i = 0; i < vaquinhas.size();i++){
                if((this.opcao-1) == vaquinhas.get(i).getIdVaquinha()) {
                    vaquinhas.clear();
                    this.dvc = new DetalhesVaquinhaController(usuario,(this.opcao - 1));
                }
            }
            this.lvv.opcaoInvalida();

        }
        vaquinhas.clear();
    }
}
