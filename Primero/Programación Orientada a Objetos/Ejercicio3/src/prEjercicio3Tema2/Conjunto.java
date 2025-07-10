package prEjercicio3Tema2;

import prEjercicio2Tema2.Coleccion;

public class Conjunto extends Coleccion {
	public Conjunto() {
		super();
	}
	
	public Conjunto(int tam) {
		super(tam);
	}
	
	@Override
	public void a�ade(int elem) {
		if (!contiene(elem)) {
			super.a�ade(elem);
		}
	}
	
	public Conjunto union(Conjunto c) {
		Conjunto res = new Conjunto();
		
		meter(this,res);
		meter(c,res);
				
		return res;
	}
	
	private void meter(Conjunto origen, Conjunto destino) {
		for (int i = 0; i < origen.getNumElem(); i++) {
			destino.a�ade(origen.getElem(i));
		}
	}
	
	public Conjunto interseccion(Conjunto c) {
		Conjunto res = new Conjunto();
		int elem;
		
		for (int i = 0; i < this.getNumElem(); i++) {
			elem = this.getElem(i);
			if (c.contiene(elem)) {
				res.a�ade(elem);
			}
		}
				
		return res;
	}
	
	
}
