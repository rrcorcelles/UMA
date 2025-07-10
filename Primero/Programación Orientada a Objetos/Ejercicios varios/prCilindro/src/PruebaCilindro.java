import paqCilindro.*;

public class PruebaCilindro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto p = new Punto(3,5);
		Circulo c = new Circulo(p,4);
		Cilindro C = new Cilindro(c,10);
		
		System.out.println("El punto es: " + p);
		System.out.println("El circulo es: " + c);
		System.out.println("El cilindro es: " + C);
	}

}
