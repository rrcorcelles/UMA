package prLibreria;

public class Libro {
	private static double porcIVA = 10;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro(String aut, String tit, double prec) {
		autor = aut;
		titulo = tit;
		precioBase = prec;
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
		return getPrecioBase() + getPrecioBase() * porcIVA / 100;
	}
	
	@Override
	public String toString() {
		return "(" + autor + "; " + titulo + "; " + getPrecioBase() + "; " + getIVA() + "; " + getPrecioFinal() + ")";
	}

	public static double getIVA() {
		return porcIVA;
	}

	public static void setIVA(double porcIVA) {
		Libro.porcIVA = porcIVA;
	}

	
}
