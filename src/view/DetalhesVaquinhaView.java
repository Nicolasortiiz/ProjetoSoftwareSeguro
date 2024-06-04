package view;

import java.util.Scanner;

public class DetalhesVaquinhaView {

    private Scanner sc;

    public DetalhesVaquinhaView(){
        this.sc = new Scanner (System.in);
    }

    public void detalhesVaquinha(int id, String nomeVaquinha, String nomeUsuario, String descricao,
                                 String dataCriacao, float valorArrecadado, float valorMeta){
        System.out.println("\n\n\n("+id+") "+nomeVaquinha+" - "+nomeUsuario+" - "+dataCriacao);
        System.out.println("Descrição: "+descricao);
        System.out.println("Valor da meta: "+valorMeta);
        System.out.println("Valor arrecadado: "+valorArrecadado);
    }

    public int opcaoDetalhes(){
        this.sc = new Scanner(System.in);
        System.out.println("\n(1) Apoiar");
        System.out.println("(9) Voltar");
        System.out.println("Opção: ");
        return sc.nextInt();
    }

    public void opcaoInvalida(){
        System.out.println("Opção inválida");
    }
}