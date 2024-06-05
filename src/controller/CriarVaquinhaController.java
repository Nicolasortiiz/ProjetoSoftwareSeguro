package controller;

import dao.UsuarioDAO;
import model.Usuario;
import model.Vaquinha;
import view.CriarVaquinhaView;
import dao.VaquinhaDAO;

import java.time.LocalDate;
import java.time.ZoneId;

public class CriarVaquinhaController {

    public CriarVaquinhaController(Usuario usuario){
        CriarVaquinhaView vv = new CriarVaquinhaView();
        VaquinhaDAO vdao = new VaquinhaDAO();
        UsuarioDAO udao = new UsuarioDAO();
        Vaquinha vaquinha = vv.addVaquinha();
        LocalDate localdate = LocalDate.now(ZoneId.of("America/Sao_Paulo"));

        if(!vaquinha.getNomeVaquinha().isBlank() && !vaquinha.getDescricao().isBlank()){
            vaquinha.setIdUsuario(udao.retornaIdUsuario(usuario));
            vaquinha.setData(localdate.toString());
            vdao.insereVaquinha(vaquinha);
            vv.vaquinhaAdicionada();
        }else{
            vv.falhaAdicionar();
        }
    }
}
