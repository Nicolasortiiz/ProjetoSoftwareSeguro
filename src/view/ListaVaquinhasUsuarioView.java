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
        System.out.println("\nID da vaquinha (0 para sair): ");
        return sc.nextInt();
    }

    public void opcaoInvalida(){
        System.out.println("Opção inválida");
    }
}
