package ar.edu.unlam.dominio;



public class Banco {
	
	private Cuenta[] cuentas;
	private Cliente [] clientesVip;
	private Integer count=0;
	
	
	public Banco() {
		this.cuentas = new Cuenta[12];
		this.clientesVip=new Cliente[5];
		
	}
	
	public Cliente[] getClientesVip() {
		return clientesVip;
	}
	
	public Boolean agregarCuenta(Cuenta cuenta) {
		Boolean seAgrego = false;
		for(int i=0; i< this.cuentas.length; i++) {
			if(this.cuentas[i]!=null && this.cuentas[i] == cuenta) {
				break;
			}
			if(this.cuentas[i]==null) {
				this.cuentas[i] = cuenta;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}
	
	public Cuenta[] consultarCuentasDeCliente(Cliente cliente) {
		Cuenta [] cuentas = new Cuenta[3];
		Integer cantidad = 0;
		for(int i=0; i< this.cuentas.length; i++) {
			if(this.cuentas[i] != null) {
				if(this.cuentas[i].getCliente().equals(cliente) ) {
					if(cantidad < cuentas.length) {
					cuentas[cantidad++] = this.cuentas[i];
					}
				}
				
			}
		}
		
		
		return cuentas;
	}
	
	public Double consultarSaldoTotalEnCuentas(Cliente cliente) {
		Cuenta [] cuentas= consultarCuentasDeCliente(cliente);
		Double sumaDeSaldos = 0.0;
		for(int i=0; i<cuentas.length; i++) {
			if(cuentas[i] != null) {
				sumaDeSaldos+=cuentas[i].getSaldo();
			}
				
		}
		return sumaDeSaldos;
	}
	
	private Double validarSaldoEnCuentaCorriente(Cliente cliente) {
		Double saldoCC=0.0;
		Cuenta [] cuentas= consultarCuentasDeCliente(cliente);
		for(int i=0; i<cuentas.length; i++) {
			if(cuentas[i]!=null)
				if(cuentas[i].getTipoCuenta().equals(TipoCuenta.CUENTA_CORRIENTE)) {
					saldoCC = cuentas[i].getSaldo();
					break;
				}
		}
		return saldoCC;
	}
	
	public Boolean agregarClienteVip(Cliente cliente) {
		Boolean vip=false;
		
		Double haberes = consultarSaldoTotalEnCuentas(cliente);
		Double saldoCC = validarSaldoEnCuentaCorriente(cliente);
		if(haberes >= 2000.0 && saldoCC > 0) {
			clientesVip[count++] = cliente;
			vip=true;
		}
		return vip;
	}
	

}
