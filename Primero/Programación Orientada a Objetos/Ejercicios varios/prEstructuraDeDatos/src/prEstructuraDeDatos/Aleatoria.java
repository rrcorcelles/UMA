package prEstructuraDeDatos;

import java.util.*;


public class Aleatoria implements EstructuraDeDatos {
	private static final int TAM=8;
	private int numElem;
	private int[] elementos;
	private Random rnd;
	
	public Aleatoria(int n) {
		elementos = new int[n];
		numElem = 0;
		rnd = new Random();
	}
	
	public Aleatoria() {
		this(TAM);
	}
	
	@Override
	public void meter(int i) {
		if(elementos.length==numElem) {
			elementos = Arrays.copyOf(elementos, elementos.length*2);
		}
		int posMeter = rnd.nextInt(numElem+1);
		for(int cont=numElem; cont>posMeter;cont--) {
			elementos[cont]=elementos[cont-1];
		}
		elementos[posMeter]=i;
		numElem++;
	}

	@Override
	public int sacar() {
		if (estaVacia()) {
			throw new RuntimeException("ERROR: La estructura esta vacia");
		}
		int sacar = rnd.nextInt(numElem);
		int n = elementos[sacar];
		for(int i=sacar; i<numElem-1; i++) {
			elementos[i]= elementos[i+1];
		}
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
