package prJarras;

public class Jarra {
	private final int capacidad;
	private int contenido;
	
	public Jarra(int capacidadInicial) {	
		if (capacidadInicial <= 0) {
			throw new RuntimeException("No se puede crear una Jarra con capacidad <= 0");
		}
		capacidad = capacidadInicial;
		contenido = 0;
	}
	
	public int capacidad() {
		return capacidad;
	}
	
	public int contenido() {
		return contenido;
	}
	
	public void llena() {
		contenido = capacidad;
	}
	
	public void vacia() {
		contenido = 0;
	}
	
	public void llenaDesde(Jarra j) {
		if (this == j) { // son la misma jarra (el mismo objeto)
			throw new RuntimeException("No se puede llenar una jarra desde ella misma");
		}
		int minimo = Math.min(j.contenido, capacidad-contenido);
		contenido += minimo;
		j.contenido -= minimo;
	}
	
	@Override
	public String toString() {
		return "J(" + capacidad + "," + contenido + ")";
	}
	 
}
