package prLibreria;

import java.util.Arrays;

public class Libreria {
	
	protected static final int CAP_INICIAL = 8;
	private int numLibs;
	private Libro[] libros;
	
	public Libreria() {
		this(CAP_INICIAL);
	}
	
	public Libreria(int n) {
		libros = new Libro[n];
		numLibs = 0;
	}
	
	public void addLibro(String aut, String tit, double prec) {
		anyadirLibro(new Libro(aut,tit,prec));
	}
	
	public void remLibro(String aut, String tit) {
		int pos = buscarLibro(aut,tit);
		if (pos!=-1) {
		eliminarLibro(pos);
		}
	}
	
	public double getPrecioBase(String aut, String tit) {
		double p=0;
		int pos = buscarLibro(aut,tit);
		if(pos != -1) {
			p = libros[pos].getPrecioBase();
		}
		return p;
	}
	

	public double getPrecioFinal(String aut, String tit) {
		double p=0;
		int pos = buscarLibro(aut,tit);
		if(pos != -1) {
			p = libros[pos].getPrecioFinal();
		}
		return p;
	}
	
	
	
	@Override
	public String toString() {
		String res = "[";
		
		if (numLibs == 0) {
			res += "]";
		} else { 
			for (int i = 0; i < numLibs-1; i++) {
				res = res + libros[i] + ",\n"; 
			}
			res += libros[numLibs-1] + "]";
		}
		
		return res;
	}

	protected void anyadirLibro(Libro lib) {
			int pos = buscarLibro(lib.getAutor(),lib.getTitulo());
			if(pos != -1) {
				libros[pos]=lib;
			}else {
				if (numLibs == libros.length) {
					libros = Arrays.copyOf(libros, libros.length*2);
				}
				libros[numLibs] = lib;
				numLibs++;
			}
	}
	
	private void eliminarLibro(int n) {
			libros[n] = libros[numLibs-1];
			numLibs--;
	}
	
	private int buscarLibro(String autor, String titulo) {
		int i = 0, pos = -1;
		while ((i < numLibs) && (pos == -1)) {
			if (libros[i].getAutor().equalsIgnoreCase(autor) 
					&& libros[i].getTitulo().equalsIgnoreCase(titulo)) {
				pos = i;
			}else {
			i++;
			}
		}
		return pos;	
	}
}