package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.ControladorDistribuidorArca;
import controlador.ControladorUsuario;
import modelo.Arca;
import modelo.Leer;
import modelo.Producto;

public class Usuario {
	ControladorUsuario cU = new ControladorUsuario();
	ControladorDistribuidorArca cDA = new ControladorDistribuidorArca();
	Producto producto = null;
	Leer leer = new Leer();

	public void menu (){
	
		int opc=0;
		if(cDA.isEstadoServicio()==true){
		do{
		System.out.println("Estado de servicio de la maquina: ACTIVO");
		System.out.println("digite \n 1. Comprar Producto \n 2.ver productos \n 3.ver arcas \n 4. ingresar como administrador \n 5. salir");
		opc= leer.datoInt();
		
		switch (opc) {
		case 1:ingresarDinero();
			
			break;
			
		case 2:verProductos();
		
		break;
		
		case 3:verArca();
		
		break;
		
		case 4:ingresoAdmin();
	
		break;
		
		default:
			break;
		}
		}while(opc!=5);
		}else{
			int opc2=0;
			do{
			System.out.println("estado de servicio de la maquina: INACTIVA");
			System.out.println("por por favor ingrese como administrador para activar la maquina");
			int pass =leer.datoInt();
			if(pass==cDA.getPassWordAdmin()){
				menu2();
				opc2=1;
			}else{
				System.out.println("password incorrecto");
			}
			}while(opc2!=1);
		}
	}


	public void ingresarDinero() {
		// TODO Auto-generated method stub
		String codigo="";
		int din=1;
		int saldo=0;
		int cambio=0;
		
		ArrayList<Integer> dinero = new ArrayList<Integer>();
		
		System.out.println("digite el codigo del producto");
		codigo=leer.dato();
		
		if(cU.buscarProducto(codigo)!=null){
			producto=cU.buscarProducto(codigo);
			System.out.println("el producto encontrado fue"+producto);
		
		
		while(din!=0){
			
			System.out.println("digite la denominacion o 0 si ya completo el dinero");
			din=leer.datoInt();
			
			if(din!=0){
				dinero.add(din);
				saldo=saldo+din;
			}
			System.out.println("saldo"+saldo);
			
		}
		
		cambio=cU.ingresarSaldo(dinero, codigo);
		if(cambio>=0){
		System.out.println("el valor del producto es: "+producto.getValor());
		System.out.println("su saldo era de: "+saldo);
		System.out.println("el cambio es: "+cambio);
		}else{
			System.out.println("el valor del producto es: "+producto.getValor());
			System.out.println("saldo"+saldo);
			System.out.println("fondos insufucientes para comprar el producto");
		}
		}else{
			System.out.println("producto no encontrado");
		}
		if(cambio==saldo){
			System.out.println("denominacion ingresada no valida");
		}
	}

	

	public void verProductos() {
		
		cU.imprimir();
	}

	public void verArca() {
		
		cU.imprimirArcas();
	}
	
	public void ingresoAdmin(){
		
		System.out.println("digigte el password");
		int pass = leer.datoInt();
		
		if(cDA.getPassWordAdmin()==pass){
			menu2();
		}else{
			System.out.println("password incorrecta");
		}
	}
	public void menu2(){
		
		int opc=0;
	
		System.out.println("BIENVENIDO ADMIN");
		do{
		System.out.println("Estado de Servicio de la Maquina: "+cDA.isEstadoServicio());
		System.out.println("digite \n 1. modificar producto \n 2.modificar existencia \n 3.modificar denominacion arca \n 4. modificar tope Arca \n 5. modificar estado de la maquina \n 6. ver productos \n 7. ver arca \n 8. volver al menu anterior");
		opc= leer.datoInt();
		
		switch (opc) {
		case 1:modificarProducto();
			
			break;
			
		case 2:modificarExistencia();
		
		break;
		
		case 3:modificarDenominacion();
		
		break;
		
		case 4:modificarTope();
	
		break;
		
		case 5:modificarEstadoMaquina();
		
		break;
		
		case 6:verProductos();
		
		break;
		
		case 7:verArca();
		
		break;
		
		case 8:menu();
		
		break;
		
		default:
			break;
		}
		}while(opc!=8);
	}
	
	public void modificarProducto(){
		
		System.out.println("ingrese el codigo del producto");
		String codigo=leer.dato();
		
		System.out.println("ingrese el nuevo valor del producto");
		int valor =leer.datoInt();
		
		System.out.println("ingrese el nuevo nombre del producto");
		String nombre =leer.dato();
		
		cU.modificarProducto(codigo, nombre, valor);
	}
	
	public void modificarExistencia(){
		
		System.out.println("ingrese el codigo del producto");
		String codigo =leer.dato();
		
		System.out.println("ingrese el nuevo tipo de existencia del producto");
		boolean existencia=leer.datoBoolean();
		
		cU.modificarExistencia(codigo, existencia);
	}
	
	public void modificarDenominacion(){
		System.out.println("ingrese la denominacion antigua del arca");
		int denominacionAntigua=leer.datoInt();
		
		System.out.println("ingrese la denominacion nueva del arca");
		int denominacion=leer.datoInt();
		
		cU.modificarDenominacionArca(denominacionAntigua, denominacion);
	}
	
	public void modificarTope(){
		System.out.println("ingrese la denominacion del arca");
		int denominacion=leer.datoInt();
		
		System.out.println("ingrese el nuevo tope del arca");
		int tope=leer.datoInt();
		
		cU.modificarTopeArca(denominacion, tope);
	}
	
	public void modificarEstadoMaquina(){
		System.out.println("digite true para activar la maquina o false para desactivarla");
		boolean estado =leer.datoBoolean();
		
		cDA.setEstadoServicio(estado);
	}
}
