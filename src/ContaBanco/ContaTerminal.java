package ContaBanco;

public class ContaTerminal {
	private int numConta;
	private String agencia;
	private String tipo;
	private String nomeCliente;
	private double saldo;
	private Boolean status;
	
	


	public ContaTerminal() {
		this.numConta = (int) (Math.random() * 10000);
        this.agencia = "001";
		this.numConta = numConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.status = status;
	}


	public int getNumConta() {
		return numConta;
	}


	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
		
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public void abrirConta(String tipo) {
        setTipo(tipo); 
        this.status = true; 
        if (this.tipo.equals("CC")) {
        	this.saldo = 50.00;
        }
        else {
        	this.saldo = 150.00;
        }
        System.out.printf("\n\nOlá %s, obrigado por criar uma conta em nosso banco, sua agência é: %s, conta: %d e seu saldo %.2f já está disponível para saque.\n\n",
        		getNomeCliente(), getAgencia(), getNumConta(), getSaldo());
    }
	 
	public void fecharConta() {
		if (saldo > 0) {
			System.out.println("Conta com dinheiro.");
		}
		else if (saldo < 0) {
			System.out.println("Conta com débito");
		}
		else {
			this.status = false;
			System.out.println("Conta encerrada");
		}
	}
		
	public void depositar(double valor) {
		if (this.status) {
			if (valor > 0) {
				setSaldo(getSaldo() + valor);
				System.out.println("Depósito realizado com sucesso.\nNovo saldo: "+ String.format("%.2f", getSaldo()));
			} else {
				System.out.println("Valor de depósito deve ser positivo.");
			}
		} else {
			System.out.println("Não é possível depositar em uma conta fechada.");
		}
	}
	
	public void sacar(double valor) {
		if (this.status) {
			if (getSaldo() >= valor ) {
				setSaldo(getSaldo() - valor);
				System.out.println("Saque realizado com sucesso.\nNovo saldo: "+ String.format("%.2f", getSaldo()));
			}
			else {
				System.out.println("Saldo insuficiente.");
			}
		}
		else {
			System.out.println("Conta inativa, contate um gerente.");
		}
	}
	public void pagarMensal() {
		int valor;
		if (this.tipo.equals("CC")) {
			valor = 12;
		}
		else {
			valor = 20;
		}
		if (this.status) {
			if (getSaldo() > valor) {
				setSaldo(getSaldo() - valor);
				System.out.println("Mensalidade paga com sucesso !");
			}
			else {
				System.out.println("Saldo insuficiente.");
			}
		}
		else {
			System.out.println("Conta inativa.");
		}
	}

	
}



