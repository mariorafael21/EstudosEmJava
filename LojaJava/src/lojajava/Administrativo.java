
package lojajava;

public class Administrativo extends Funcionario{
    private double horas;
    
    public Administrativo(String nome, String cpf, int matricula, double salario, double horas) {
        super(nome, cpf, matricula, salario);
        this.horas = horas;
    }

    public double getHoras(){
        return horas;
    }

    public void setHoras(double horas){
        this.horas = horas;
    }

    @Override
    public double calculaPagamento() {
        return (getSalario() * (1.01 * getHoras()));
    }

    @Override
    public String toString() {
        return super.toString() + "\nHoras do administrador: " + horas;
    }
    
}
