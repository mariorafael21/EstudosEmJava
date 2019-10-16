
package lojajava;

public class Vendedor extends Funcionario{
    private double vendas;

    public Vendedor(String nome, String cpf, int matricula, double salario, double vendas){
        super(nome, cpf, matricula, salario);
        this.vendas = vendas;
    }

    public double getVendas(){
        return vendas;
    }

    public void setVendas(double vendas){
        this.vendas = vendas;
    }
    
    @Override
    public double calculaPagamento(){
        return (getSalario() * (1.10 * getVendas()));
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nVendas: " + vendas;
    }
    
}
