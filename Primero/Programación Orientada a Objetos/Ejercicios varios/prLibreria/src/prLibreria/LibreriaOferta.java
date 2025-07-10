package prLibreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
	private double porcDescuento;
	private String[] autoresOferta;
	
	public LibreriaOferta(double desc, String[] aut) {
		this(CAP_INICIAL, desc, aut);
	}
	
	public LibreriaOferta(int n, double desc, String[] aut) {
		super(n);
		porcDescuento = desc;
		autoresOferta = aut;
	}

	public void setPorcDescuento(double porcDescuento, String[] autoresOferta) {
		this.porcDescuento = porcDescuento;
		this.autoresOferta = autoresOferta;
	}
	
	public String[] getOferta() {
		return autoresOferta;
	}

	public double getDescuento() {
		return porcDescuento;
	}
	
	public void addLibro(String aut, String tit, double prec) {
		if(esta(aut)) {
			anyadirLibro (new LibroOferta(aut,tit,prec, porcDescuento));
		}else {
		anyadirLibro(new Libro(aut,tit,prec));
		}
	}
	
	private boolean esta(String aut) {
		int i =0;
		while (i<autoresOferta.length && autoresOferta[i].equalsIgnoreCase(aut)) {
			i++;
		}	
	return i<autoresOferta.length;
	}

	@Override
	public String toString() {
		return porcDescuento + "%" + Arrays.toString(autoresOferta) +"\n" 
				+ super.toString();
	}
	
	
	
	
	
}
