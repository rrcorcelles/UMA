package prJarras;

public class Mesa {
	
	private Jarra jarra1, jarra2;
	
	public Mesa(Jarra j1, Jarra j2) {
		if (j1 == j2) {
			throw new RuntimeException("Las dos jarras son iguales");
		}
		jarra1 = j1;
		jarra2 = j2;
	}
	
	public Mesa(int cnt1, int cnt2) {
		this( new Jarra(cnt1), new Jarra(cnt2));
	}
	
	public int capacidad(int i) {
		int n;
		if(i==1) {
			n=jarra1.capacidad();
		}else {
			n=jarra2.capacidad();
		}
		return n;
	}
	
	public int contenido(int i) {
		int n;
		if(i==1) {
			n=jarra1.contenido();
		}else {
			n=jarra2.contenido();
		}
		return n;
	}
	
	public void llena(int i) {
		if(i==1) {
			jarra1.llena();
		}else {
			jarra2.llena();
		}
	}
	
	public void vacia(int i) {
		if(i==1) {
			jarra1.vacia();
		}else {
			jarra2.vacia();
		}	
	}
	
	public void llenaDesde(int i) {
		if(i==1) {
			jarra2.llenaDesde(jarra1);
		}else {
			jarra1.llenaDesde(jarra2);
		}	
	}

	@Override
	public String toString() {
		return "(" + jarra1 + "," + jarra2 + ")";
	}
	
	
	
	
	
}
