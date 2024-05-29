package view;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginView {
    private Scanner sc;
    public LoginView(){
        this.sc = new Scanner (System.in);
    }

    public ArrayList<String> loginInput(){
        this.sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<String>();
        System.out.println("\nDigite o email: ");
        lista.add(sc.nextLine());

        System.out.println("Digite a senha: ");
        lista.add(sc.nextLine());

        return lista;
    }
    public void entradaInvalida(){
        System.out.println("Login incorreto!");
    }

}
