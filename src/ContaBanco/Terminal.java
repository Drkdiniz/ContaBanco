package ContaBanco;

import java.util.Locale;
import java.util.Scanner;

public class Terminal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ContaTerminal conta = null;
		
		while (true) {
			System.out.println("\nBem-vindo ao Banco Digital!");
			System.out.println("1. Abrir nova conta");
			System.out.println("2. Depositar");
			System.out.println("3. Sacar");
			System.out.println("4. Ver Saldo");
			System.out.println("5. Pagar Mensalidade");
			System.out.println("6. Fechar Conta");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = sc.nextInt();
		
			if (opcao == 1) {
			    if (conta == null) {
			        sc.nextLine();  
			        System.out.println("\nVamos começar com a abertura da sua conta ....");
			        
			        System.out.print("\nDigite o seu nome completo: ");
			        String nomeCliente = sc.nextLine().toUpperCase();
			        
			        System.out.print("\nEscolha CC para conta corrente e CP para conta poupança: ");
			        String tipo = sc.next().toUpperCase();
			        
			        conta = new ContaTerminal(); 
			        conta.setNomeCliente(nomeCliente);
			        conta.abrirConta(tipo);
			        
			    } else {
			    	System.out.println("Já existe uma conta ativa.");
			    	
			    }
			}
			else if (opcao == 2) {
				System.out.print("Informe o valor para depósito: ");
				double valorDeposito = sc.nextDouble();
				conta.depositar(valorDeposito);
			}
			else if (opcao == 3) {
				System.out.print("Informe o valor para saque: ");
				double valorSaque = sc.nextDouble();
				conta.sacar(valorSaque);
			}
			else if (opcao == 4) {
				System.out.println("Seu saldo é: " + String.format("%.2f",conta.getSaldo()));
			}
			else if (opcao == 5) {
				conta.pagarMensal();
			} 
			else if (opcao == 6) {
				conta.fecharConta();
			}
			else if (opcao == 0) {
				System.out.println("Obrigado por utilizar nosso banco, volte sempre!");
				break;
			    
			}
		}
		
		sc.close(); 
	}
	
}
			        
			        
			
			        
	            
	            		
	            	
