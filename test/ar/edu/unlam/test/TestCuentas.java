package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import ar.edu.unlam.dominio.Banco;
import ar.edu.unlam.dominio.CajaDeAhorros;
import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.CuentaCorriente;
import ar.edu.unlam.dominio.CuentaSueldo;

public class TestCuentas {
	// 1- Preparacion:
	// 1a- Dato de entrada
	// 1b- Valores esperados
	// --------------------------------------------
	// Ejecucion
	// Validacion
	Cliente pablo = new Cliente("Pablo", 123);
	Cliente vladimir = new Cliente("Vladimir", 456);
	Cliente muhammad = new Cliente("Muhammad", 789);
	CuentaSueldo pabloCuentaSueldo = new CuentaSueldo(123,1000.0, pablo);
	CajaDeAhorros pabloCajaDeAhorros = new CajaDeAhorros(123,2000.0, pablo);
	CuentaCorriente pabloCuentaCorriente = new CuentaCorriente(123, 200.0, pablo);
	Banco bancoNacional = new Banco();

	/*
	 * @Test public void testInstanciacionCuentas() { // 1- Preparacion: // 1a- Dato
	 * de entrada final Double saldoCuentaSueldo = 1000.0; final Double
	 * saldoCajaAhorro = 2000.0;
	 * 
	 * // 1b- Valores esperados
	 * 
	 * // Ejecucion CuentaSueldo nuevaCuentaSueldo = new
	 * CuentaSueldo(saldoCuentaSueldo); CajaDeAhorros nuevaCajaDeAhorros = new
	 * CajaDeAhorros(saldoCajaAhorro); // Validacion assertEquals(saldoCuentaSueldo,
	 * nuevaCuentaSueldo.getSaldo()); assertEquals(saldoCajaAhorro,
	 * nuevaCajaDeAhorros.getSaldo()); }
	 */

	@Test
	public void testExtraccionDeImporte() {
		// 1- Preparacion:
		// 1a- Dato de entrada
		final Double EXTRACCION_DEL_SUELDO = 455.0;
		final Double EXTRACCION_DEL_AHORRO = 250.0;
		Double extraccionDouble = 99.9;
		// 1b- Valores esperados
		// final Double RESTO_DEL_SUELDO = 545.0;
		// final Double RESTO_DEL_AHORRO = 1445.0;
		final Double RESTO_DEL_SUELDO = 90.0;
		final Double RESTO_DEL_AHORRO = 494.0;
		// --------------------------------------------

		// Ejecucion
		for (int i = 0; i < 2; i++) {
			extraccionDouble = pabloCuentaSueldo.extraerMonto(EXTRACCION_DEL_SUELDO);
		}
		for (int i = 0; i < 6; i++) {
			pabloCajaDeAhorros.extraerMonto(EXTRACCION_DEL_AHORRO);
		}

		// nuevaCuentaSueldo.extraer(EXTRACCION_DEL_SUELDO);
		// nuevaCajaDeAhorros.extraer(EXTRACCION_DEL_AHORRO);
		// Validacion
		assertEquals(RESTO_DEL_SUELDO, pabloCuentaSueldo.getSaldo());
		assertEquals(RESTO_DEL_AHORRO, pabloCajaDeAhorros.getSaldo());

	}
	
	@Test
	public void testCuentaCorriente() {
		// 1- Preparacion:
				// 1a- Dato de entrada
		final Double EXTRACCION = 100.0;
		// 1b- Valores esperados
		final Double DEUDA = 15.0;
		final Double sobreGiro= 0.0;
		// --------------------------------------------

				// Ejecucion
		for(int i = 0; i<5; i++) {
			pabloCuentaCorriente.extraerMonto(EXTRACCION);
		}
		
		// Validacion
		assertEquals(DEUDA, pabloCuentaCorriente.getDeudaConBanco());
		assertEquals(sobreGiro, pabloCuentaCorriente.getSobreGiro());
	}
	
	@Test
	public void testAgregarCuentasAlBanco() {
		// 1- Preparacion:
		// 1a- Dato de entrada
		Boolean seAgregoCuentaSueldo = bancoNacional.agregarCuenta(pabloCuentaSueldo);
		Boolean seAgregoCajaDeAhorros=bancoNacional.agregarCuenta(pabloCajaDeAhorros);
		Boolean seAgregoCuentaCorriente=bancoNacional.agregarCuenta(pabloCuentaCorriente);
		Boolean seAgregaOtraVez = bancoNacional.agregarCuenta(pabloCuentaCorriente);
		// 1b- Valores esperados
		Boolean verdadero = true;
		// --------------------------------------------
		// Ejecucion
		// Validacion
		assertEquals(verdadero, seAgregoCuentaSueldo);
		assertEquals(verdadero, seAgregoCajaDeAhorros);
		assertEquals(verdadero, seAgregoCuentaCorriente);
		assertEquals(false, seAgregaOtraVez);
	}
	
}
