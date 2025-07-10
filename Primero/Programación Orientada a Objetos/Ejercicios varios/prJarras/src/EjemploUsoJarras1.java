import prJarras.*;
public class EjemploUsoJarras1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jarra j1 = new Jarra(7);
		Jarra j2 = new Jarra(4);
		
		j1.llena();
		System.out.println(j1 + ", " + j2);
		
		j2.llenaDesde(j1);
		System.out.println(j1 + ", " + j2);
		
		j2.vacia();
		System.out.println(j1 + ", " + j2);
		
		j2.llenaDesde(j1);
		System.out.println(j1 + ", " + j2);
	}

}
