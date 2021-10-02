package ar.edu.unlam.dominio;

public class CuentaCorriente extends Cuenta{

	private Double sobreGiro;
	private Double deudaConBanco;
	
	public CuentaCorriente(Integer cbu, Double saldo) {
	
		 super(cbu, saldo);
		 this.sobreGiro=300.0;
		 this.deudaConBanco=0.0;
		
	}
	
	
	
	public Double getSobreGiro() {
		return sobreGiro;
	}


	public Double getDeudaConBanco() {
		return deudaConBanco;
	}


	public Double extraerMonto(Double extraccion) {
		
		double importeRetirado;

		if (extraccion <= super.getSaldo()) {
			importeRetirado = extraccion;
			super.setSaldo(super.getSaldo() - extraccion);
		} else if (extraccion <= (super.getSaldo() + this.sobreGiro)) {
			this.sobreGiro -= (extraccion - super.getSaldo());
			this.deudaConBanco += ((extraccion - super.getSaldo()) *5) /100 ;
			super.setSaldo(super.getSaldo());
			importeRetirado = extraccion;
		} else {
			importeRetirado = 0.0d;
		}
		return importeRetirado;
		
	}
	
}
