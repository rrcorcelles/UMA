import prJarras.Mesa;

public class EjemploUsoMesa1 {

	public static void main(String[] args) {
		
			Mesa mesa = new Mesa(7,5);
			
			mesa.llena(1);
			System.out.println(mesa);
			mesa.llenaDesde(1);
			System.out.println(mesa);
			mesa.llena(1);
			System.out.println(mesa);
			mesa.llenaDesde(1);
			System.out.println(mesa);
			mesa.vacia(2);
			System.out.println(mesa);
			mesa.llenaDesde(1);
			System.out.println(mesa);
			mesa.llena(1);
			System.out.println(mesa);
			mesa.llenaDesde(1);
			System.out.println(mesa);
	}

}
