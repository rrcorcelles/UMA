package prEjercicio5Tema2;

import java.util.Arrays;
import java.util.Random;

public class Aleatoria implements EstructuraDeDatos {
	private final static int TAM = 10;
	
	private int numElem;
	private int[] elementos;
	
	private Random rnd;
	
	public Aleatoria(int tam) {
		numElem = 0;
		elementos = new int[tam];
		rnd = new Random();
	}
	
	public Aleatoria() {
		this(TAM);
	}
	
	@Override
	public void meter(int elem) {
		if (numElem >= elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*elementos.length);
		}
		// posición aleatoria para meter (entre 0 y numElem)
		// int posMeter = Math.abs(rnd.nextInt()) % (numElem+1);	
		int posMeter = rnd.nextInt(numElem+1);
		
		for (int i = numElem; i > posMeter; i--) {
			elementos[i] = elementos[i-1];
		}
		elementos[posMeter] = elem;
		numElem++;
	}

	@Override
	public int sacar() {
		if (estaVacia()) {
			throw new RuntimeException("No se puede sacar de la Cola, está vacía");
		}
		// posición aleatoria para sacar (entre 0 y numElem-1)
		//int posSacar = Math.abs(rnd.nextInt()) % numElem;
		int posSacar = rnd.nextInt(numElem);
		
		int res = elementos[posSacar];
		
		for (int i = posSacar; i < numElem - 1; i++) {
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
