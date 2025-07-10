import prEjercicio3Tema2.Conjunto;

public class PruebaConjunto {

	public static void main(String[] args) {
		Conjunto con = new Conjunto(3);
		
		con.añade(1);
		System.out.println(con);
		con.añade(5);
		System.out.println(con);
		con.añade(2);
		System.out.println(con);
		con.añade(2);
		System.out.println(con);
		con.añade(8);
		System.out.println(con);
		
		Conjunto con2 = new Conjunto(3);
		
		con2.añade(1);
		System.out.println(con2);
		con2.añade(4);
		System.out.println(con2);
		con2.añade(8);
		System.out.println(con2);
		
		Conjunto un = con.union(con2);
		Conjunto in = con.interseccion(con2);
		System.out.println(un);
		System.out.println(in);
		
			
	}

}
