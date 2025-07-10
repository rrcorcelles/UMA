package prEjercicio4Tema2;

import java.util.Arrays;

import prEjercicio2Tema2.Coleccion;

public class ColeccionOrdenada extends Coleccion {
	public ColeccionOrdenada() {
		super();
	}
	
	public ColeccionOrdenada(int tam) {
		super(tam);
	}
		
	@Override
	public void añade(int elem) {
		if (numElem >= elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*elementos.length);
		}
		int destino = buscarDestino(elem);
		for (int i = numElem; i > destino; i--) {
			elementos[i] = elementos[i-1];
		}
		elementos[destino] = elem;
		numElem++;
	}
	
	private int buscarDestino(int elem) {
		int i = 0;
		while ((i < numElem) && (elem > elementos[i])) {
			i++;
		}
		return i;
	}
	
	@Override
	public void elimina(int elem) {
		int pos = buscarPosicion(elem);
		if (pos < numElem) {
			for (int i = pos; i < numElem - 1; i++) {
				elementos[i] = elementos[i+1];
			}
			numElem--;
		}
	}
	
	private int buscarPosicion(int elem) {
		int res;
		int i = 0;
		
		while ((i < numElem) && (elementos[i] < elem)) {
			i++;
		}
		if ((i < numElem) && (elementos[i] == elem)){
			res = i;
		} else {
			res = numElem;
		}
		return res;
	}
	
	@Override
	public boolean contiene(int elem) {
		return (buscarPosicion(elem) < numElem);
	}

}
