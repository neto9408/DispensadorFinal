package modelo;

import java.util.ArrayList;

public class Espiral {

	
	private String id_espiral;
	private int topeEspiral;
	private ArrayList<Producto> listaProducto = new ArrayList();
	
	
	
	public Espiral(String id_espiral, int tipoEspiral,
			ArrayList<Producto> listaProducto) {
		super();
		this.id_espiral = id_espiral;
		this.topeEspiral = tipoEspiral;
		this.listaProducto = listaProducto;
	}
	public String getId_espiral() {
		return id_espiral;
	}
	public void setId_espiral(String id_espiral) {
		this.id_espiral = id_espiral;
	}
	public int getTopeEspiral() {
		return topeEspiral;
	}
	public void setTipoEspiral(int tipoEspiral) {
		this.topeEspiral = topeEspiral;
	}
	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}
	public void addListaProducto(Producto producto) {
		listaProducto.add(producto);
	}

	@Override
	public String toString() {
		return "espiral [id_espiral=" + id_espiral + ", topeEspiral="
				+ topeEspiral + "]";
	}
	
	
}
