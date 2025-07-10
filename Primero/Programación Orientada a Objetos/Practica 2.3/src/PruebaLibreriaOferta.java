import prLibreria.LibreriaOferta;

public class PruebaLibreriaOferta {

	public static void main(String[] args) {
		
		LibreriaOferta libreria = 
				new LibreriaOferta(20, new String [] {"George Orwell", "Isaac Asimov"});

		libreria.addLibro("george orwell", "1984", 8.20);
		libreria.addLibro("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?", 3.50);
		libreria.addLibro("Isaac Asimov", "Fundaci�n e Imperio", 9.40);
		libreria.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		libreria.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		libreria.addLibro("Isaac Asimov", "La Fundaci�n", 7.30);
		libreria.addLibro("William Gibson", "Neuromante", 8.30);
		libreria.addLibro("Isaac Asimov", "Segunda Fundaci�n", 8.10);
		libreria.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		libreria.addLibro("George Orwell", "1984", 6.20);
		libreria.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
		
		System.out.println(libreria);
		System.out.println();
		
		libreria.remLibro("George Orwell", "1984");
		libreria.remLibro("Aldous Huxley", "Un Mundo Feliz");
		libreria.remLibro("Isaac Newton", "Arithmetica Universalis");
		libreria.remLibro("James Gosling", "The Java Language Specification");
		
		System.out.println(libreria);
		System.out.println();
		
		System.out.println("PrecioFinal(George Orwell, 1984): " + libreria.getPrecioFinal("George Orwell", "1984"));
		System.out.println("PrecioFinal(Philip K. Dick, �Sue�an los androides con ovejas el�ctricas?): " + libreria.getPrecioFinal("Philip K. Dick", "�Sue�an los androides con ovejas el�ctricas?"));
		System.out.println("PrecioFinal(isaac asimov, fundaci�n e imperio): " + libreria.getPrecioFinal("isaac asimov", "fundaci�n e imperio"));
		System.out.println("PrecioFinal(Ray Bradbury, Fahrenheit 451): " + libreria.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
	    System.out.println("PrecioFinal(Aldous Huxley, Un Mundo Feliz): " + libreria.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"));
	    System.out.println("PrecioFinal(Isaac Asimov, La Fundaci�n): " + libreria.getPrecioFinal("Isaac Asimov", "La Fundaci�n"));
	    System.out.println("PrecioFinal(william gibson, neuromante): " + libreria.getPrecioFinal("william gibson", "neuromante"));
	    System.out.println("PrecioFinal(Isaac Asimov, Segunda Fundaci�n): " + libreria.getPrecioFinal("Isaac Asimov", "Segunda Fundaci�n"));
	    System.out.println("PrecioFinal(Isaac Newton, Arithmetica Universalis): " + libreria.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));

	}

}
