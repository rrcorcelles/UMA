import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import prEjerciciosTema5.Alumno;
import prEjerciciosTema5.AlumnoException;

public class PruebaAlumno {

	public static void main(String[] args) {
		
		/*try {
			Alumno al1 = new Alumno("2234D", "Antonio", 8);
			Alumno al2 = new Alumno("2234d", "Antonio", 7);
			
			System.out.println("Los alumnos creados son:");
			System.out.println(al1);
			System.out.println(al2);
			
			if (al1.equals(al2)) {
				System.out.println("Alumnos Iguales");
			} else {
				System.out.println("Alumnos Distintos");
			}
		} catch (AlumnoException e) {
			System.err.println("ERROR: " + e.getMessage());
		}*/
	try {
		Set<Alumno> conjAlumnos = new TreeSet<>();
		
		conjAlumnos.add(new Alumno ("3245D", "Antonio", 8));
		conjAlumnos.add(new Alumno ("4536X", "Jose", 6));
		conjAlumnos.add(new Alumno ("8342P", "Luis", 4));
		conjAlumnos.add(new Alumno ("4535H", "Pedro", 9));
		
		System.out.println("\nEl conjunto es: "+ conjAlumnos);
		
		}catch(AlumnoException e) {
			System.out.println("ERROR: " + e.getMessage() );
		}
	}

}