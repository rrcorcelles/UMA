package prLibreria;

public class LibroOferta extends Libro {
	private double porcDescuento;
	
	public LibroOferta(String a, String t, double pbase, double pdes) {
		super(a, t, pbase);
		porcDescuento = pdes;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	private double precioConDescuento() {
		double pb = getPrecioBase();
		return pb - pb * porcDescuento / 100;
	}
	
	@Override
	public double getPrecioFinal() {
		double px = precioConDescuento();
		return px + px * getIVA() / 100;
	}
	
	@Override
	public String toString() {
		return "(" + getAutor() + "; " + getTitulo() + "; " 
				+ getPrecioBase() + "; " + porcDescuento + "%; " 
				+ precioConDescuento() 
				+ "; " + getIVA() + "%; " + getPrecioFinal() + ")";
	}

}
