package prEstructuraDeDatos;

public interface EstructuraDeDatos {
	void meter(int i);
	int sacar();
	default boolean estaVacia() {
		return tama�o() == 0;
	}
	int tama�o();
}
