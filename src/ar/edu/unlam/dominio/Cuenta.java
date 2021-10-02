package ar.edu.unlam.dominio;

public abstract class Cuenta {
	
	private Integer cbu;
	private Double saldo;
	private TipoCuenta tipoCuenta;
	private Cliente cliente;
	
	public Cuenta(Integer cbu, Double saldo, Cliente cliente) {
		this.cbu=cbu;
		this.saldo=saldo;
		this.cliente = cliente;
	}

	public Integer getCbu() {
		return cbu;
	}

	public Cliente getCliente() {
		return cliente;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cbu == null) ? 0 : cbu.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((tipoCuenta == null) ? 0 : tipoCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (cbu == null) {
			if (other.cbu != null)
				return false;
		} else if (!cbu.equals(other.cbu))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (tipoCuenta != other.tipoCuenta)
			return false;
		return true;
	}
	
	
	
}
