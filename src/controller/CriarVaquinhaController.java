package controller;

import dao.UsuarioDAO;
import model.Usuario;
import model.Vaquinha;
import view.CriarVaquinhaView;
import dao.VaquinhaDAO;

import java.time.LocalDate;
import java.time.ZoneId;

public class CriarVaquinhaController {
    private CriarVaquinhaView vv;
    private VaquinhaDAO vdao;
    private UsuarioDAO udao;
    private LocalDate localdate;

    public CriarVaquinhaController(Usuario usuario){
        this.vv = new CriarVaquinhaView();
        this.vdao = new VaquinhaDAO();
        this.udao = new UsuarioDAO();
        Vaquinha vaquinha = vv.addVaquinha();
        this.localdate = LocalDate.now(ZoneId.of("America/Sao_Paulo"));

        if(!vaquinha.getNomeVaquinha().isBlank() && !vaquinha.getDescricao().isBlank()){
            vaquinha.setIdUsuario(this.udao.retornaIdUsuario(usuario));
            vaquinha.setData(this.localdate.toString());
            vdao.insereVaquinha(vaquinha);
            vv.vaquinhaAdicionada();
        }else{
            vv.falhaAdicionar();
        }
    }
}
