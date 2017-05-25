package usa.edu.co.MaquinaDispensador;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controlador.ControladorDistribuidorArca;

public class ControladorDistribuidorArcaTest {
	ControladorDistribuidorArca  d;

	@Before
	public void imprimir(){
		d = new ControladorDistribuidorArca();		
	}
	@Test
	public void testImprimirArca100(){
		ArrayList<Integer> listaDinero = new ArrayList<Integer>();
		listaDinero.add(100);
		listaDinero.add(100);
		listaDinero.add(100);
		listaDinero.add(100);
		listaDinero.add(100);
		elaborarPruebaImprimirArca(listaDinero,1);
	
	}
	@Test
	public void testImprimirArca200(){
		ArrayList<Integer> listaDinero2 = new ArrayList<Integer>();
		listaDinero2.add(200);
		listaDinero2.add(200);
		elaborarPruebaImprimirArca(listaDinero2, 1);
	
	}
	
	@Test
	public void devolver200(){
		int cambio = 200; 
		TestDevolverDinero(cambio, -1);
	}
	@Test
	public void devolver1000(){
		int cambio = 1000; 
		TestDevolverDinero(cambio, -1);
	}
	private void elaborarPruebaImprimirArca(ArrayList<Integer> cantidadDineroIngresado,  int esperado) {
		int salida = d.asignarDineroArca(cantidadDineroIngresado);
		assertEquals(esperado, salida);
	}
	private void TestDevolverDinero(int cambio, int expectativa){
		int salida= d.devolverDineroArca(cambio);
		assertEquals(expectativa, salida);
	}
}
