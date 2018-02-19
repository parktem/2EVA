package ejercicio05;

import java.util.Random; //si pones java.util.* se importan todas las clases del directorio.

public class Bombo {
	private int bolas[];
	private int numBolas = 48;
	Random aleatorio;

	public Bombo() {
		bolas = new int[numBolas];
		for (int i = 0; i < bolas.length; i++) {
			bolas[i] = i + 1;
		}
		aleatorio = new Random();

	}

	public int getnumBolas() {
		return numBolas;
	}

	public int getBola() {
		int numAleatorio, numDevuelve;
		numAleatorio = aleatorio.nextInt(numBolas);
		numDevuelve = numAleatorio;
		bolas[numAleatorio] = bolas[numBolas - 1];
		numBolas--;
		return bolas[numDevuelve];
	}
}
