package prEstructuraDeDatos;

import java.util.Arrays;

public class Cola implements EstructuraDeDatos {
	private static final int TAM=8;
	private int numElem;
	private int[] elementos;
	
	public Cola(int n) {
		elementos = new int[n];
		numElem = 0;
	}
	
	public Cola() {
		this(TAM);
	}
	
	@Override
	public void meter(int i) {
		if(elementos.length==numElem) {
			elementos = Arrays.copyOf(elementos, elementos.length*2);
		}
		elementos[numElem]=i;
		numElem++;
	}

	@Override
	public int sacar() {
		if (estaVacia()) {
			throw new RuntimeException("ERROR: La estructura esta vacia");
		}
		int n = elementos[0];
		for(int i=0; i<=numElem-1; i++) {
			elementos[i]=elementos[i+1];
		}
		numElem--;
		return n;
	}
	

	@Override
	public int tamaño() {
		return numElem;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementos, numElem));
	}
	

}
