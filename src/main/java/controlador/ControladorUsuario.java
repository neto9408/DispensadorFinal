package controlador;

import java.util.ArrayList;

import javax.print.attribute.standard.PDLOverrideSupported;

import modelo.Arca;
import modelo.Espiral;
import modelo.Producto;

public class ControladorUsuario {

	//private ArrayList<Espiral> listaEspiral = new ArrayList();
	private ControladorDistribuidorArca arca = new ControladorDistribuidorArca();
	private int cantidadDineroIngresado;
	private int cambio;
	
	//ArrayList<Producto> listaProducto1 = new ArrayList<Producto>();
	//ArrayList<Producto> listaProducto2 = new ArrayList<Producto>();
	//ArrayList<Producto> listaProducto3 = new ArrayList<Producto>();
	
	public ArrayList<Producto> precargar(){
		//arca.precargarDatos();
		
		ArrayList<Producto> listaProducto1 = new ArrayList<Producto>();
		
		listaProducto1.add(new Producto("a0","Pasta en conchitas Doria 250 g.",1500,true));
		listaProducto1.add(new Producto("a1","Spaguetti Doria 250 g.",2000,true));
		listaProducto1.add(new Producto("a2","Cereal desayuno Zucaritas 420 g.",3000,true));
		listaProducto1.add(new Producto("a3","Fríjol rojo 1K",1200,true));
		listaProducto1.add(new Producto("a4","Pasta en conchitas Doria 250 g.",2100,true));
		listaProducto1.add(new Producto("a5","Duraznos en almíbar 822 g. neto",4500,true));
		listaProducto1.add(new Producto("a6","Mantequilla con sal Alpina 250 g.",2500,true));
		listaProducto1.add(new Producto("a7","Chocolate Sol 1 lb.",1800,true));
		listaProducto1.add(new Producto("a8","Café instantáneo Colcafe 170 g.",500,true));
		listaProducto1.add(new Producto("a9","Azúcar blanca Manuelita 1 K.",1500,true));
		
		return listaProducto1;
	}
	
	public ArrayList<Producto> precargar1(){
		//arca.precargarDatos();
		
		
		ArrayList<Producto> listaProducto2 = new ArrayList<Producto>();
		
		
		listaProducto2.add(new Producto("b0","Aceite Girasoli 1L",2000,true));
		listaProducto2.add(new Producto("b1","Sal Refisal 1K",1500,true));
		listaProducto2.add(new Producto("b2","Huevos bandeja 30 unidades",3500,true));
		listaProducto2.add(new Producto("b3","Leche Alquería larga vida 900 ml",5000,true));
		listaProducto2.add(new Producto("b4","Arroz FlorHuila 1lb",1000,true));
		listaProducto2.add(new Producto("b5","Lentejas 1K",1200,true));
		listaProducto2.add(new Producto("b6","Clorox 1 L fragancia original",2000,true));
		listaProducto2.add(new Producto("b7","Fabuloso 1 L ",3200,true));
		listaProducto2.add(new Producto("b8","Detergente Fab 3 K",800,true));
		listaProducto2.add(new Producto("b9","Jabón barra Fab original",1300,true));
		
		return listaProducto2;
	}
	
	public ArrayList<Producto> precargar2(){
		//arca.precargarDatos();
		
		
		ArrayList<Producto> listaProducto3 = new ArrayList<Producto>();
		
		
		listaProducto3.add(new Producto("c0","Jabón barra Coco Varela 300 g.",1300,true));
		listaProducto3.add(new Producto("c1","Limpiavidrios Easy Off 500 ml.",4000,true));
		listaProducto3.add(new Producto("c2","Sabra paquete 3 Bom Bril",1300,true));
		listaProducto3.add(new Producto("c3","Brillaollas Scoth Brite 6 unidades",1800,true));
		listaProducto3.add(new Producto("c4","Lavaplatos Axion Limón 500 g.",5000,true));
		listaProducto3.add(new Producto("c5","Ambientador Glade 360 cm3",2400,true));
		listaProducto3.add(new Producto("c6","Crema Colgate x 3 unidades menta",2200,true));
		listaProducto3.add(new Producto("c7","Listerine Fresh Burst 500 ml. ",2200,true));
		listaProducto3.add(new Producto("c8","Jabón Protex Fresh x 3 ",3200,true));
		listaProducto3.add(new Producto("c9","Jabón líquido para manos Fiamme ",2000,true));
		
		return listaProducto3;
	}
	
	public ArrayList<Espiral> precargar3(){
		ArrayList<Espiral> listaEspiral = new ArrayList();
		listaEspiral.add(new Espiral("1",5,listaProducto1));
		listaEspiral.add(new Espiral("2",5,listaProducto2));
		listaEspiral.add(new Espiral("2",5,listaProducto3));
		
		return listaEspiral;
	}
	
	ArrayList<Producto> listaProducto1 = precargar();
	ArrayList<Producto> listaProducto2 = precargar1();
	ArrayList<Producto> listaProducto3 = precargar2();
	private ArrayList<Espiral> listaEspiral = precargar3();
	
	public int ingresarSaldo(ArrayList<Integer> cantidadDineroIngresado, String codigoProducto){
		int retorno=0;
		int cambio=0;
		int cantidadDinero=0;
		
		for (int i = 0; i < cantidadDineroIngresado.size(); i++) {
			cantidadDinero=cantidadDinero+cantidadDineroIngresado.get(i);
		}
	
		
		for (int i = 0; i < listaEspiral.size(); i++) {
			for (int j = 0; j <listaEspiral.get(i).getTopeEspiral() ; j++) {
				if(listaEspiral.get(i).getListaProducto().get(j).getCodigoProducto().equalsIgnoreCase(codigoProducto)){
					if(listaEspiral.get(i).getListaProducto().get(j).getValor()<=cantidadDinero){
						retorno=cambio=cantidadDinero-listaEspiral.get(i).getListaProducto().get(j).getValor();
						arca.asignarDineroArca(cantidadDineroIngresado);
						arca.devolverDineroArca(cambio);
						if(cambio>=0){
						listaEspiral.get(i).getListaProducto().remove(j);
						}else{
						retorno=-1;
						}
					}else{
						retorno= -1;
					}
				}
			}
		}
		

		
		return retorno;
	}
	
	public int modificarProducto(String codigo, String nombre, int precio){
		int retorno=0;
		for (int i = 0; i < listaEspiral.size(); i++) {
			
			for (int j = 0; j < listaEspiral.get(i).getListaProducto().size(); j++) {
				//System.out.println(listaEspiral.get(i).getListaProducto().get(j));
				if(listaEspiral.get(i).getListaProducto().get(j).getCodigoProducto().equalsIgnoreCase(codigo)){
					
					listaEspiral.get(i).getListaProducto().get(j).setNombreProducto(nombre);
					listaEspiral.get(i).getListaProducto().get(j).setValor(precio);
					//System.out.println(listaEspiral.get(i).getListaProducto());
					retorno=1;
					i=listaEspiral.size()-1;
					j=listaEspiral.get(i).getListaProducto().size()-1;
				}else{
					retorno=-1;
				}
			}
		}
		return retorno;
	}
	
	public int modificarExistencia(String codigo, boolean existencia){
		int retorno=0;
		for (int i = 0; i < listaEspiral.size(); i++) {
			
			for (int j = 0; j < listaEspiral.get(i).getListaProducto().size(); j++) {
				//System.out.println(listaEspiral.get(i).getListaProducto().get(j));
				if(listaEspiral.get(i).getListaProducto().get(j).getCodigoProducto().equalsIgnoreCase(codigo)){
					
					listaEspiral.get(i).getListaProducto().get(j).setExistencia(existencia);
					
					//System.out.println(listaEspiral.get(i).getListaProducto());
					retorno=1;
					i=listaEspiral.size()-1;
					j=listaEspiral.get(i).getListaProducto().size()-1;
					break;
				}else{
					retorno=-1;
				}
			}
		}
		return retorno;
	}
	
	public int modificarDenominacionArca(int denominacionAntigua, int denominacion){
		int retorno=0;
		retorno=arca.cambiarDenominacionArca(denominacionAntigua, denominacion);
		
		return retorno;
	}
	
	public int modificarTopeArca(int denominacion, int tope){
		int retorno=0;
		retorno=arca.cambiarTopeArca(denominacion, tope);
		
		return retorno;
	}
	
	public Producto buscarProducto(String codigo){
		Producto producto = null;
		for (int i = 0; i < listaEspiral.size(); i++) {
			
			for (int j = 0; j < listaEspiral.get(i).getListaProducto().size(); j++) {
				if(listaEspiral.get(i).getListaProducto().get(j).getCodigoProducto().equalsIgnoreCase(codigo)){
					producto= listaEspiral.get(i).getListaProducto().get(j);
					
				}
			}
		}
		return producto;
	}

	
	public void imprimir(){

		for (int i = 0; i < listaEspiral.size(); i++) {
			
			for (int j = 0; j < listaEspiral.get(i).getListaProducto().size(); j++) {
				System.out.println(listaEspiral.get(i).getListaProducto().get(j));
			}
		}
		
		//System.out.println(arca.getListaArcas());
	}
	
	public void imprimirArcas(){
		
		System.out.println(arca.getListaArcas());
	}

	public ControladorDistribuidorArca getArca() {
		return arca;
	}

	public void setArca(ControladorDistribuidorArca arca) {
		this.arca = arca;
	}

	public int getCantidadDineroIngresado() {
		return cantidadDineroIngresado;
	}

	public void setCantidadDineroIngresado(int cantidadDineroIngresado) {
		this.cantidadDineroIngresado = cantidadDineroIngresado;
	}

	public int getCambio() {
		return cambio;
	}

	public void setCambio(int cambio) {
		this.cambio = cambio;
	}

	public ArrayList<Producto> getListaProducto1() {
		return listaProducto1;
	}

	public void setListaProducto1(ArrayList<Producto> listaProducto1) {
		this.listaProducto1 = listaProducto1;
	}

	public ArrayList<Producto> getListaProducto2() {
		return listaProducto2;
	}

	public void setListaProducto2(ArrayList<Producto> listaProducto2) {
		this.listaProducto2 = listaProducto2;
	}

	public ArrayList<Producto> getListaProducto3() {
		return listaProducto3;
	}

	public void setListaProducto3(ArrayList<Producto> listaProducto3) {
		this.listaProducto3 = listaProducto3;
	}

	public ArrayList<Espiral> getListaEspiral() {
		return listaEspiral;
	}

	public void setListaEspiral(ArrayList<Espiral> listaEspiral) {
		this.listaEspiral = listaEspiral;
	}

}