package ejercicio03;

public class gallo extends animal {
	int numcombates;

	public gallo(int ID, double p, String f, int nc) {
		super(ID, p, f);
		numcombates = nc;

	}

	void habla() {
		System.out.printf("Cocoroco, soy un gallo, peso %.2f kilos, naci el dia %s y tengo %d numero de combates \n",
				getPeso(), fnac, numcombates);
	}

}
