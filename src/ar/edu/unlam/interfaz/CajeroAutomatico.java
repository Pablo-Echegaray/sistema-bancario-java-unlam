package ar.edu.unlam.interfaz;

import ar.edu.unlam.dominio.Banco;
import ar.edu.unlam.dominio.CajaDeAhorros;
import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.CuentaCorriente;
import ar.edu.unlam.dominio.CuentaSueldo;

public class CajeroAutomatico {

	public static void main(String[] args) {
		Cliente pablo = new Cliente("Pablo", 123);
		Cliente vladimir = new Cliente("Vladimir", 456);
		//Cliente muhammad = new Cliente("Muhammad", 789);
		CuentaSueldo pabloCuentaSueldo = new CuentaSueldo(123,1000.0, pablo);
		CajaDeAhorros pabloCajaDeAhorros = new CajaDeAhorros(123,2000.0, pablo);
		CuentaCorriente pabloCuentaCorriente = new CuentaCorriente(123, 200.0, pablo);
		CuentaSueldo vladiCuentaSueldo = new CuentaSueldo(321, 0.0, vladimir);
		CajaDeAhorros vladiCajaDeAhorros = new CajaDeAhorros(321, 10000.0, vladimir);
		CuentaCorriente vladiCuentaCorriente = new CuentaCorriente(321, -100.0, vladimir);
		Banco bancoNacional = new Banco();
		
		//-----------------------------------------------------------------------
		
//		Double montoAExtraer =pabloCuentaCorriente.extraerMonto(100.0);
//		System.out.println("Monto extraido: " + montoAExtraer);//100
//		System.out.println("\n Saldo restante: " + pabloCuentaCorriente.getSaldo());//100
//		System.out.println("\n Saldo en sobregiro: " + pabloCuentaCorriente.getSobreGiro());//300
       
		//----------------------------------------------------------------------------
//		System.out.println("\n******************************************\n");
//		Double montoAExtraer2 =pabloCuentaCorriente.extraerMonto(200.0);
//		System.out.println("Monto extraido: " + montoAExtraer2);//200
//		System.out.println("\n Saldo restante: " + pabloCuentaCorriente.getSaldo());//-105
//		System.out.println("\n Saldo en sobregiro: " + pabloCuentaCorriente.getSobreGiro());//200
        
		//--------------------------------------------------------------------------------
		
//		System.out.println("\n******************************************\n");
//		Double montoAExtraer3 =pabloCuentaCorriente.extraerMonto(200.0);
//		System.out.println("Monto extraido: " + montoAExtraer3);//200
//		System.out.println("\n Saldo restante: " + pabloCuentaCorriente.getSaldo());//-315
//		System.out.println("\n Saldo en sobregiro: " + pabloCuentaCorriente.getSobreGiro());//0
		
		//-----------------------------------------------------------------------------------
		
//		System.out.println("\n******************************************\n");
//		Double montoAExtraer4 =pabloCuentaCorriente.extraerMonto(200.0);
//		System.out.println("Monto extraido: " + montoAExtraer4);//0.0
//		System.out.println("\n Saldo restante: " + pabloCuentaCorriente.getSaldo());//-315
//		System.out.println("\n Saldo en sobregiro: " + pabloCuentaCorriente.getSobreGiro());//0
		
		//----------------------------------------------------------------------------------------
		Boolean agregarCuentaSueldo = bancoNacional.agregarCuenta(pabloCuentaSueldo);
		Boolean agregarCajaDeAhorros = bancoNacional.agregarCuenta(pabloCajaDeAhorros);
		Boolean agregarCC = bancoNacional.agregarCuenta(pabloCuentaCorriente);
		Double saldoTotal = bancoNacional.consultarSaldoTotalEnCuentas(pablo);
		System.out.println(saldoTotal);//3200
        //-------------------------------------------------------------------------------------------
		System.out.println("\n**********************************************\n");
		//Double saldoEnCC = bancoNacional.validarSaldoEnCuentaCorriente(pablo);
		//System.out.println(saldoEnCC);//200
		Boolean clienteVip= bancoNacional.agregarClienteVip(pablo);
		if(clienteVip) {
			System.out.println("El cliente " + pablo.getNombre() + " fue agregado a clientes VIP");
		}else {
			System.out.println("El cliente indicado no puede ser agregado a la lista VIP");
		}
		
		//----------------------------------------------------------------------------------------
		Boolean agregarCuentaSueldoV = bancoNacional.agregarCuenta(vladiCuentaSueldo);
		Boolean agregarCajaDeAhorrosV = bancoNacional.agregarCuenta(vladiCajaDeAhorros);
		Boolean agregarCCV = bancoNacional.agregarCuenta(vladiCuentaCorriente);
		//-----------------------------------------------------------------------------------
		
		Boolean clienteVip2= bancoNacional.agregarClienteVip(vladimir);
		if(clienteVip2) {
			System.out.println("El cliente " + vladimir.getNombre() + " fue agregado a clientes VIP");
		}else {
			System.out.println("El cliente indicado no puede ser agregado a la lista VIP");
		}
		
		Cliente []clientesVip = bancoNacional.getClientesVip();
		for(int i=0; i<clientesVip.length; i++) {
			if(clientesVip[i]!=null) {
				System.out.println("Cliente VIP: " + clientesVip[i].getNombre() + " DNI: " + clientesVip[i].getDni());
			}
		}
	}

}
