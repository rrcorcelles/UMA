import prEjercicio1Tema2.NumeroRacional;

public class PruebaRacionales {

	public static void main(String[] args) {

		NumeroRacional nr1 = new NumeroRacional(2,3);
		NumeroRacional nr2 = new NumeroRacional(1,2);
		NumeroRacional mult = nr1.mult(nr2);
		
		System.out.println(mult);
		NumeroRacional div = nr1.div(nr2);
		System.out.println(div);
		NumeroRacional sum = nr1.suma(nr2);
		System.out.println(sum);
		NumeroRacional res = nr1.resta(nr2);
		System.out.println(res);
		
	}

}
