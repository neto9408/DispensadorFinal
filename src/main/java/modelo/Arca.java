package modelo;

import java.util.ArrayList;

public class Arca {

	

	private int Denominacion;
	private int tope;
	private ArrayList<Integer> listadoMonedaBilletes = new ArrayList<Integer>();
	public Arca(int denominacion, int tope,
			ArrayList<Integer> listadoMonedaBilletes) {
		super();
	
		Denominacion = denominacion;
		this.tope = tope;
		this.listadoMonedaBilletes = listadoMonedaBilletes;
	}


	public int getDenominacion() {
		return Denominacion;
	}
	public void setDenominacion(int denominacion) {
		Denominacion = denominacion;
		
	}
	public int getTope() {
		return tope;
	}
	public void setTope(int tope) {
		this.tope = tope;
	}
	public ArrayList<Integer> getListadoMonedaBilletes() {
		return listadoMonedaBilletes;
	}
	public void add(int valor){
		
		listadoMonedaBilletes.add(valor);
	}
	public void setListadoMonedaBilletes(ArrayList<Integer> listadoMonedaBilletes) {
		this.listadoMonedaBilletes = listadoMonedaBilletes;
	}
	@Override
	public String toString() {
		return "Arca [Denominacion=" + Denominacion
				+ ", tope=" + tope + ", listadoMonedaBilletes="
				+ listadoMonedaBilletes + "]";
	}
	
	

}

