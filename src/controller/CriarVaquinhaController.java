package controller;

import dao.UsuarioDAO;
import model.Usuario;
import model.Vaquinha;
import view.CriarVaquinhaView;
import dao.VaquinhaDAO;

public class CriarVaquinhaController {
    private CriarVaquinhaView vv;
    private VaquinhaDAO vdao;
    private UsuarioDAO udao;
    private Usuario usuario;
    public CriarVaquinhaController(Usuario usuario){
        this.vv = new CriarVaquinhaView();
        this.vdao = new VaquinhaDAO();
        this.udao = new UsuarioDAO();

        Vaquinha vaquinha = vv.addVaquinha();

        vaquinha.setIdVaquinha(this.udao.retornaIdUsuario(usuario));
        vdao.insereVaquinha(vaquinha);
    }
}
