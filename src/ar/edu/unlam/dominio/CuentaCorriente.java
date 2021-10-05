package ar.edu.unlam.dominio;

public class CuentaCorriente extends Cuenta{

	private Double sobreGiro;
	private Double deudaConBanco;
	
	public CuentaCorriente(Integer cbu, Double saldo, Cliente cliente) {
	
		 super(cbu, saldo, cliente);
		 this.sobreGiro=300.0;
		 this.deudaConBanco=0.0;
		 super.setTipoCuenta(TipoCuenta.CUENTA_CORRIENTE);
		
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
			
		} 
		else if (extraccion <= (super.getSaldo() + this.sobreGiro) && super.getSaldo()>0) {
			this.sobreGiro -= (extraccion - super.getSaldo());
			this.deudaConBanco = ((extraccion - super.getSaldo()) *5) /100 ;
			
			importeRetirado = extraccion;
			super.setSaldo(super.getSaldo() - (importeRetirado + this.deudaConBanco));
		} 
		
		else if(extraccion<= this.sobreGiro) {
			this.sobreGiro -= extraccion;
			this.deudaConBanco = extraccion * 5 / 100;
			importeRetirado = extraccion;
			super.setSaldo(super.getSaldo() - (importeRetirado + deudaConBanco));
		}
		
		else {
			importeRetirado = 0.0d;
		}
		return importeRetirado;
		
	}
	
	
	
}
