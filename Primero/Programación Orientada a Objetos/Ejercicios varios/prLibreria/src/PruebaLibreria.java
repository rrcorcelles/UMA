import prLibreria.*;

public class PruebaLibreria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libreria l = new Libreria();
		l.addLibro("george orwell", "1984", 8.20);
		l.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
		l.addLibro("Isaac Asimov" , "Fundación e Imperio", 9.40);
		l.addLibro("Ray Bradbury" ,  "Fahrenheit 451", 7.40);
		l.addLibro("Aldous Huxley" ,  "Un Mundo Feliz", 6.50);
		l.addLibro("Isaac Asimov" , "La Fundación", 7.30);
		l.addLibro("William Gibson" , "Neuromante", 8.30);
		l.addLibro("Isaac Asimov" , "Segunda Fundación", 8.10);
		l.addLibro("Isaac Newton" , "arithmetica universalis", 7.50);
		l.addLibro("George Orwell" , "1984", 6.20);
		l.addLibro("Isaac Newton" , "arithmetica universalis", 10.50);
		
		//System.out.println(l);
		
		l.remLibro("George Orwell", "1984");
		l.remLibro("Aldous Huxley" ,  "Un Mundo Feliz");
		l.remLibro("Isaac Newton" , "arithmetica universalis");
		l.remLibro("James Gosling", "The Java Language Specification");
		
		System.out.println(l);
	}

}
