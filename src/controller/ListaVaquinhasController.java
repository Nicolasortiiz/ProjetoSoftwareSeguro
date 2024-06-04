package controller;

import dao.VaquinhaDAO;
import model.Usuario;
import model.Vaquinha;

import view.ListaVaquinhasView;

import java.util.ArrayList;


public class ListaVaquinhasController {
    private DetalhesVaquinhaController dvc;
    private ListaVaquinhasView lvv;
    private VaquinhaDAO vDAO;
    private int opcao;
    public ListaVaquinhasController(Usuario usuario){
        this.lvv = new ListaVaquinhasView();
        this.vDAO = new VaquinhaDAO();
        ArrayList<Vaquinha> vaquinhas = vDAO.listarVaquinhas();
        for(int i = 0;i < vaquinhas.size();i++){
            this.lvv.listar((i+1),vaquinhas.get(i).getNomeVaquinha(),vaquinhas.get(i).getNomeUsuario(),
                    vaquinhas.get(i).getData());
        }
        while(this.opcao != 0) {
            this.opcao = this.lvv.acessarVaquinha();
            if((this.opcao-1) <= vaquinhas.size()) {
                vaquinhas.clear();
                this.dvc = new DetalhesVaquinhaController((this.opcao - 1));
            }else{
                vaquinhas.clear();
                this.lvv.opcaoInvalida();
            }
        }
    }
}
