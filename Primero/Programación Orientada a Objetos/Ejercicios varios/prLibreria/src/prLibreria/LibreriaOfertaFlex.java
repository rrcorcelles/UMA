package prLibreria;

public class LibreriaOfertaFlex extends Libreria{
	OfertaFlex oferta;
	
	public LibreriaOfertaFlex(OfertaFlex o) {
		this(CAP_INICIAL,o);
	}
	
	public LibreriaOfertaFlex(int tam,OfertaFlex o) {
		super(tam);
		oferta = o;
	}

	public OfertaFlex getOferta() {
		return oferta;
	}

	public void setOferta(OfertaFlex oferta) {
		this.oferta = oferta;
	}
	
	public void addLibro(String aut, String tit, double prec) {
		Libro l = new Libro(aut,tit,prec);
		if(oferta.getDescuento(l)!=0) {
			l = new LibroOferta(aut,tit,prec,oferta.getDescuento(l));	
		}
		anyadirLibro(l);
	}

	@Override
	public String toString() {
		return oferta.toString() + "\n" + super.toString();
	}	
	
}
