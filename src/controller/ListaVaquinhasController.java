package controller;

import dao.VaquinhaDAO;
import model.Usuario;
import model.Vaquinha;
import view.ListaVaquinhasView;

import java.util.ArrayList;


public class ListaVaquinhasController {
    private ListaVaquinhasView lvv;
    private VaquinhaDAO vDAO;
    public ListaVaquinhasController(Usuario usuario){
        this.lvv = new ListaVaquinhasView();
        this.vDAO = new VaquinhaDAO();
        ArrayList<Vaquinha> vaquinhas = vDAO.listarVaquinhas();
        for(int i = 0;i < vaquinhas.size();i++){
            
        }
    }
}
