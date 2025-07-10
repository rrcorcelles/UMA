package paqCilindro;

public class Circulo {
	private double radio;
	private Punto centro;
	
	public Circulo(Punto p, double rad) {
		centro = p;
		radio  = rad;
	}

	public double radio() {
		return radio;
	}

	public void radio(double radio) {
		this.radio = radio;
	}

	public Punto centro() {
		return centro;
	}

	public void centro(Punto centro) {
		this.centro = centro;
	}
	
	public void trasladar(double x, double y) {
		centro.trasladar(x, y);
	}
	
	public double area() {
		double n;
		n = Math.PI * radio * radio;
		return n;
	}

	@Override
	public String toString() {
		return "Circulo (" + centro + "," + radio + ")";
	}
	
	
}
