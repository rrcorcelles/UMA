package prJarras;

public class Mesa {
	private Jarra jarra1, jarra2;
	
	public Mesa (Jarra j1, Jarra j2) {
		if (j1 == j2) { // son la misma jarra (el mismo objeto)
			throw new RuntimeException("No se puede crear una Mesa con una única Jarra");
		}
		jarra1 = j1;
		jarra2 = j2;
	}
	
	public Mesa(int cj1, int cj2) {
		this(new Jarra(cj1),new Jarra(cj2));
	}
	
	private void controlError(int j, String m) {
		if (j != 1 && j != 2) {
			throw new RuntimeException("Jarra especificada erronea en " + m);
		}
	}
	
	public int capacidad(int j) {
		controlError(j, "capacidad");
		
		return (j == 1) ? jarra1.capacidad() : jarra2.capacidad();
	}
	
	public int contenido(int j) {
		controlError(j, "contenido");
		
		return (j == 1) ? jarra1.contenido() : jarra2.contenido();
	}
	
	public void llena(int j) {
		controlError(j, "llena");
		
		if (j == 1) {
			jarra1.llena();
		} else {
			jarra2.llena();
		}
	}

	public void vacia(int j) {
		controlError(j, "vacia");
		
		if (j == 1) {
			jarra1.vacia();
		} else {
			jarra2.vacia();
		}
	}
	
	public void llenaDesde(int j) {
		controlError(j, "llenaDesde");
		
		if (j == 1) {
			jarra2.llenaDesde(jarra1);
		} else {
			jarra1.llenaDesde(jarra2);
		}
	}
	
	@Override
	public String toString() {
		return "M(" + jarra1 + "," + jarra2 + ")";
	}
}
