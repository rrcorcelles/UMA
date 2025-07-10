import prEstructuraDeDatos.*;

public class Prueba {

	public static void main(String[] args) {
		
		EstructuraDeDatos datos;
		
		
	
		//	datos = new Pila();
		
		//	datos = new Cola();
		
	
			datos = new Aleatoria();
		
		
		rellenar(datos);
		System.out.println(datos);
		
		System.out.println("Sacamos un elemento: " + datos.sacar());
		System.out.println(datos);
		
		vaciar(datos);
		System.out.println(datos);
		
	}
	
	
	private static void rellenar(EstructuraDeDatos d) {
		for (int i = 0; i < 10; i++) {
			d.meter(i);
		}
	}

	private static void vaciar(EstructuraDeDatos d) {
		while (!d.estaVacia()) {
			d.sacar();
		}
	}

}
