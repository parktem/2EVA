package Ejercicio14;

import java.util.Random;

public class helado {

	public static void main(String[] args) {
		Random r = new Random();
		String[] helado = { "Turr�n", "Nocilla" };
		System.out.println(helado[r.nextInt(2)]);
	}

}
