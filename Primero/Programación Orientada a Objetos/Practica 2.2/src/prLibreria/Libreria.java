package prLibreria;

import java.util.Arrays;

public class Libreria {
	private static final int CAP_INICIAL = 8;
	private int numLibs;
	private Libro [] libs;
	
	public Libreria() {
		this(CAP_INICIAL);
	}

	public Libreria(int cap) {
		numLibs = 0;
		libs = new Libro[cap];
	}
	
	public void addLibro(String a, String t, double p) {
		anyadirLibro(new Libro(a, t, p));
	}
	
	public void remLibro(String a, String t) {
		int pos = buscarLibro(a,t);
		if (pos != -1) {
			eliminarLibro(pos);
		}
	}
	
	public double getPrecioBase(String a, String t) {
		int pos = buscarLibro(a, t);
		return (pos == -1) ? 0 : libs[pos].getPrecioBase();
	}

	public double getPrecioFinal(String a, String t) {
		int pos = buscarLibro(a, t);
		return (pos == -1) ? 0 : libs[pos].getPrecioFinal();
	}
	
/*	
 	// Con esta implementación de toString() no hay saltos de línea
 	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(libs, numLibs));
	}
*/
	
	// Con esta implementación de toString() hay saltos de línea
	@Override
	public String toString() {
		String res = "[";
		
		if (numLibs == 0) {
			res += "]";
		} else { 
			for (int i = 0; i < numLibs-1; i++) {
				res = res + libs[i] + ",\n"; 
			}
			res += libs[numLibs-1] + "]";
		}
		
		return res;
	}

	private void anyadirLibro(Libro libro) {
		int pos = buscarLibro(libro.getAutor(),libro.getTitulo());
		if (pos != -1) {
			libs[pos] = libro;
		} else {
			if (numLibs == libs.length) {
				libs = Arrays.copyOf(libs, 2*libs.length);
			}
			libs[numLibs] = libro;
			numLibs++;
		}
		
	}
	
	private void eliminarLibro(int pos) {
		libs[pos] = libs[numLibs-1];
		numLibs--;
		
	}

	private int buscarLibro(String a, String t) {
		int res = -1;
		int cont = 0;
		
		while (cont < numLibs && res == -1) {
			if (libs[cont].getAutor().equalsIgnoreCase(a) 
				&& libs[cont].getTitulo().equalsIgnoreCase(t)) {
				res = cont;
			} else {
				cont++;
			}
		}
		
		return res;
		
	}
	
}
