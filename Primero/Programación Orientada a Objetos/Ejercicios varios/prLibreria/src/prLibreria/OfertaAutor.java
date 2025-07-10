package prLibreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
	
	private double porcDescuento;
	private String[] autoresOferta;
		
	public OfertaAutor(double porcDescuento, String[] autoresOferta) {
		this.porcDescuento = porcDescuento;
		this.autoresOferta = autoresOferta;
	}
	
	@Override
	public double getDescuento(Libro l) {
		double n=0;
		if (esta(l.getAutor())) {
			n=porcDescuento;
		}
		return n;
	}
	
	private boolean esta(String aut) {
		int cont = 0;
		while(cont<=autoresOferta.length && autoresOferta[cont].equalsIgnoreCase(aut)) {
			cont++;
		}
		return cont <= autoresOferta.length;
	}
	
	@Override
	public String toString() {
		return porcDescuento + "[" + Arrays.toString(autoresOferta)
				+ "]";
	}
	
}
