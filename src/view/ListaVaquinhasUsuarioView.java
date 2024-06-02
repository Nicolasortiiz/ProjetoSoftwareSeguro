package view;

import java.util.Scanner;

public class ListaVaquinhasUsuarioView {
    private Scanner sc;
    public ListaVaquinhasUsuarioView(){
        this.sc = new Scanner (System.in);
    }
    public void listar(int id,String nomeVaquinha, String dataCriacao){
        System.out.println("("+id+") "+nomeVaquinha+" - "+dataCriacao);
    }
    public int acessarVaquinha(){
        this.sc = new Scanner(System.in);
        System.out.println("ID da vaquinha: ");
        return sc.nextInt();
    }

    public void detalhesVaquinha(int id, String nomeVaquinha, String nomeUsuario, String descricao,
                                 String dataCriacao, float valorArrecadado, float valorMeta){
        System.out.println("\n\n\n("+id+") "+nomeVaquinha+" - "+nomeUsuario+" - "+dataCriacao);
        System.out.println("Descrição: "+descricao);
        System.out.println("Valor da meta: "+valorMeta);
        System.out.println("Valor arrecadado: "+valorArrecadado);
    }
}
