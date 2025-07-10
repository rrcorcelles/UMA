import java.util.HashSet;
import java.util.Set;
import prEjerciciosTema5.*;

public class PruebaIOperacionesColCorr {

	public static void main(String[] args) {
		Set<String> conj = new HashSet<>();
		
		conj.add("hello");
		conj.add("hola");
		conj.add("adios");
		conj.add("bye");
		
		System.out.println(conj);
		System.out.println("La media de las vocales es: " + OperacionesColCorr.mediaVocales(conj));
		OperacionesColCorr.eliminarCadenas(conj, "h");
		System.out.println(conj);
	}


}
