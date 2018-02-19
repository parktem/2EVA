package ejercicio05;

public class ejecutable {
	static private int resultados[][];
	static Bombo bombo1;
	public static final int FILAS = 6;
	public static final int COLUMNAS = 8;

	public static void main(String[] args) {
		bombo1 = new Bombo();
		resultados = new int[FILAS][COLUMNAS];
		// System.out.println(bombo1.getnumBolas());
		System.out.println(bombo1.getBola());
		rellenar();
		mostrar();
	}

	public static void rellenar() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				resultados[i][j] = bombo1.getBola();
			}
		}
	}

	public static void mostrar() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.printf(" %d ", resultados[i][j]);
			}
			System.out.println();
		}
	}

}
