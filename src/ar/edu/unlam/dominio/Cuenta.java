package ar.edu.unlam.dominio;

public abstract class Cuenta {
	
	private Integer cbu;
	private Double saldo;
	private TipoCuenta tipoCuenta;
	
	public Cuenta(Integer cbu, Double saldo) {
		this.cbu=cbu;
		this.saldo=saldo;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	public abstract Double extraerMonto(Double monto);
	
	public Boolean depositarMonto(Double monto) {
		Boolean sePudoDepositar = false;
		if(monto>0) {
			this.saldo += monto;
			sePudoDepositar = true;
		}
		
		return sePudoDepositar;
		
	}
	
}
