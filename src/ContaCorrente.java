
public class ContaCorrente extends Conta {

	private double limiteChequeEspecial= 0;
	private double totalDepositado = 0;

	private int faixas = 0;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void depositar(double valor) {

		// Executa e valida o depósito na classe Conta.
		super.depositar(valor);

		// Acumula o valor depositado na conta-corrente.
		totalDepositado += valor;

		// Calcula as faixas completas de R$ 1.000.
		faixas = (int) (totalDepositado / 1000);

		// Concede R$ 500 por faixa.
		limiteChequeEspecial = faixas * 500;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();

		System.out.printf(
				"Limite de cheque especial: R$ %.2f%n",
				limiteChequeEspecial
		);
	}
	
}
