package prEjercicio1Tema2;

public class NumeroRacional {
	private int numerador;
	private int denominador;

	public NumeroRacional() {
		numerador = 0;
		denominador = 1;
	}

	private int mcd(int a, int b) {
		int res;
		if (a == b) {
			res = a;
		} else if (a > b) {
			res = mcd(a - b, b);
		} else {
			res = mcd(a, b - a);
		}
		return res;
	}

	private void reducir(NumeroRacional nr) {
		if (nr.numerador != 0) {
			int num = Math.abs(nr.numerador);
			int den = Math.abs(nr.denominador);
			int mcd = mcd(num, den);
			nr.numerador = nr.numerador / mcd;
			nr.denominador = nr.denominador / mcd;
			if (nr.denominador < 0) {
				nr.numerador *= -1;
				nr.denominador *= -1;
			}
		}
	}

	public NumeroRacional(int num, int den) {
		if (den == 0) {
			throw new RuntimeException("ERROR: el denominador de una fracción no puede ser 0");
		}
		numerador = num;
		denominador = den;
		reducir(this);
	}

	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	private int mcm(int a, int b) {
		return (a * b) / (mcd(a, b));
	}

	public NumeroRacional suma(NumeroRacional nr) {
		int mcm = mcm(this.denominador, nr.denominador);

		return new NumeroRacional((mcm / this.denominador) * this.numerador + (mcm / nr.denominador) * nr.numerador,
				mcm);
	}

	public NumeroRacional resta(NumeroRacional nr) {
		int mcm = mcm(this.denominador, nr.denominador);

		return new NumeroRacional((mcm / this.denominador) * this.numerador - (mcm / nr.denominador) * nr.numerador,
				mcm);
	}

	public NumeroRacional mult(NumeroRacional nr) {

		return new NumeroRacional(this.numerador * nr.numerador, this.denominador * nr.denominador);
	}

	public NumeroRacional div(NumeroRacional nr) {

		return new NumeroRacional(this.numerador * nr.denominador, this.denominador * nr.numerador);
	}

	@Override
	public String toString() {
		String res;
		if (denominador == 1) {
			res = Integer.toString(numerador);
		} else {
			res = numerador + "/" + denominador;
		}
		return res;
	}
}
