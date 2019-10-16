
package lojajava;

import java.util.ArrayList;
import java.util.Scanner;

public class LojaJava {
    private ArrayList<Pessoa> lista = new ArrayList<>();
    private Scanner ler = new Scanner(System.in);
    private String nome, cpf;
    private int matricula;
    private double salario;
    
    public static void main(String[] args) {
        LojaJava loja = new LojaJava();
        loja.menu();
    }
    public void menu(){
        int opcao;
        do{
            System.out.println("\t ==> BEM VINDO A LOJA JAVA <==");
            System.out.println("1-FAZER CADASTRO");
            System.out.println("2-REMOVER");
            System.out.println("3-FAZER BUSCA");
            System.out.println("4-LISTAR TODOS");
            System.out.println("5-ADICIONAR PRODUTIVIDADE");
            System.out.println("6-GERAR FOLHA DE PAGAMENTO");
            System.out.println("7-SAIR");
            System.out.print(": ");
            opcao = ler.nextInt();
            switch(opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    adicionarProdutividade();
                    break;
                case 6:
                    gerarFolhaPagamento();
                    break;
                case 7:
                    System.out.println("OK, ESTAMOS SAINDO");
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
            }
        }while(opcao != 7);
    }
    
    private void cadastrar(){
        int opcao;
        do{
            System.out.println("1-CLIENTE");
            System.out.println("2-ADMINISTRATIVO");
            System.out.println("3-VENDEDOR");
            System.out.println("4-SAIR");
            System.out.print(": ");
            opcao = ler.nextInt();
            switch(opcao){
                case 1:
                    System.out.print("DIGITE O CODIGO DO CLIENTE: ");
                    String codigo = ler.next();
                    System.out.print("DIGITE O NOME: ");
                    nome = ler.next();
                    System.out.print("DIGITE O CPF: ");
                    cpf = ler.next();
                    
                    lista.add(new Cliente(codigo, nome, cpf));
                    break;
                case 2:
                    System.out.print("DIGITE O NOME DO FUNCIONARIO: ");
                    nome = ler.next();
                    System.out.print("DIGITE O CPF: ");
                    cpf = ler.next();
                    System.out.print("DIGITE A MATRICULA: ");
                    matricula = ler.nextInt();
                    System.out.print("DIGITE O SALARIO: ");
                    salario = ler.nextDouble();
                    System.out.println("DIGITE AS HORAS: ");
                    double horas = ler.nextDouble();
                    lista.add(new Administrativo(nome, cpf, matricula, salario, horas));
                    break;   
                case 3:
                    System.out.print("DIGITE O NOME DO VENDEDOR: ");
                    nome = ler.next();
                    System.out.print("DIGITE O CPF: ");
                    cpf = ler.next();
                    System.out.print("DIGITE A MATRICULA: ");
                    matricula = ler.nextInt();
                    System.out.print("DIGITE O SALARIO: ");
                    salario = ler.nextDouble();
                    System.out.print("DIGITE AS VENDAS: ");
                    double vendas = ler.nextDouble();
                    lista.add(new Vendedor(nome, cpf, matricula, salario, vendas));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ESTA OPÇAO NÃO É VALIDA");
                    
            }
        }while(opcao != 4);
    }
    
    private Pessoa buscar(String cpf){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCpf().equalsIgnoreCase(cpf)){
                return lista.get(i);
            }
        }
        return null;
    }
    
    private void buscar(){
        System.out.print("INFORME O CPF: ");
        cpf = ler.next();
        if(buscar(cpf) != null){
            System.out.println(buscar(cpf).toString());
        }else{
            System.out.println("USUÁRIO NÃO CADASTRADO");
        }
    }
    
    private void remover(){
        System.out.print("INFORME O CPF: ");
        cpf = ler.next();
        if(buscar(cpf) != null){
            lista.remove(buscar(cpf));
        }else{
            System.out.println("USUÁRIO NÃO CADASTRADO");
        }
    }
    
    private void listar(){
        int i=1;    
        
        if(!lista.isEmpty()){ // isEmpty para saber se esta vazia usado uma negaçao, para, se a lista não estiver vazia, faça
          for(Pessoa c : lista){ 
            System.out.println("==> CADASTRO " +(i++) + "<==");
            System.out.println("Nome: " + c.getNome() + " CPF: " + c.getCpf());
           
        }
        }else{
            System.out.println("==> NÃO EXISTE CADASTROS PARA SEREM LISTADOS <==");
        } 
    }
    
    private void adicionarProdutividade(){
        System.out.print("INFORME O CPF: ");
        cpf = ler.next();
        Pessoa p = buscar(cpf);
        if(p != null){
            p = buscar(cpf);
            
            if(p instanceof Administrativo){  // instanceof para saber se é instancia da classe, separar o joio do trigo 
                System.out.print("DIGITE A PRODUTIVIDADE EM HORAS: ");
            double produtividade = ler.nextDouble();
                ((Administrativo) p).setHoras(produtividade);
            }else if(p instanceof Vendedor){
                System.out.print("DIGITE A PRODUTIVIDADE NO VALOR DAS VENDAS: ");
            double produtividade = ler.nextDouble();
                ((Vendedor) p).setVendas(produtividade);
            }else{
                System.out.println("NÃO EXISTE PRODUTIVIDADE PARA SER ADICIONADA");
            }
        }else{
            System.out.println("CPF NÃO CADASTRADO");
        }
    }
    
    private void gerarFolhaPagamento(){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) instanceof Administrativo){
                ((Administrativo) lista.get(i)).calculaPagamento();
                System.out.println(((Administrativo) lista.get(i)).toString());
            }else if(lista.get(i) instanceof Vendedor){
                ((Vendedor) lista.get(i)).calculaPagamento();
                System.out.println(((Vendedor) lista.get(i)).toString());
            }
        }
    }
    
}

