package ACausa.view;

import ACausa.domain.Rebelde;
import ACausa.enums.Raca;
import ACausa.utils.Ordenador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class MenuView {
    Scanner input;
    IngressoView ingressoView;
    LinkedList<Rebelde> rebeldesList;
    Ordenador ordenador;

    public void start() {
        ingressoView = new IngressoView();
        rebeldesList = new LinkedList<>();
        ordenador = new Ordenador();
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
        System.out.println("[2] - LISTAR INGRESSOS");
        System.out.println("[0] - SAIR.");

        String option;
        this.input = new Scanner(System.in);
        option = input.next();

        switch (option) {
            case "1":
                Rebelde newRebelde = ingressoView.montarRebelde();
                if (newRebelde != null) {
                    rebeldesList.add(newRebelde);
                }
                this.options();
            case "2":
                rebeldesList = new LinkedList<>();
                inprimirAceitos();
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

    public void inprimirAceitos() {
        try (Stream<String> stream = Files.lines(Paths.get("ListaAprovados.txt"))) {
            stream.forEach(line -> {
                if (!line.isBlank()) {
                    line = line.replaceAll("\\s+", "");
                    line = line.replace("Nome:", "");
                    line = line.replace("Idade:", "");
                    line = line.replace("Raça:", "");
                    var atributes = line.split(";", 3);
                    Rebelde rebelde = Rebelde.builder()
                            .nome(atributes[0])
                            .idade(Integer.parseInt(atributes[1]))
                            .raca(Raca.valueOf(atributes[2])).build();
                    this.rebeldesList.add(rebelde);
                }
            });
            this.menuIngressos();

        } catch (IOException e) {
            System.out.println("Lista Vazia, Solicite um Ingresso.");
        }
    }

    private void menuIngressos() {
        System.out.print("[MOSTRAR INGRESSOS ACEITOS POR: ]\n");
        System.out.println("[1] - NOME");
        System.out.println("[2] - IDADE");
        System.out.println("[3] - RACA");
        System.out.println("[0] - SAIR");

        String option;
        this.input = new Scanner(System.in);
        option = input.next();

        switch (option) {
            case "1":
                printElementsDaLista(ordenador.ordenarRebeldesPorNome(rebeldesList));
                break;
            case "2":
                printElementsDaLista(ordenador.ordenarRebeldesPorIdade(rebeldesList));
                break;
            case "3":
                printElementsDaLista(ordenador.ordenarRebeldesPorRaca(rebeldesList));
                break;
            case "0":
                System.exit(0);
                this.input.close();
                break;
            default:
                System.out.print("Opção inválida, por favor escolha uma opção válida do menu.\n\n");
                menuIngressos();
        }

    }

    public void printElementsDaLista(LinkedList<Rebelde> rebeldes){
        System.out.println("\n");
        for (int i = 0; i < rebeldes.size(); i++) {
            System.out.println(i +" -> Nome: "+rebeldes.get(i).getNome() + "; Idade: " + rebeldes.get(i).getIdade() + "; Raça: " + rebeldes.get(i).getRaca());
        }
        System.out.println("\n");
    }
}


