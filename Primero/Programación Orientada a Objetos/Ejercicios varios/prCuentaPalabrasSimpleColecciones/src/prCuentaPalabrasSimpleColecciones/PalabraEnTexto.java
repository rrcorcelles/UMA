package prCuentaPalabrasSimpleColecciones;

public class PalabraEnTexto implements Comparable<PalabraEnTexto>{
	private String palabras;
	private int nVeces;
	
	public PalabraEnTexto(String s) {
		palabras = s.toUpperCase();
		nVeces = 1;
	}
	
	public void incrementar() {
		nVeces++;
	}

	@Override
	public int hashCode() {
		return palabras.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof PalabraEnTexto) {
			PalabraEnTexto p = (PalabraEnTexto) obj;
			res = palabras.equals(p.palabras);
		}
		return res;
	}

	@Override
	public int compareTo(PalabraEnTexto o) {
		return palabras.compareTo(o.palabras);
	}

	@Override
	public String toString() {
		return palabras + ": " + nVeces;
	}
	
	
	
	
}
