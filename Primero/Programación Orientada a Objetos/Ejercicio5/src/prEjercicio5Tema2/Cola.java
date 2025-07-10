package prEjercicio5Tema2;

import java.util.Arrays;

public class Cola implements EstructuraDeDatos {
	private final static int TAM = 10;
	
	private int numElem;
	private int[] elementos;
	
	public Cola(int tam) {
		numElem = 0;
		elementos = new int[tam];
	}
	
	public Cola() {
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
			throw new RuntimeException("No se puede sacar de la Cola, está vacía");
		}
		
		int res = elementos[0];
		for (int i = 0; i < numElem - 1; i++) {
			elementos[i] = elementos[i+1];
		}
		numElem--;
		
		return res;
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
