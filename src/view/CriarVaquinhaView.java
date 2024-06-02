package view;

import model.Vaquinha;

import java.util.Scanner;

public class CriarVaquinhaView {
    private Scanner sc;
    public CriarVaquinhaView(){
        this.sc = new Scanner (System.in);
    }
    public Vaquinha addVaquinha(){
        this.sc = new Scanner(System.in);
        System.out.println("\nDigite o nome da vaquinha: ");
        String nomeVaquinha = sc.nextLine();

        System.out.println("Digite a descrição da vaquinha: ");
        String descricao = sc.nextLine();

        System.out.println("Digite o valor meta da vaquinha: ");
        float valorMeta = sc.nextFloat();

        Vaquinha vaquinha = new Vaquinha(nomeVaquinha, descricao, valorMeta);

        vaquinha.setValorArrecadado(0);

        return vaquinha;
    }

}
