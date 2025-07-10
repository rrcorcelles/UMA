package prEstructuraDeDatos;

import java.util.Arrays;

public class Pila implements EstructuraDeDatos {
	private static final int TAM=8;
	private int numElem;
	private int[] elementos;
	
	public Pila(int n) {
		elementos = new int[n];
		numElem = 0;
	}
	
	public Pila() {
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
		int n = elementos[numElem-1];
		numElem--;
		return n;
	}
	
	
	@Override
	public boolean estaVacia() {
		// TODO Auto-generated method stub
		return EstructuraDeDatos.super.estaVacia();
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
