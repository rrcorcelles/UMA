import prEjercicio3Tema2.Conjunto;

public class PruebaConjunto {

	public static void main(String[] args) {
		Conjunto con = new Conjunto(3);
		
		con.a�ade(1);
		System.out.println(con);
		con.a�ade(5);
		System.out.println(con);
		con.a�ade(2);
		System.out.println(con);
		con.a�ade(2);
		System.out.println(con);
		con.a�ade(8);
		System.out.println(con);
		
		Conjunto con2 = new Conjunto(3);
		
		con2.a�ade(1);
		System.out.println(con2);
		con2.a�ade(4);
		System.out.println(con2);
		con2.a�ade(8);
		System.out.println(con2);
		
		Conjunto un = con.union(con2);
		Conjunto in = con.interseccion(con2);
		System.out.println(un);
		System.out.println(in);
		
			
	}

}
