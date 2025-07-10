package prNotas;

public class Alumno {
	private String nombre;
	private String dni;
	private double notas;
	
	public Alumno(String nom, String dni, double n) throws AlumnoException{
		if (n < 0) {
			throw new AlumnoException("La nota no puede ser negativa");
		}
		nombre   = nom;
		this.dni = dni;
		notas    = n;
	}
	
	public Alumno(String nom, String dni) throws AlumnoException{
		this(nom,dni,0);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getNotas() {
		return notas;
	}

	@Override
	public String toString() {
		return nombre + dni ;
	}

	@Override
	public int hashCode() {
		return nombre.hashCode() + dni.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Alumno) {
			Alumno a = (Alumno) obj;
			res = nombre.equals(a.nombre) && dni.equalsIgnoreCase(a.dni);
		}
		return res;
	}
	
	
	
	
}
