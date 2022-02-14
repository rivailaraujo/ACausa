package ACausa.utils;

import ACausa.domain.Rebelde;

import java.util.LinkedList;

public class Ordenador {
    public LinkedList<Rebelde> ordenarRebeldesPorIdade (LinkedList<Rebelde> rebeldes){
        for (int i = 0; i < rebeldes.size() - 1; i++) {
            for (int j = i + 1; j < rebeldes.size(); j++) {
                if (rebeldes.get(i).getIdade() > rebeldes.get(j).getIdade()) {
                    Rebelde temp_rebelde = rebeldes.get(i);
                    rebeldes.set(i, rebeldes.get(j)) ;
                    rebeldes.set(j, temp_rebelde);
                }
            }
        }
        return rebeldes;
    }
    public LinkedList<Rebelde> ordenarRebeldesPorNome (LinkedList<Rebelde> rebeldes){
        for (int i = 0; i < rebeldes.size() - 1; i++) {
            for (int j = i + 1; j < rebeldes.size(); j++) {
                if (rebeldes.get(i).getNome().compareTo(rebeldes.get(j).getNome()) > 0) {
                    Rebelde temp_rebelde = rebeldes.get(i);
                    rebeldes.set(i, rebeldes.get(j)) ;
                    rebeldes.set(j, temp_rebelde);
                }
            }
        }
        return rebeldes;
    }

    public LinkedList<Rebelde> ordenarRebeldesPorRaca (LinkedList<Rebelde> rebeldes){
        for (int i = 0; i < rebeldes.size() - 1; i++) {
            for (int j = i + 1; j < rebeldes.size(); j++) {
                if (rebeldes.get(i).getRaca().toString().compareTo(rebeldes.get(j).getRaca().toString()) > 0) {
                    Rebelde temp_rebelde = rebeldes.get(i);
                    rebeldes.set(i, rebeldes.get(j)) ;
                    rebeldes.set(j, temp_rebelde);
                }
            }
        }
        return rebeldes;
    }
}
