package prEjercicio5Tema2;

public interface EstructuraDeDatos {
	void meter(int elem);
	int sacar();
	default boolean estaVacia() {
		return tama�o() == 0;
	}
	int tama�o();
}
