package modelo;

public class Producto {

	private String codigoProducto;
	private String nombreProducto;
	private int valor;
	private boolean existencia;
	public Producto(String codigoProducto, String nombreProducto, int valor,
			boolean existencia) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.valor = valor;
		this.existencia = existencia;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean isExistencia() {
		return existencia;
	}
	public void setExistencia(boolean existencia) {
		this.existencia = existencia;
	}
	public String toString() {
		return "producto [codigoProducto=" + codigoProducto
				+ ", nombreProducto=" + nombreProducto + ", valor=" + valor
				+ ", existencia=" + existencia + "]";
	}

	

}