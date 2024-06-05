package view;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroView {
    private Scanner sc;
    public CadastroView() {
        this.sc = new Scanner (System.in);
    }

    public ArrayList <String> cadastroInput() {
        ArrayList<String> lista = new ArrayList<>();
        System.out.println("\nDigite o email: ");
        lista.add(sc.nextLine());
        System.out.println("Digite o nome de usuário: ");
        lista.add(sc.nextLine());
        System.out.println("Digite a senha: ");
        lista.add(sc.nextLine());

        return lista;
    }

    public void entradaInvalida(){
        System.out.println("Erro no cadastro!");
    }
}
