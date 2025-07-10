package prLibreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
	private String [] autoresOferta;
	private double porcDescuento;
	
	public LibreriaOferta(double p, String [] a) {
		this(CAP_INICIAL, p, a);
	}
	
	public LibreriaOferta(int tam, double p, String [] a) {
		super(tam);
		porcDescuento = p;
		autoresOferta = a;
	}
	
	public void setOferta(double p, String [] a) {
		porcDescuento = p;
		autoresOferta = a;
	}
	
	public String [] getOferta() {
		return autoresOferta;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	@Override
	public void addLibro(String a, String t, double p) {
		if (esta(a)) {
			anyadirLibro(new LibroOferta(a, t, p, porcDescuento));
		} else {
			anyadirLibro(new Libro(a, t, p));
		}
	}
	
	private boolean esta(String a) {
		int cont = 0;
		
		while (cont < autoresOferta.length && 
				!a.equalsIgnoreCase(autoresOferta[cont])) {
			cont++;
		}
		
		return cont < autoresOferta.length;
	}
	
	@Override
	public String toString() {
		return porcDescuento + "%" + Arrays.toString(autoresOferta) + "\n"
				+ super.toString();
	}
}
