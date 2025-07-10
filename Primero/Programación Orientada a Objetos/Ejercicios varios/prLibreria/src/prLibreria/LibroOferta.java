package prLibreria;

public class LibroOferta extends Libro{
	private double porcDescuento;
	
	public LibroOferta(String aut, String tit, double prec,double porc) {
		super(aut, tit, prec);
		porcDescuento = porc;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	public double getPrecioconDescuento() {
		return getPrecioBase() - getPrecioBase() * getDescuento() /100;
	}
	
	public double getPrecioFinal() {
		
		return getPrecioconDescuento() + getPrecioconDescuento() * getIVA() /100;
	}

	@Override
	public String toString() {
		return "(" + getAutor() + "; " + getTitulo() + "; " + getPrecioBase() + "; " + getIVA() + "%; " + getPrecioconDescuento() + porcDescuento + "%; "+ getPrecioFinal() +")";
	}
	
	
}
