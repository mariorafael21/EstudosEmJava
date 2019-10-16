
package imobiliaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Imobiliaria {
     private ArrayList<Imovel> imoveis = new ArrayList<>();
    String regiao;
    double valorImovel;
    int codigo;
    Scanner ler = new Scanner(System.in);
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Imobiliaria i = new Imobiliaria();
        i.exibirMenu();
        
        int menu;
        
        do{
            
            menu = ler.nextInt();
            
            
            switch(menu){
                case 1:
                    System.out.println("---Cadastro");
                    break;
                case 2:
                    
                    break;
                    
                default:
                    System.out.println("Saindo");
            
            }
        
        }while(menu != 3);
    }
    public void exibirMenu(){
    
        int opcao;
        do{
            System.out.println("----Menu Imobiliária----");
            System.out.println("1 - Cadastrar Imóvel");
            System.out.println("2 - Alugar Imóvel");
            System.out.println("3 - Sair");
            System.out.println("--------------------------");
            
            opcao = ler.nextInt();
            switch(opcao){
                case 1:
                    cadastrarImoveis();
                    break;
                case 2:
                    alugarImoveis();
                    break;
                case 3:
                    listarImoveis();
                    break;
                case 4:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao != 4);
    }
    
    private void cadastrarImoveis(){
        int opcao;
        int qtdQuartos;
        double areaUtil;
        do{
            System.out.println("--------Cadastrar Imóvel--------");
            System.out.println("1 - Residencial");
            System.out.println("2 - Comercial");
            System.out.println("3 - Voltar");
            System.out.println("-------------------------------- ");
            opcao = ler.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("\n==> CADASTRO IMOVEL RESIDENCIAL <==");
                    System.out.print("Digite o codigo do imovel: ");
                    codigo = ler.nextInt();
                    System.out.print("Digite a região do imóvel: ");
                    regiao = ler.next();
                    System.out.print("Digite a quantidade de quartos: ");
                    qtdQuartos = ler.nextInt();
                    System.out.print("Digite o valor do imóvel: ");
                    valorImovel = ler.nextDouble();
                    
                    imoveis.add(new Residencial(codigo,regiao, qtdQuartos,  valorImovel, true ));
                    System.out.println("Imóvel cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("\n==> CADASTRO IMOVEL COMERCIAL <==");
                    System.out.print("Digite o codigo do imovel: ");
                    codigo = ler.nextInt();
                    System.out.print("Digite a área útil do imóvel em (m): ");
                    areaUtil = ler.nextDouble();
                    System.out.print("Digite a região do imóvel: ");
                    regiao = ler.next();
                    System.out.print("Digite o valor do imóvel: ");
                    valorImovel = ler.nextDouble();
                    
                    imoveis.add(new Comercial(codigo, areaUtil, regiao, valorImovel, true ));
                    System.out.println("Imóvel cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("ESTAMOS VOLTANDO");
                    break;
                default:
                    System.out.println("Opção inválida");
                    
            }
        }while(opcao != 3);
    }
    
    private boolean listarImoveis(){
        if(!imoveis.isEmpty()){
            for(Imovel i: imoveis){
                System.out.println("Código: " + i.getCodigo() + " Localidade: " + i.getRegiao() + " Valor: " + i.getValor() + " Disponibilidade: " + i.isDisponivel());
            }
            return true;
            
        }else{
            System.out.println("Sem imóveis cadastrados");
            return false;
        }
    }
    
    private void alugarImoveis(){
        int codigo;
        listarImoveis();
        // colocar uma condição de saida caso não tenha imoveis cadastrado no momento
        System.out.println("Digite o código do imóvel desejado: ");
        codigo = ler.nextInt();
        for(int i = 0; i < imoveis.size(); i++){
            if(imoveis.get(i).getCodigo() == codigo){
                if(imoveis.get(i).isDisponivel()){ // 
                    imoveis.get(i).setDisponivel(false);
                    System.out.println("Imóvel alugado com sucesso!");
                    
                }else{
                    System.out.println("Imóvel indisponível");
                }
            }
        }
    }
}

