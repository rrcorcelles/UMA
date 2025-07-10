package prJarras;

public class Jarra {
	
	private int contenido;
	private int capacidad;
	
	public Jarra(int n) {
		if(n<0) {
			throw new RuntimeException("Error: no puede ser la capacidad menor que 0");
		}
		capacidad = n;
		contenido = 0;
	}

	public int contenido() {
		return contenido;
	}

	public int capacidad() {
		return capacidad;
	}
	
	public void llena() {
		contenido = capacidad;
	}
	
	public void vacia() {
		contenido = 0;
	}
	
	public void llenaDesde(Jarra j){
		if(j.equals(this)) {
			throw new RuntimeException("La dos jarras son la misma");
		}
		if(j.contenido >= (capacidad - contenido)) {
			j.contenido -= (capacidad - contenido);
			llena();
			
		}else {
			contenido += j.contenido;
			j.vacia();	
		}
	}

	@Override
	public String toString() {
		return "J(" + capacidad + ", " + contenido + ")";
	}
	
	
	
	

	
}
