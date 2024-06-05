package controller;

import dao.VaquinhaDAO;
import model.Vaquinha;
import view.PagamentoView;

public class PagamentoController {
    private PagamentoView pv;
    private VaquinhaDAO vDAO;

    public PagamentoController(Vaquinha vaquinha){
        pv = new PagamentoView();
        vDAO = new VaquinhaDAO();
        float valor = pv.valorPagamento();
        vDAO.adicionarPagamento(vaquinha, valor);

    }
}
