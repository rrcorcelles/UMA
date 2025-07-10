package prDatos;

import java.util.Arrays;

public class Datos {
	private double[] datos;
	private String[] errores;
	private double min, max;

	public Datos(String[] valores, double min, double max) {
		this.min = min;
		this.max = max;

		datos = new double[valores.length];
		int numDatos = 0;

		errores = new String[valores.length];
		int numErrores = 0;

		for (String valor : valores) {
			
			try {
				datos[numDatos] = Double.parseDouble(valor);
				numDatos++;
			} catch (NumberFormatException e) {
				errores[numErrores] = valor;
				numErrores++;
			}
		}
		
		datos = Arrays.copyOf(datos, numDatos);
		errores = Arrays.copyOf(errores, numErrores);
	}
	
	public double calcMedia() {
		double suma = 0;
		int numDatos = 0;
		
		for (double d : datos) {
			if (min <= d && d <= max) {
				suma += d;
				numDatos++;
			}
		}
		
		if (numDatos == 0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		
		return suma / numDatos;
	}
	
	public double calcDesvTipica() {
		double media = calcMedia();
		
		double suma = 0;
		int numDatos = 0;
		
		for (double d : datos) {
			if (min <= d && d <= max) {
				suma += Math.pow(d-media, 2);
				numDatos++;
			}
		}
		
		return Math.sqrt(suma/numDatos);
	}
	
	public void setRango(String s) {
		try {
			int pos = s.indexOf(";");
			min = Double.parseDouble(s.substring(0, pos));
			max = Double.parseDouble(s.substring(pos+1));
		} catch (Exception e) {
			throw new DatosException("Error en los datos al establecer el Rango");
		}
	}

	public double[] getDatos() {
		return datos;
	}

	public String[] getErrores() {
		return errores;
	}
	
	@Override
	public String toString() {
		String res =  "Min: " + min + ", Max: " + max + ", "
				+ Arrays.toString(datos) + ", "
				+ Arrays.toString(errores) + ", ";
		
		try {
			res += "Media: " + calcMedia() + ", "
					+ "DesvTipica: " + calcDesvTipica();
		} catch (DatosException e) {
			res += "Media: ERROR, DesvTipica: ERROR";
		}
		
		return res;
	}
	
}
