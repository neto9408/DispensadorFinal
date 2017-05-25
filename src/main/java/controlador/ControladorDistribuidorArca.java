package controlador;

import java.util.ArrayList;

import modelo.Arca;

public class ControladorDistribuidorArca {


	private int cantidadArcas = 10;
	private int passWordAdmin = 12345;
	private boolean estadoServicio = true;
	

	public ArrayList<Integer> precargarDatos(){
		
		ArrayList<Integer> listaDinero1 = new ArrayList<Integer>();

		listaDinero1.add(100);
		listaDinero1.add(100);
		listaDinero1.add(100);
		listaDinero1.add(100);
		listaDinero1.add(100);
		
		return listaDinero1;
	}
	
	public ArrayList<Integer> precargarDato2(){
		
		

		ArrayList<Integer> listaDinero2 = new ArrayList<Integer>();

		listaDinero2.add(200);
		listaDinero2.add(200);
		listaDinero2.add(200);
		listaDinero2.add(200);
		listaDinero2.add(200);
		
		return listaDinero2;
	}
	
	public ArrayList<Integer> precargarDatos3(){
		

		ArrayList<Integer> listaDinero3 = new ArrayList<Integer>();

		listaDinero3.add(500);
		listaDinero3.add(500);
		listaDinero3.add(500);
		listaDinero3.add(500);
		listaDinero3.add(500);
		
		return listaDinero3;
		
	}
	
	public ArrayList<Integer> precargarDatos4(){
		

		ArrayList<Integer> listaDinero4 = new ArrayList<Integer>();


		
		listaDinero4.add(1000);
		listaDinero4.add(1000);
		listaDinero4.add(1000);
		listaDinero4.add(1000);
		listaDinero4.add(1000);
		
		return listaDinero4;
		
	}
	
	public ArrayList<Integer> precargarDatos5(){
		

		ArrayList<Integer> listaDinero5 = new ArrayList<Integer>();

		
		listaDinero5.add(2000);
		listaDinero5.add(2000);
		listaDinero5.add(2000);
		listaDinero5.add(2000);
		listaDinero5.add(2000);
		
		return listaDinero5;
		
	}
	
	public ArrayList<Integer> precargarDatos6(){
		

		ArrayList<Integer> listaDinero6 = new ArrayList<Integer>();

		listaDinero6.add(5000);
		listaDinero6.add(5000);
		listaDinero6.add(5000);
		listaDinero6.add(5000);
		listaDinero6.add(5000);
		
		return listaDinero6;
		
	}
	
	public ArrayList<Arca> precargarDatos7(){
		
		ArrayList<Arca> listaArcas = new ArrayList<Arca>();
		
		listaArcas.add(new Arca(5000, 10, listaDinero6));
		listaArcas.add(new Arca(2000, 10, listaDinero5));
		listaArcas.add(new Arca(1000, 10, listaDinero4));
		listaArcas.add(new Arca(500, 10, listaDinero3));
		listaArcas.add(new Arca(200, 10, listaDinero2));
		listaArcas.add(new Arca(100, 10, listaDinero1));
		
		return listaArcas;
	}
	
	ArrayList<Integer> listaDinero1 = precargarDatos();
	ArrayList<Integer> listaDinero2 = precargarDato2();
	ArrayList<Integer> listaDinero3 = precargarDatos3();
	ArrayList<Integer> listaDinero4 = precargarDatos4();
	ArrayList<Integer> listaDinero5 = precargarDatos5();
	ArrayList<Integer> listaDinero6 = precargarDatos6();
	
	public ArrayList<Arca> listaArcas = precargarDatos7();
	

	public int asignarDineroArca (ArrayList<Integer> cantidadDineroIngresado){
		int retorno=0;
		for (int i = 0; i < cantidadDineroIngresado.size(); i++) {
			
			for (int j = 0; j < listaArcas.size(); j++) {
				
					
				if(listaArcas.get(j).getListadoMonedaBilletes().size()<listaArcas.get(j).getTope()){
						
					if(listaArcas.get(j).getDenominacion()==cantidadDineroIngresado.get(i)){
						//System.out.println(listaArcas.get(j).getDenominacion());
						//getListaArcas();
						listaArcas.get(j).add(cantidadDineroIngresado.get(i));
						
						retorno=1;
					}
				}else{
					
					if(listaArcas.size()<cantidadArcas){
						ArrayList<Integer>dinero = new ArrayList<Integer>();
						dinero.add(cantidadDineroIngresado.get(i));
						listaArcas.add(new Arca(cantidadDineroIngresado.get(i),listaArcas.get(j).getTope(),dinero));
					}else{
						retorno=-1;
					}
				}
				
			
			}
		}
		return retorno;
		
	}
	
	public int devolverDineroArca(int cambio){
		int retorno=0;
		for (int i = 0; i < listaArcas.size(); i++) {
			
			for (int j = 0; j < listaArcas.get(i).getListadoMonedaBilletes().size(); j++) {
				
				if(listaArcas.get(i).getListadoMonedaBilletes().get(j)<=cambio){
					cambio=cambio-listaArcas.get(i).getListadoMonedaBilletes().get(j);
					listaArcas.get(i).getListadoMonedaBilletes().remove(j);
					retorno=cambio;
				}else{
					retorno=-1;
				}
			}
		}
		
		return retorno;
	}
	
	public int cambiarDenominacionArca(int denominacionAntigua, int denominacion){
			int retorno=0;
			ArrayList<Integer> nuevaDenominacion = new ArrayList<Integer>();
		for (int i = 0; i < listaArcas.size(); i++) {
			if(listaArcas.get(i).getDenominacion()==denominacionAntigua){
			
				listaArcas.get(i).setDenominacion(denominacion);
				
				for (int j = 0; j < listaArcas.get(i).getListadoMonedaBilletes().size(); j++) {
					nuevaDenominacion.add(denominacion);
					
				}
				retorno=1;
				listaArcas.get(i).setListadoMonedaBilletes(nuevaDenominacion);
				i=listaArcas.size()-1;
				
				
			}else{
				retorno=-1;
			}
		}
		return retorno;
	}
	
	public int cambiarTopeArca(int denominacion, int tope){
		int retorno=0;
		
		for (int i = 0; i < listaArcas.size(); i++) {
			if(listaArcas.get(i).getDenominacion()==denominacion){
			
				listaArcas.get(i).setTope(tope);
			
				retorno=1;
				i=listaArcas.size()-1;
			
			}else{
				retorno=-1;
			}
		}
		
		return retorno;
	}
	
	
	public ArrayList<Arca> getListaArcas() {
		return listaArcas;
	}

	public void setListaArcas(ArrayList<Arca> listaArcas) {
		this.listaArcas = listaArcas;
	}
	public int getPassWordAdmin() {
		return passWordAdmin;
	}
	
	public boolean isEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(boolean estadoServicio) {
		this.estadoServicio = estadoServicio;
	}
}
