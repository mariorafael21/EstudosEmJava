
package jogobaralho;

import java.util.Scanner;

public class Jogo {
    private final Scanner entrada = new Scanner(System.in);
    private final Baralho BARALHO;
    private Jogador[] jogadores;

    public Jogo() {
        BARALHO = new Baralho();
        BARALHO.mostrarBaralho();
        BARALHO.embaralhar();
        BARALHO.mostrarBaralho();
        BARALHO.cartasRestantes();
        BARALHO.puxarCarta();
    }

    public void iniciarJogo() {
        int qtdJogadores = 0;

       // do {
       //     System.out.println("Quantos jogadores irao participar? (maximo de 7 jogadores)");
       //     qtdJogadores = entrada.nextInt();
      //  } while (qtdJogadores > 2);

        jogadores = new Jogador[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Jogador " + i + ", digite seu nome:");
            jogadores[i] = new Jogador(entrada.next());
        }
    }

    public void distribuirCartas(int qtdCartas) {
        for (Jogador jogadore : jogadores) {
            jogadore.setCartas(BARALHO.distribuirCartas(qtdCartas));
        }
    }

    public void mostrarCartas() {
        for (Jogador jogador : jogadores) {
            jogador.mostrarCartas();
        }
    }
    public void pegaCarta(){
       BARALHO.puxarCarta();
    }
}    
