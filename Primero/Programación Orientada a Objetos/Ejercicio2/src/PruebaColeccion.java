import prEjercicio2Tema2.Coleccion;

public class PruebaColeccion {

	public static void main(String[] args) {
		Coleccion col = new Coleccion(3);
		
		col.añade(1);
		System.out.println(col);
		col.añade(5);
		System.out.println(col);
		col.añade(2);
		System.out.println(col);
		col.añade(8);
		System.out.println(col);
		col.elimina(2);
		System.out.println(col);
		col.elimina(23);
		System.out.println(col);	
		
		System.out.println("Numero de elementos: " + col.getNumElem());
		col.vacia();
		System.out.println(col);

	}

}
