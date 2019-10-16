
package lojajava;

public class Cliente extends Pessoa{
    private String codigo;
    
    Cliente(String codigo, String nome, String cpf){
        super(nome, cpf);
        this.codigo = codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo do cliente: " + codigo;
    }
    
}
