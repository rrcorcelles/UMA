package prEjercicio5Tema2;

import java.util.Arrays;

public class Pila implements EstructuraDeDatos {
	private final static int TAM = 10;
	
	private int numElem;
	private int[] elementos;
	
	public Pila(int tam) {
		numElem = 0;
		elementos = new int[tam];
	}
	
	public Pila() {
		this(TAM);
	}
	
	@Override
	public void meter(int elem) {
		if (numElem >= elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*elementos.length);
		}
		elementos[numElem] = elem;
		numElem++;
	}

	@Override
	public int sacar() {
		if (estaVacia()) {
			throw new RuntimeException("No se puede sacar de la Pila, está vacía");
		}
		numElem--;
		return elementos[numElem];
	}

	@Override
	public int tamaño() {
		return numElem;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementos,numElem));
	}

}
