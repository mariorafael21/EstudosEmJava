
package jogobaralho;

public class Carta {
    private final String FACE;
    private final String NAIPE;

    public Carta(String mface, String mnaipe) {
        this.FACE = mface;
        this.NAIPE = mnaipe;
    }

    @Override
    public String toString() {
        return this.FACE + " de " + this.NAIPE; 
    }  

    public String getFACE() {
        return FACE;
    }

    public String getNAIPE() {
        return NAIPE;
    }
    
}
