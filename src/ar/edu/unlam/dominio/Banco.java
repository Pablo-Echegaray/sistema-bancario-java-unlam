package ar.edu.unlam.dominio;

public class Banco {
	
	private Cuenta[] cuentas;
	
	
	public Banco() {
		this.cuentas = new Cuenta[12];
		
	}
	
	public Boolean agregarCuenta(Cuenta cuenta) {
		Boolean seAgrego = false;
		for(int i=0; i< cuentas.length; i++) {
			if(cuentas[i]!=null && cuentas[i] == cuenta) {
				break;
			}
			if(cuentas[i]==null) {
				cuentas[i] = cuenta;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}

}
