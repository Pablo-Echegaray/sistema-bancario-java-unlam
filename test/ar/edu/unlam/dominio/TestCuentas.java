package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class TestCuentas {
	CuentaSueldo nuevaCuentaSueldo = new CuentaSueldo(123,1000.0);
	CajaDeAhorros nuevaCajaDeAhorros = new CajaDeAhorros(123,2000.0);
	CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente(123, 200.0);

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
			extraccionDouble = nuevaCuentaSueldo.extraerMonto(EXTRACCION_DEL_SUELDO);
		}
		for (int i = 0; i < 6; i++) {
			nuevaCajaDeAhorros.extraerMonto(EXTRACCION_DEL_AHORRO);
		}

		// nuevaCuentaSueldo.extraer(EXTRACCION_DEL_SUELDO);
		// nuevaCajaDeAhorros.extraer(EXTRACCION_DEL_AHORRO);
		// Validacion
		assertEquals(RESTO_DEL_SUELDO, nuevaCuentaSueldo.getSaldo());
		assertEquals(RESTO_DEL_AHORRO, nuevaCajaDeAhorros.getSaldo());

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
			nuevaCuentaCorriente.extraerMonto(EXTRACCION);
		}
		
		// Validacion
		assertEquals(DEUDA, nuevaCuentaCorriente.getDeudaConBanco());
		assertEquals(sobreGiro, nuevaCuentaCorriente.getSobreGiro());
	}
}
