package ejercicio03;

abstract class animal {
	int ID;
	private double peso;
	String fnac;

	public animal(int ID, double p, String f) {
		this.ID = ID;
		peso = p;
		fnac = f;
	}

	abstract void habla(); // Metodo abstracto crea una obligaci�n de implementar el m�todo en las
							// subclases

	public double getPeso() {
		return peso;
	}

	public void setPeso(double p) {
		peso = p;
	}

}
