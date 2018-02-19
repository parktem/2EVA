package ejercicio02;

public class Ejecutable {

	public static void main(String[] args) {
		Casa casa1, casa2;

		casa1 = new Casa("Pintor Zuloaga", 50018, 30, true);
		casa1.mostrar();

		casa2 = new Casa("Avd. de Navarra", 50019, 50, false);
		casa2.mostrar();

		Chalet chalet1, chalet2;

		chalet1 = new Chalet("Picarral", 50019, 80, false, 60, true);
		chalet1.mostrar();
	}

}
