package prEjerciciosTema5;

import java.util.Iterator;
import java.util.Set;

public class OperacionesColCorr {
	
	public static double mediaVocales(Set<String> conj ) {
		double media =0;
		int numCadenas = conj.size();
		
		if(numCadenas !=0) {
			int suma=0;
			for(String s : conj) {
				suma += cuentaVocales(s);
			}
			media = suma/conj.size();
		}
		return media;
	}
	
	private static int cuentaVocales(String s) {
		int suma=0;
		for (int i=0; i<s.length(); i++) {
			if(esVocal(s.charAt(i))){
				suma++;
			}	
		}
		return suma;
	}
	
	private static boolean esVocal(char a) {
		return a=='a' || a=='e' || a=='i' || a=='o' || a=='u';
	}
	
	
	public static void eliminarCadenas(Set<String> conjCad, String s) {
		Iterator<String> iter = conjCad.iterator();
		
		while(iter.hasNext()) {
			if(iter.next().startsWith(s)) {
				iter.remove();
			}
		}
	}
}
