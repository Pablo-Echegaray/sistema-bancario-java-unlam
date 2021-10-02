package ar.edu.unlam.dominio;

public class CuentaSueldo extends Cuenta{

	public CuentaSueldo(Integer cbu, Double saldo) {
		super(cbu, saldo);
		super.setTipoCuenta(TipoCuenta.SUELDO);
	}


//	public void depositar(Double saldo) {
//		if (saldo > 0) {
//			this.saldo += saldo;
//		} else {
//			System.out.println("No se puede depositar un valor negativo");
//		}
//	}

	public Double extraerMonto(Double extraccion) {
		if (extraccion <= super.getSaldo() && extraccion > 0) {
			super.setSaldo(super.getSaldo() - extraccion);
		} else {
			
			extraccion = 0.0;
		}
		return extraccion;
	}

}
