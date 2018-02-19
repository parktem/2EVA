package ejercicio02;

public class Chalet extends Casa {
	int metrosJardin;
	boolean piscina;

	public Chalet(String direccion, int c, int n, boolean g, int mj, boolean piscina) {
		super(direccion, c, n, g);
		metrosJardin = mj;
		this.piscina = piscina;
	}

	// Aquí quitamos garaje
	public Chalet(String direccion, int c, int n, int mj, boolean piscina) {
		super(direccion, c, n);
		metrosJardin = mj;
		this.piscina = piscina;
	}

	// Aquí quitamos piscina y la ponemos en falso
	public Chalet(String direccion, int c, int n, int mj) {
		super(direccion, c, n);
		metrosJardin = mj;
		this.piscina = false;
	}

	public void mostrar() {
		if (garaje) {
			if (piscina) {
				System.out.printf(
						"La casa está en %s, en el codigo postal %d, mide %d, tiene garaje, el jardin mide 30, y tiene piscina\n",
						direccion, codPostal, numMetros, metrosJardin);
			} else {
				System.out.printf(
						"La casa está en %s, en el codigo postal %d, mide %d, tiene garaje, el jardin mide 30, y no tiene piscina\n",
						direccion, codPostal, numMetros, metrosJardin);
			}
		} else {
			if (piscina) {
				System.out.printf(
						"La casa está en %s, en el codigo postal %d, mide %d, no tiene garaje, el jardin mide 30, y tiene piscina\n",
						direccion, codPostal, numMetros, metrosJardin);
			} else {
				System.out.printf(
						"La casa está en %s, en el codigo postal %d, mide %d, no tiene garaje, el jardin mide 30, y no tiene piscina\n",
						direccion, codPostal, numMetros, metrosJardin);
			}
		}

	}

}
