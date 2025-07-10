import prEjercicio4Tema2.ColeccionOrdenada;

public class PruebaColeccionOrdenada {
	
	public static void main(String[] args) {

		ColeccionOrdenada col = new ColeccionOrdenada(3);
		
		col.añade(1);
		System.out.println(col);
		col.añade(5);
		System.out.println(col);
		col.añade(2);
		System.out.println(col);
		col.añade(4);
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
