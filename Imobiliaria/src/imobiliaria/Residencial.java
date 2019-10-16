
package imobiliaria;

public class Residencial extends Imovel{
    private int numQuartos;

    public Residencial(int codigo, String regiao, int numQuartos,  double valor, boolean disponivel) {
        super(codigo, regiao, valor, disponivel);
        this.numQuartos = numQuartos;
    }

    public int getNumQuartos() {
        return numQuartos;
    }

    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    @Override
    public String toString() {
        return "Residencial{" + "numQuartos=" + numQuartos + '}';
    }
    
    
}
