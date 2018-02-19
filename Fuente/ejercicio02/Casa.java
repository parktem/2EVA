package ejercicio02;

public class Casa {
	String direccion;
	int codPostal;
	int numMetros;
	boolean garaje;

	public Casa(String direccion, int c, int n, boolean g) {
		this.direccion = direccion;
		codPostal = c;
		numMetros = n;
		garaje = g;
	}

	public Casa(String direccion, int c, int n) {
		this.direccion = direccion;
		codPostal = c;
		numMetros = n;
		garaje = true;
	}

	public void mostrar() {
		if (garaje)
			System.out.printf("La casa está en %s, en el codigo postal %d, mide %d, y tiene garaje\n", direccion,
					codPostal, numMetros);
		else
			System.out.printf("La casa está en %s, en el codigo postal %d, mide %d, y no tiene garaje\n", direccion,
					codPostal, numMetros);

	}

}
