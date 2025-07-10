package prLibreria;

public class OfertaPrecio implements OfertaFlex {
	double porcDescuento;
	double umbralPrecio;
	
	public OfertaPrecio(double p, double u) {
		porcDescuento = p;
		umbralPrecio = u;
	}
	
	@Override
	public double getDescuento(Libro lib) {
		return (lib.getPrecioBase() >= umbralPrecio) ? porcDescuento : 0;
	}
	
	@Override
	public String toString() {
		return porcDescuento + "%(" + umbralPrecio + ")";
	}

}
