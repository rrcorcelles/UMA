package prCuentaPalabrasSimpleColecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class ContadorDePalabras {
	private SortedSet<PalabraEnTexto> palabras;
	
	public ContadorDePalabras() {
		palabras = new TreeSet<>();
	}
	
	protected void incluye (String pal) {
		PalabraEnTexto p = new PalabraEnTexto(pal);
		boolean encontrada = false;
		
		Iterator<PalabraEnTexto> iter = palabras.iterator();
		
		while(iter.hasNext() && !encontrada) {
			if (iter.next().equals(pal)) {
				p.incrementar();
				encontrada = true;
			}
			if(!encontrada) {
				palabras.add(p);
			}
		}
	}
	
	private void incluyeTodas (String linea, String del) {
		try (Scanner sc = new Scanner(linea)) {
		sc.useDelimiter(del);
		while (sc.hasNext()) {
			incluye(sc.next());
		}
		}
	}
	
	public void incluyeTodas(String[] texto, String del) {
		for(String x : texto) {
			incluyeTodas(x,del);
		}
	}
	
	public void incluyeTodasFichero (String nomFich, String del) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(nomFich))) {
			leerFicheros(sc,del);
		}
	}
	
	private void leerFicheros (Scanner sc, String del) {
		while(sc.hasNextLine()) {
			incluyeTodas(sc.nextLine(),del);
		}
	}
	
	public PalabraEnTexto encuentra (String pal) {
		PalabraEnTexto resultado = null, p =new PalabraEnTexto(pal);
		Iterator<PalabraEnTexto> iter = palabras.iterator();
		
		while (iter.hasNext()) {
			if(iter.next().equals(p)) {
				resultado = p;
			}
		}
		if (resultado == null) {
			throw new NoSuchElementException("No existe la palabra " + pal);
		}
		return resultado;
	}

	@Override
	public String toString() {
		return palabras.toString();
	}
	
	public void presentaPalabras(String fichero) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(fichero)){
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw) {
		for (PalabraEnTexto p : palabras) {
			pw.println(p);
		}
	}
	
	
}
