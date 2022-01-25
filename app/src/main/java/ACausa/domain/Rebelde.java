package ACausa.domain;

import ACausa.enums.Raca;
import lombok.*;

import java.io.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rebelde {
    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private int idade;

    @Getter
    @Setter
    private Raca raca;

    public void imprimirCardapio() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            FileWriter myWriter = new FileWriter("ListaAprovados.txt", true);
            myWriter.write("Nome: " + this.getNome() + "; Idade: " + this.getIdade() + "; Raça: " + this.getRaca() + "\n");
            myWriter.close();
            System.out.println("Rebelde Adicionado a 'ListaAprovados.txt'!");
        } catch (IOException e) {
            System.out.println("Algo deu errado");
            e.printStackTrace();
        }
    }
}