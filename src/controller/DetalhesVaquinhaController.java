package controller;

import dao.VaquinhaDAO;
import model.Usuario;
import model.Vaquinha;
import view.DetalhesVaquinhaView;

public class DetalhesVaquinhaController {
    private DetalhesVaquinhaView dvv;
    private VaquinhaDAO vDAO;
    private int opcao;
    private PagamentoController pc;

    public DetalhesVaquinhaController(Usuario usuario, int idVaquinha){
        this.dvv = new DetalhesVaquinhaView();
        this.vDAO = new VaquinhaDAO();
        Vaquinha vaquinha = vDAO.listarDetalhesVaquinhas(idVaquinha);
        this.dvv.detalhesVaquinha(vaquinha.getIdVaquinha(), vaquinha.getNomeVaquinha(),
                this.vDAO.retornaNomeUsuario(vaquinha.getIdUsuario()), vaquinha.getDescricao(),
                vaquinha.getData(), vaquinha.getValorArrecadado(), vaquinha.getValorMeta());

        while(this.opcao != 9){
            this.opcao = this.dvv.opcaoDetalhes();
            if(this.opcao == 1){
                this.pc = new PagamentoController(usuario,vaquinha);
            }else{
                dvv.opcaoInvalida();
            }
        }
    }
}