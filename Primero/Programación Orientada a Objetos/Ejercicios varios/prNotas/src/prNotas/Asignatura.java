package prNotas;

import java.util.Arrays;
import java.util.StringJoiner;

public class Asignatura {
	private String nombre;
	private Alumno[] alumnos;
	private String[] errores;
	
	public Asignatura(String nombre, String[] alum) {
		this.nombre = nombre;
		int numAlumnos = 0;
		int numErrores = 0;
		Alumno[] alumnosTmp = new Alumno[alum.length];
		String[] errorTmp = new String[alum.length];
		
		
		for (int i=0; i<alum.length; i++) {
			String[] datos = alum[i].split("[;]");
			
		try {
			alumnosTmp[numAlumnos] = new Alumno(datos[0], datos[1], Double.parseDouble(datos[2]));
			numAlumnos++;
		}catch(NumberFormatException e) {
			errorTmp[numErrores] = new String("Error: Calificación no numérica: "+alum);
			numErrores++;
		}catch(ArrayIndexOutOfBoundsException e) {
			errorTmp[numErrores] = new String("Error: Faltan datos: "+alum);
			numErrores++;
		}catch(AlumnoException e) {
			errorTmp[numErrores] = new String("Error: Calificación negativa: "+alum);
			numErrores++;
		}
		}
		
		this.alumnos = Arrays.copyOf(alumnosTmp, numAlumnos);
		this.errores = Arrays.copyOf(errorTmp, numErrores);
	}
	
	public double getCalificacion(Alumno al) throws AlumnoException {
		int i = 0;
		double res = 0;
		boolean salir = false;
		
		while(i<alumnos.length && !salir) {
			if(alumnos[i].equals(al)) {
				res = alumnos[i].getNotas();
				salir = true;
			}
			i++;
		}
		if (!salir) {
			throw new AlumnoException("El alumno "+ al +" no se encuentra");
		}
		return res;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public String[] getErrores() {
		return errores;
	}
	
	public double getMedia() throws AlumnoException{
		double res=0;
		if(alumnos.length == 0) {
			throw new AlumnoException("No hay alumnos para calcular la media");
		}else {
		for (int i = 0; i < alumnos.length; i++) {
			res += alumnos[i].getNotas();
		}
		res /= alumnos.length;
		}
		return res;
	}
	
	public double getMedia(CalculoMedia media)throws AlumnoException{
		return media.calcular(alumnos);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder(this.nombre + ": {");
		
		StringJoiner sjAlumnos = new StringJoiner(",", "[", "]");
		
		for (int i = 0; i<alumnos.length; i++) {
			sjAlumnos.add(alumnos[i].toString());
		}
		
		res.append(sjAlumnos +"}");
		res.append(Arrays.toString(errores));
		
		return res.toString();
	}
	
	
	
	
	
}
