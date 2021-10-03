package ar.edu.unlam.dominio;



public class Banco {
	
	private Cuenta[] cuentas;
	
	
	public Banco() {
		this.cuentas = new Cuenta[12];
		
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

}
