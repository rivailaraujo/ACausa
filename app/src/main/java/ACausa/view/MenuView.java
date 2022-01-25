package ACausa.view;

import java.util.Scanner;

public class MenuView {
    Scanner input;

    public void start() {
        header();
        options();
    }

    private void header() {
        System.out.print("#############################################\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("############$ BEM VINDO A CAUSA $############\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("#############################################\n\n\n");

    }
    private void options() {
        System.out.print("#######---MENU---#####\n\n");
        System.out.print("[UTILIZE O NÚMERO CORRESPONDENTE A OPÇÃO]\n");
        System.out.println("[1] - SOLICITAR INGRESSO");
        System.out.println("[0] - SAIR.");

        String option;
        this.input = new Scanner(System.in);
        option = input.next();

        switch (option) {
            case "1":
                IngressoView ingressoView = new IngressoView();
                ingressoView.montarRebelde();
                this.options();
            case "0":
                System.exit(0);
                this.input.close();
                break;
            default:
                System.out.print("Opção inválida, por favor escolha uma opção válida do menu.\n\n");
                options();
        }

    }
}
