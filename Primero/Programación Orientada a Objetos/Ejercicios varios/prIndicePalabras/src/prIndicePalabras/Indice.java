package prIndicePalabras;

import java.io.PrintWriter;

public interface Indice {
	void agregarFrase(String s);
	void resolver (String s);
	void presentarIndiceConsola();
	void presentarIndice(PrintWriter pw);
}
