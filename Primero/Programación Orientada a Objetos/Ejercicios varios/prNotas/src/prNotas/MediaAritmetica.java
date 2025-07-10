package prNotas;

public class MediaAritmetica implements CalculoMedia {

	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		if (alumnos.length==0) {
			throw new AlumnoException("No hay alumnos para caluclar media");
		}
		
		double media=0;
		for (int i=0; i<alumnos.length; i++) {
			media += alumnos[i].getNotas();
		}
		media /= alumnos.length;
		return media;
	}

}
