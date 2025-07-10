package prEstructuraDeDatos;

public interface EstructuraDeDatos {
	void meter(int i);
	int sacar();
	default boolean estaVacia() {
		return tamaño() == 0;
	}
	int tamaño();
}
