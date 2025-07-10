package prEjercicio5Tema2;

public interface EstructuraDeDatos {
	void meter(int elem);
	int sacar();
	default boolean estaVacia() {
		return tamaño() == 0;
	}
	int tamaño();
}
