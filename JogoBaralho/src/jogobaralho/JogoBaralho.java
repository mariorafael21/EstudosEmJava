
package jogobaralho;

public class JogoBaralho {

    public static void main(String[] args) {
        
        Jogo executar = new Jogo();
        Baralho baralho = new Baralho();
        executar.iniciarJogo();
        executar.distribuirCartas(9);
        executar.mostrarCartas();
        
        baralho.distribuirCartas(9);
        baralho.mostrarBaralho();
        
        
        
       
        
        
        
    
    }
}
