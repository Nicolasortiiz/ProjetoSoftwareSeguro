package view;

import java.util.Scanner;

public class ListaVaquinhasView {
    private Scanner sc;
    public ListaVaquinhasView(){
        this.sc = new Scanner (System.in);
    }
    public void listar(int id,String nomeVaquinha, String nomeUsuario, String dataCriacao){
        System.out.println("("+id+") "+nomeUsuario+" - "+nomeVaquinha+" - "+dataCriacao);
    }
    public int acessarVaquinha(){
        this.sc = new Scanner(System.in);
        System.out.println("ID da vaquinha: ");
        return sc.nextInt();
    }


}