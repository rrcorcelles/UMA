package prEjercicio2Tema2;

import java.util.Arrays;

public class Coleccion {
	private final static int TAM = 10;
	
	private int numElem;
	private int [] elementos;
	
	public Coleccion(int tam) {
		if (tam <= 0) {
			throw new RuntimeException("ERROR: El tamaño del almacen para la colección tiene que ser positivo");
		}
		numElem = 0;
		elementos = new int[tam];
	}
	
	public Coleccion() {
		this(TAM);
	}
	
	public int getNumElem() {
		return numElem;
	}
	
	public int getElem(int i) {
		if (i < 0 || i >= numElem) {
			throw new RuntimeException("ERROR: Posición incorrecta: " + i);
		}
		return elementos[i];
	}
	
	public boolean sinElementos() {
		return numElem == 0;
	}
	
	public void vacia() {
		numElem = 0;
	}
	
	public void añade(int elem) {
		if (numElem >= elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*elementos.length);
		}
		elementos[numElem] = elem;
		numElem++;
	}
	
	private int buscarPosicion(int elem) {
		int i = 0;
		while ((i < numElem) && (elementos[i] != elem)) {
			i++;
		}
		return i;
	}
	
	public void elimina(int elem) {
		int pos = buscarPosicion(elem);
		if (pos < numElem) {
			elementos[pos] = elementos[numElem-1];
			numElem--;
		}
	}
	
	public boolean contiene(int elem) {
		return (buscarPosicion(elem) < numElem);
	}
	
/*
 	@Override
	public String toString() {
		String res = "[";
		if (numElem == 0) {
			res += "]";
		} else { 
			for (int i = 0; i < numElem-1; i++) {
				res = res + elementos[i] + ", "; 
			}
			res += elementos[numElem-1] + "]";
		}
		return res;
	}
*/
	
	// usando CopyOf y Arrays.toString
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementos, numElem));
	}
}
