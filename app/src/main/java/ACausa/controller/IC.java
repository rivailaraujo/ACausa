package ACausa.controller;

import ACausa.domain.Rebelde;
import ACausa.enums.Raca;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class IC {

    public Rebelde montarFicha(String nome, int idade, Raca raca) {
        Rebelde newRebelde = Rebelde.builder().nome(nome).idade(idade).raca(raca).build();
        if (this.decidirCandidatura(newRebelde)) {
            return newRebelde;
        }else {
            return null;
        }
    }

    private boolean decidirCandidatura(Rebelde newRebelde) {
        Random rand = new Random();
        int max = 1;
        int min = 0;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        System.out.println(randomNum);

        if (randomNum == 1) {
            try {
                newRebelde.imprimirCardapio();
                System.out.println("IC diz: 'Candidatura Aceita!'");
                return true;
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("IC diz: 'Candidatura não Aceita!'");
            return false;
        }
    }
}
