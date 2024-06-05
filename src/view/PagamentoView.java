package view;

import java.util.Scanner;

public class PagamentoView {
    private Scanner sc;

    public PagamentoView(){
        this.sc = new Scanner (System.in);
    }

    public float valorPagamento(){
        this.sc = new Scanner(System.in);
        System.out.println("Insira o valor do pagamento: ");
        return sc.nextFloat();

    }
}
