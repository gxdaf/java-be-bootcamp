public class Conta {
    
    private static int numConta = 1111;
    private final int agenciaConta = 2222;
	public enum TipoConta {
        CORRENTE("Corrente"),
        POUPANCA("Poupança");
    
        private String tipo;
    
        TipoConta(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
    
    }

    private int agencia;
	private int numero;
	private double saldo = 0;
	private Cliente cliente;
    private TipoConta tipoConta;

	public Conta(Cliente cliente, String tpConta) {
		this.agencia = agenciaConta;
		this.numero = numConta++;
		this.cliente = cliente;
        switch (tpConta) {
            case "Poupança":
                this.tipoConta = TipoConta.POUPANCA;
                break;
            case "Corrente":
                this.tipoConta = TipoConta.CORRENTE;
                break;
            default: 
                throw new IllegalArgumentException("Conta inválida.");
        };
	}

	public void sacar(double valor) {
		saldo -= valor;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	
	public void imprimirExtrato() {
		System.out.println(String.format("=== Extrato Conta %s ===\nAgência: %d\nNúmero da conta: %d\nNome do titular: %s\nSaldo atual: %.2f", this.tipoConta, this.agencia, this.numero, this.cliente.getNome(), this.saldo));
		
	}

		
	}