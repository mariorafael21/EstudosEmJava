
package jogobaralho;

public class Jogador {
    private final String NOME;
    private Carta[] cartas;

    public Jogador(String nome) {
        this.NOME = nome;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }
    
    public Carta getCarta(int i) {
        return cartas[i - 1];
    }
    
    public void trocarCarta(int i, Carta c) {
        cartas[i - 1] = c;
    }
    
    
    public void mostrarCartas() {
        System.out.println("-----------CARTAS DE " + NOME.toUpperCase() + "------------------");
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }
    
    
}
