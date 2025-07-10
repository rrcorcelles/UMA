package prNotas;

public class MediaSinExtremos implements CalculoMedia {
	private double min;
	private double max;
	
	public MediaSinExtremos(double min, double max) {
		this.min=min;
		this.max=max;
	}
	@Override
	public double calcular(Alumno[] alumnos) throws AlumnoException {
		int k = alumnos.length;
		double media = 0;
		for (int i =0; i<alumnos.length; i++) {
			if(alumnos[i].getNotas()<=max && alumnos[i].getNotas()>=min) {
				media +=alumnos[i].getNotas();
				k++;
			}
		}
		
		if(k==0) {
			throw new AlumnoException("No hay alumnos para calcular su media sin extremos");
		}
		media /= k;
		return media;
	}
	
	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}
	

}
