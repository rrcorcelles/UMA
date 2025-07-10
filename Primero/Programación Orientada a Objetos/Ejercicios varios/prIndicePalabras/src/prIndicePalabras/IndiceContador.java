package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public class IndiceContador extends IndiceAbstracto{
	private SortedMap<String,Integer> indice;
	
	public IndiceContador() {
		indice = new TreeMap<>();
	}

	@Override
	public void resolver(String s) {
		indice.clear();
		for (String p : frases) {
			tratarPalabra(p,s);
		}
	}
	
	private void tratarPalabra(String frase, String del) {
		try(Scanner sc = new Scanner(frase)){
			sc.useDelimiter(del);
			while(sc.hasNext()) {
				tratarPalabra(sc.next().toLowerCase());
			}
		}
	}
	
	private void tratarPalabra(String d) {
		int freq = indice.getOrDefault(d, 0);
		indice.put(d, freq+1);		
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		for(String s : indice.keySet()) {
		pw.println(s+ "\t " + indice.get(s));
		}
	}
	
	
}
