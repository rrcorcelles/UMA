package prIndicePalabras;

import java.io.*;
import java.util.*;

public class IndiceAbstracto implements Indice {
	protected List<String> frases;
	
	public IndiceAbstracto() {
		frases = new ArrayList<>();
	}
	@Override
	public void agregarFrase(String s) {
		frases.add(s);
	}

	@Override
	public void presentarIndiceConsola() {
		PrintWriter pw = new PrintWriter(System.out,true);
		presentarIndice(pw);
	}
	
	@Override
	public abstract void resolver(String s);

	@Override
	public abstract void presentarIndice(PrintWriter pw);


}
