package controller;

import dao.VaquinhaDAO;
import model.Vaquinha;
import view.PagamentoView;

public class PagamentoController {

    public PagamentoController(Vaquinha vaquinha){
        PagamentoView pv = new PagamentoView();
        VaquinhaDAO vDAO = new VaquinhaDAO();
        float valor = pv.valorPagamento();
        vDAO.adicionarPagamento(vaquinha, valor);

    }
}
