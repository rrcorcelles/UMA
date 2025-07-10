package prLibreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
	private double porcDescuento;
	private String [] autoresOferta;
	
	public OfertaAutor(double p, String [] a) {
		porcDescuento = p;
		autoresOferta = a;
	}
	
	@Override
	public double getDescuento(Libro lib) {
		return (esta(lib.getAutor())) ? porcDescuento : 0;
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
		return porcDescuento + "%" + Arrays.toString(autoresOferta);
	}

}
