package prLibreria;

public class LibreriaOfertaFlex extends Libreria {
	OfertaFlex oferta;
	
	public LibreriaOfertaFlex(OfertaFlex of) {
		this(CAP_INICIAL,of);
	}
	
	public LibreriaOfertaFlex(int tam, OfertaFlex of) {
		super(tam);
		oferta = of;
	}
	
	public void setOferta(OfertaFlex of) {
		oferta = of;
	}
	
	public OfertaFlex getOferta() {
		return oferta;
	}
	
	@Override
	public void addLibro(String a, String t, double p) {
		Libro lib = new Libro(a, t, p);
		double pDesc = oferta.getDescuento(lib);
		if (pDesc != 0) {
			lib = new LibroOferta(a, t, p, pDesc);
		}
		anyadirLibro(lib);
	}
	
	@Override
	public String toString() {
		return oferta.toString() + "\n"	+ super.toString();
	}
}
