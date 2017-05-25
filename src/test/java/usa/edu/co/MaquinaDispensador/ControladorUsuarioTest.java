package usa.edu.co.MaquinaDispensador;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import controlador.ControladorUsuario;
import modelo.Producto;

public class ControladorUsuarioTest {
	ControladorUsuario a = null;

	@Before
	public void setUp() throws Exception {
		a = new ControladorUsuario(); 	
	} 

	@Test
	public void testDeberiaDevolver0SiIngresa1000y500ya0() {
		
		ArrayList<Integer> plata = new ArrayList<Integer>();
		plata.add(1000);
		plata.add(500);	
		elaborarPruebaIngresarSaldo(plata, "a0", 0);		
	}
	
	@Test
	public void testDeberiaDevolverMensajeErrorSiIngresaBillete10000() {
		ArrayList<Integer> plata = new ArrayList<Integer>();
		plata.add(10000);
	elaborarPruebaIngresarSaldo(plata, "a0", 8500);
	System.out.println("saldo:"+ plata);
	}
	
	@Test
	public void testDeberiaDevolver200() {
		ArrayList<Integer> dinero = new ArrayList<Integer>();
		dinero.add(200);
		dinero.add(500);
		dinero.add(500);
		dinero.add(1000);
		elaborarPruebaIngresarSaldo(dinero , "a1", 200);
	}
	
	@Test
	public void testDeberiaDevolverdevolvermenos100() {
		ArrayList<Integer> dinero = new ArrayList<Integer>();
		
		dinero.add(200);
		dinero.add(200);
		dinero.add(1000);
		elaborarPruebaIngresarSaldo(dinero , "a1", -1);
	}
	
	
	@Test 
	public void TestModificarProductoA1(){
	
		String  codigo = "a1";		
		String nombre = "chitos";
		int precio=  2000;
		PruebaModificarProducto(codigo, nombre, precio, 1);		
	}
	@Test 
	public void TestModificarProductob1(){
	
		String  codigo = "a2";		
		String nombre = "galletas";
		int precio=  2000;
		PruebaModificarProducto(codigo, nombre, precio, 1);		
	}
	@Test
	public void TestModificarexistenciaAfalso(){
		String codigo= "a2";
		boolean existencia =  false;
		PruebaModificarExistencia(codigo, existencia, 1);
		
	}
	@Test
	public void TestModificarexistenciaAfalso1(){
		String codigo= "a2";
		boolean existencia =  true;
		PruebaModificarExistencia(codigo, existencia, 1);
		
	}
	private void elaborarPruebaIngresarSaldo(ArrayList<Integer> dinero, String codigo, int esperado) {
		int salida = a.ingresarSaldo(dinero, codigo);
		assertEquals(esperado, salida);
	}
	
	private void PruebaModificarProducto(String codigo, String nombre, int precio, int esperado){
		int prueba1=  a.modificarProducto(codigo, nombre, precio);	
		assertEquals(esperado, prueba1);
		
	}
	private void PruebaModificarExistencia(String codigo, boolean existencia, int esperado){
		int prueba2 = a.modificarExistencia(codigo, existencia);
		assertEquals(esperado, prueba2);
		
		
	}
	
	
}
