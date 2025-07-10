package prEjerciciosTema5;

public class Alumno implements Comparable<Alumno>{
	private String dni;
	private String nombre;
	private double nota;
	
	public Alumno(String d, String nom, double n) throws AlumnoException{
		if (n<0) {
			throw new AlumnoException("La calificacion no puede ser negativa");
		}
		dni=d;
		nombre=nom;
		nota=n;
	}

	@Override
	public int hashCode() {
		return nombre.hashCode() + dni.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean res=false;
		if (obj instanceof Alumno) {
			Alumno p = (Alumno) obj;
			res = p.dni.equalsIgnoreCase(dni) && p.nombre.equalsIgnoreCase(nombre);
		}
		return res;
	}

	@Override
	public String toString() {
		return "(" + dni + ", " + nombre + ", " + nota + ")";
	}

	@Override
	public int compareTo(Alumno o) {
		int i = dni.compareToIgnoreCase(o.dni);
		if (i == 0) {
			i = nombre.compareToIgnoreCase(o.nombre);
		}
		return i;
	}	
}


