package ar.edu.unlam.dominio;

public class CajaDeAhorros extends Cuenta {

	private Integer nroExtraccion = 0;
	private final Integer ADICIONAL = 6;
	private final Integer MAXIMO_EXTRACCION = 5;

	public CajaDeAhorros(Integer cbu,Double saldo, Cliente cliente) {
		super(cbu,saldo, cliente);
		super.setTipoCuenta(TipoCuenta.CAJA_AHORRO);
	}

	//@Override
//	public Double extraerMonto(Double extraccion) {
//		Double importeRetirado;
//		if (this.nroExtraccion > MAXIMO_EXTRACCION && super.getSaldo() > (extraccion + ADICIONAL)) {
//			importeRetirado = super.extraer(extraccion);
//			super.extraer(6.0);
//		} else {
//			importeRetirado = super.extraer(extraccion);
//			this.nroExtraccion++;
//		}
//		return importeRetirado;
//	}
	
	public Double extraerMonto(Double monto) {
		Double maximoExtraccion= super.getSaldo();
		if(nroExtraccion>MAXIMO_EXTRACCION) {
			maximoExtraccion = super.getSaldo() - ADICIONAL;
		}
		if(monto<=maximoExtraccion) {
			if(nroExtraccion<MAXIMO_EXTRACCION) {
				super.setSaldo(super.getSaldo()-monto);
				nroExtraccion++;
				
				
			}else {
				super.setSaldo(super.getSaldo()-monto-ADICIONAL);
			}
		}
		return monto;
	}

}
