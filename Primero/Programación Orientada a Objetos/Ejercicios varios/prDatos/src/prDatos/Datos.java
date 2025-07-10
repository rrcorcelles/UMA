package prDatos;

import java.util.Arrays;

public class Datos {
	private double[] datos;
	private String[] errores;
	private double min, max;
	
	public Datos(String[] datos, double min, double max) {
		this.min=min;
		this.max=max;
		
		int numOk = 0;
		int numError = 0;
		
		double valor;
		double datosTemp[] = new double[datos.length];
		String errorTemp[] = new String[datos.length];
		
		for (int i =0; i<=datos.length; i++) {
			try {
				valor = Double.parseDouble(datos[i]);
				datosTemp[numOk] = valor;
				numOk++;
			}catch(NumberFormatException e) {
				errorTemp[numError] = datos[i];
				numError++;
			}
		}
		
		this.datos = Arrays.copyOf(datosTemp, numOk);
		this.errores = Arrays.copyOf(errorTemp, numError);
	}
	
	public double calcMedia() {
		int cont=0;
		double suma=0;
		for (int i=0; i<=datos.length;i++) {
			if(datos[i]<max && datos[i]>min) {
				suma += datos[i];
				cont++;
			}
		}
		if(cont == 0) {
			throw new DatosException("Error no hay valores correctos");
		}
		return suma/cont;
	}
	
	public double calcDesvTipica() {
		int cont=0;
		double suma=0;
		for (int i=0; i<=datos.length;i++) {
			if(datos[i]<max && datos[i]>min) {
				suma += Math.pow((datos[i] - calcMedia()),2);
				cont++;
			}
		}
		if(cont == 0) {
			throw new DatosException("Error no hay valores correctos");
		}
		return Math.sqrt(suma/cont);
	}
	
	public void setRango(String s) {
		int posSeparador= s.indexOf(";");
		double min, max;
		
		min = Double.parseDouble(s.substring(0, posSeparador));
		max = Double.parseDouble(s.substring(posSeparador +1, s.length()));
		this.min=min;
		this.max=max;
	}

	public double[] getDatos() {
		return datos;
	}

	public String[] getErrores() {
		return errores;
	}

	@Override
	public String toString() {
		return "Min: " + min + ", Max: " + max + ", " + Arrays.toString(datos) + ", " + 
				Arrays.toString(errores) + ", Media: " + calcMedia() + ", DesvTipica: " + calcDesvTipica();
	}
}


	


