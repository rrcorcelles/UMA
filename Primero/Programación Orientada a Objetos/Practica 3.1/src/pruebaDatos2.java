import java.util.Arrays;

import prDatos2.Datos;
import prDatos2.DatosException;

public class pruebaDatos2 {
	public static void main(String[] args) {
		
		try {
			double min = Double.parseDouble(args[0]);
			double max = Double.parseDouble(args[1]);
			Datos datos = 
				new Datos(Arrays.copyOfRange(args,2,args.length),
						min,max);
			
			System.out.println(datos);
			
			datos.setRango("0;4");
			
			System.out.println(datos);
			
			datos.setRango("15 25");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error, no hay valores suficientes");
		} catch (NumberFormatException e) {
			System.err.println("Error, al convertir un valor a número real ("
					+ e.getMessage() + ")");
		} catch (DatosException e) {
			System.err.println(e.getMessage());
		}

	}
}
