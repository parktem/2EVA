package ejercicio01;

public class Silla {
	private String color;
	private int numPatas;
	private boolean respaldo;
	private double peso;
	private double altura;

	/*
	 * Esta funci�n es excepcional, no devuelve nada, ni siquiera void. Es un m�todo
	 * constructor, se llama igual que la clase Este metodo construir�, como su
	 * nombre indica, pero la terminolog�a correcta es INSTANCIAR. Asignar los
	 * valores a los atributos
	 */
	public Silla(String c, int np, boolean rm, double p, double a) {
		color = c;
		numPatas = np;
		respaldo = rm;
		peso = p;
		altura = a;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String c) {
		color = c;
	}

	public int getnumPatas() {
		return numPatas;
	}

	public void setnumPatas(int np) {
		numPatas = np;
	}

	public boolean getRespaldo() {
		return respaldo;
	}

	public void setRespaldo(boolean rm) {
		respaldo = rm;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double p) {
		peso = p;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double a) {
		altura = a;
	}

	// Esto es para mostrar todos los atributos
	public void mostrar() {
		if (respaldo)
			System.out.printf(
					"Esta silla es %s, tiene %d patas, respaldo, pesa %.2f gramos, y mide %.2f centimetros \n", color,
					numPatas, peso, altura);
		else
			System.out.printf(
					"Esta silla es %s, tiene %d patas, sin respaldo, pesa %.2f gramos, y mide %.2f centimetros\n",
					color, numPatas, peso, altura);
	}
}
