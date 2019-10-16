
package imobiliaria;

public class Comercial extends Imovel{
    private double area;

    public Comercial(int codigo, double area,  String regiao, double valor, boolean disponivel) {
        super(codigo, regiao, valor, disponivel);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Comercial{" + "area=" + area + '}';
    }
    
    
}
