package paqCilindro;

public class Cilindro {
	private double altura;
	private Circulo base;
	
	public Cilindro(Circulo c, double h) {
		base = c;
		altura = h;
	}

	public double altura() {
		return altura;
	}

	public void altura(double altura) {
		this.altura = altura;
	}

	public Circulo base() {
		return base;
	}

	public void base(Circulo base) {
		this.base = base;
	}
	
	public void trasladar(double x, double y) {
		base.trasladar(x, y);
	}

	@Override
	public String toString() {
		return "Cilindro (" + base + "," + altura + ")";
	}
	
	
	
}
