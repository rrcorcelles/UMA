package prLibreria;

public class Libro {
	private String autor, titulo;
	private double precioBase;
	private static double porcIVA = 10;
	
	public Libro(String a, String t, double p) {
		autor = a;
		titulo = t;
		precioBase = p;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public double getPrecioFinal() {
		return precioBase + precioBase * porcIVA / 100;
	}

	@Override
	public String toString() {
		return "(" + autor + "; " + titulo + "; " 
				+ precioBase + "; " + porcIVA + "%; " 
				+ getPrecioFinal() + ")";
	}
	
	public static double getIVA() {
		return porcIVA;
	}

	public static void setIVA(double pIVA) {
		porcIVA = pIVA;
	}
	
	
	
	
	
}
