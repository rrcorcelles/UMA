package prNotas;

public class MediaArmonica implements CalculoMedia {

	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		int k=0;
		double media=0;
		
		for (int i=0; i<alumnos.length; i++) {
			if(alumnos[i].getNotas()>0) {
				media += (1/alumnos[i].getNotas()); 
				k++;
			}
		}
		
		media = k/media;
		
		if(k==0) {
			throw new AlumnoException("No hay alumnos para hacer media");
		}
		
		return media;
	}

}
