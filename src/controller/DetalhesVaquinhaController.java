package controller;

import dao.UsuarioDAO;
import dao.VaquinhaDAO;
import model.Vaquinha;
import view.DetalhesVaquinhaView;

public class DetalhesVaquinhaController {

    public DetalhesVaquinhaController(int idVaquinha){
        DetalhesVaquinhaView dvv = new DetalhesVaquinhaView();
        VaquinhaDAO vDAO = new VaquinhaDAO();
        UsuarioDAO uDAO = new UsuarioDAO();
        int opcao = 0;
        Vaquinha vaquinha = vDAO.listarDetalhesVaquinhas(idVaquinha);
        dvv.detalhesVaquinha(vaquinha.getIdVaquinha(), vaquinha.getNomeVaquinha(),
                uDAO.retornaNomeUsuario(vaquinha.getIdUsuario()), vaquinha.getDescricao(),
                vaquinha.getData(), vaquinha.getValorArrecadado(), vaquinha.getValorMeta());

        while(opcao != 9){
            opcao = dvv.opcaoDetalhes();
            if(opcao == 1){
                new PagamentoController(vaquinha);
            }else{
                dvv.opcaoInvalida();
            }
        }
    }
}