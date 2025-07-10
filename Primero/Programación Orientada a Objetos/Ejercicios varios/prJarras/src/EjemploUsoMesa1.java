import prJarras.*;
public class EjemploUsoMesa1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mesa m = new Mesa(7,5);
		m.llena(2);
		System.out.println(m);
		
		m.llenaDesde(2);
		System.out.println(m);
		
		m.llena(2);
		System.out.println(m);
		
		m.llenaDesde(2);
		System.out.println(m);
		
		m.vacia(1);
		System.out.println(m);
		
		m.llenaDesde(2);
		System.out.println(m);
		
		m.llena(2);
		System.out.println(m);
		
		m.llenaDesde(2);
		System.out.println(m);
		
	}

}
