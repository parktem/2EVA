package ejercicio03;

public class perro extends animal {
	String raza;

	public perro(int ID, double p, String f, String r) {
		super(ID, p, f);
		raza = r;
	}

	public void habla() {
		System.out.printf("Guau Guau, soy un perro, peso %.2f kilos, naci el dia %s y soy de raza \n", getPeso(), fnac,
				raza);
	}
}
