package paqCilindro;

public class Punto {

	private double x;
	private double y;
	
	public Punto() {
		x=0;
		y=0;
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double abscisa() {
		return x;
	}

	public void abscisa(double x) {
		this.x = x;
	}

	public double ordenadas() {
		return y;
	}

	public void ordenadas(double y) {
		this.y = y;
	}
	
	public void trasladar(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public double distancia(Punto p) {
		double n;
		n = Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
		return n;
	}

	@Override
	public String toString() {
		return "Punto (" + x + "," + y + ")";
	}
	
	
	
	
	
}
