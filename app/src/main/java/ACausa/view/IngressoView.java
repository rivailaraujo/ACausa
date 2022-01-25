package ACausa.view;

import ACausa.controller.IC;
import ACausa.enums.Raca;

import java.util.Scanner;

public class IngressoView {

    public void montarRebelde(){
        String nome = askNome();
        int idade = askIdade();
        Raca raca = askRaca();
        IC inteligencia = new IC();
        inteligencia.montarFicha(nome, idade, raca);
    }
    private String askNome(){
        try {
            System.out.println("Qual seu nome?");
            Scanner input = new Scanner(System.in);
            return input.next();
        } catch (Exception e) {
            return askNome();
        }
    }

    private int askIdade(){
        try {
            System.out.println("Qual sua idade?");
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        }catch (Exception e){
            System.out.println("Idade Inválida, tente novamente.");
            return askIdade();
        }
    }

    private Raca askRaca(){
        System.out.println("Qual sua idade?");
        System.out.println("[1] - " + Raca.GREE);
        System.out.println("[2] - " + Raca.RAKATA);
        System.out.println("[3] - " + Raca.HUMANO);
        Scanner input = new Scanner(System.in);
        String option;
        option = input.next();
        switch (option) {
            case "1":
                return Raca.GREE;
            case "2":
                return Raca.RAKATA;
            case "3":
                return Raca.HUMANO;
            case "0":
                System.exit(0);
                input.close();
                break;
            default:
                System.out.print("Opção inválida, por favor escolha uma opção válida do menu.\n\n");
                return askRaca();
        }
        return null;
    }
}
