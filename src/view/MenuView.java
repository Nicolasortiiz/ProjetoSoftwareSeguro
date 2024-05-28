package view;

import java.util.Scanner;

public class MenuView {
    private Scanner sc;
    public MenuView(){
        this.sc = new Scanner (System.in);
    }

    public int menu(){
        this.sc = new Scanner(System.in);
        System.out.println("\n(1) Login");
        System.out.println("(2) Cadastro");
        System.out.println("(9) Sair");
        System.out.println("Opção: ");
        return sc.nextInt();
    }
    public int menuLogado(){
        this.sc = new Scanner(System.in);
        System.out.println("(1) Lista de vaquinhas disponíveis");
        System.out.println("(2) Minhas vaquinhas");
        System.out.println("(3) Criar nova vaquinha");
        System.out.println("(4) Logout");
        System.out.println("(9) Sair");
        System.out.println("Opção: ");
        return sc.nextInt();
    }
    public void opcaoInvalida(){
        System.out.println("Opção inválida");
    }
}