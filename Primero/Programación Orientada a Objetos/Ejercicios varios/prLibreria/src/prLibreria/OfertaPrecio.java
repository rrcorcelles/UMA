package prLibreria;

public class OfertaPrecio implements OfertaFlex {
	private double porcDescuento;
	private double umbralPrecio;
	
	
	public OfertaPrecio(double porcDescuento, double umbralPrecio) {
		this.porcDescuento = porcDescuento;
		this.umbralPrecio = umbralPrecio;
	}

	@Override
	public double getDescuento(Libro l) {
		double n = 0;
		if(l.getPrecioBase()>= umbralPrecio) {
			n=porcDescuento;
		}
		return n;
	}

	@Override
	public String toString() {
		return + porcDescuento + "%(" + umbralPrecio + ")";
	}
	
	
	

}
