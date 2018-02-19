package Ejercicio12;

import java.awt.Graphics;

public class Dospuntos {
	public static final int LINEA = 0;
	public static final int OVALO = 1;
	public static final int RECTANGULO = 2;
	public int inicioX, inicioY, finX, finY, tipo;

	/*
	 * Public dice que el atributo no es privado, no está encapsulado. Public en la
	 * clase significa que se puede acceder a la clase desde otros paquetes. ¿Cómo?
	 * Importandolos. Aquí da igual porque seguimos en el mismo paquete. Static
	 * significa que podemos acceder a él a través del nombre de la clase. Los
	 * atributos estáticos tendrán el mismo valor para todos los objetos de la
	 * clase, aunque no sean finales. Final quiere decir que esos atributos son
	 * constantes
	 */

	public Dospuntos(int iX, int iY, int fX, int fY, int t) {
		inicioX = iX;
		inicioY = iY;
		finX = fX;
		finY = fY;
		tipo = t;
	}

	public Dospuntos() {
		this(0, 0, 0, 0, LINEA); // this quiere decir que estoy llamando al metodo constructor de Dospuntos
	}

	public Dospuntos(int ix, int iy, int t) { // este this también llama al primer metodo constructor
		this(ix, iy, ix, iy, t);
	}

	public void Dibujar(Graphics g) {
		switch (tipo) {
		case LINEA:
			g.drawLine(inicioX, inicioY, finX, finY);
			break;
		case RECTANGULO:
			g.drawRect(inicioX, inicioY, finX, finY);
			break;
		case OVALO:
			g.drawOval(inicioX, inicioY, Math.abs(finX - inicioX), Math.abs(finY - inicioY));
			break;
		}
	}

}
