
public class Main {

	public static void main(String[] args){
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		try {
			cc.depositar(-100);
		} catch (IllegalArgumentException e) {
			System.out.println("Depósito recusado: " + e.getMessage());
		}
		cc.depositar(300);
		// Primeiro depósito: ainda não alcançou R$ 1.000.
		cc.depositar(600);
		cc.imprimirExtrato();

		// Segundo depósito: acumulado de R$ 1.300.
		cc.depositar(700);
		cc.imprimirExtrato();

		// Terceiro depósito: acumulado de R$ 2.200.
		cc.depositar(900);
		cc.imprimirExtrato();

		// Teste da validação de depósito negativo.
		try {
			cc.depositar(-100);
		} catch (IllegalArgumentException e) {
			System.out.println("Depósito recusado: " + e.getMessage());
			cc.imprimirExtrato();
		}


		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
