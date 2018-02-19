package Ejercicio14;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Mondrian extends Applet implements Runnable {
	// **CILO DE VIDA DE UN APPLET**
	// 1) El metodo init() se utiliza para iniciar el ciclo de vida del Applet.
	// 2) El metodo stant() se suele utilizar para instanciar y activar los Threads
	// 3) El metodo paint(Graphics) espera recibir un objeto Graphics
	// 4) El metodo stop() sirve para parar Threads

	/*
	 * public static final int UP = 0; public static final int DOWN = 1; public
	 * static final int LEFT = 2; public static final int RIGHT = 3; public int
	 * direccion; int posX, posY;
	 */
	public Thread animacion;
	reloj rectangulo;
	reloj[] rectangulos;
	antireloj rectangulo2;
	antireloj[] rectangulos2;
	Color[] colores = { Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.BLUE, Color.BLUE, Color.LIGHT_GRAY, Color.RED,
			Color.RED, Color.magenta };
	int[] posX = { 0, 250, 80, 80, 100, 80, 200, 100, 200 };
	int[] posY = { 0, 0, 110, 200, 10, 100, 0, 10, 55 };
	int[] anchura = { 90, 40, 100, 220, 90, 200, 45, 90, 60 };
	int[] altura = { 90, 120, 20, 90, 80, 90, 45, 200, 135 };

	public void init() {
		setBackground(Color.black);
		/*
		 * posX = 80; posY = 100; direccion = UP;
		 */
		rectangulos = new reloj[5];
		for (int i = 0; i < rectangulos.length; i++) {
			rectangulos[i] = new reloj(posX[i], posY[i], anchura[i], altura[i], colores[i], 0);
		}
		rectangulos2 = new antireloj[4];
		for (int i = 5; i < 9; i++) {
			rectangulos2[i - 5] = new antireloj(posX[i], posY[i], anchura[i], altura[i], colores[i], 0);
		}

	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		/*
		 * g.setColor(Color.yellow); g.fillRect(0, 0, 90, 90); g.fillRect(250, 0, 40,
		 * 190); g.fillRect(80, 110, 100, 20);
		 * 
		 * g.setColor(Color.blue); g.fillRect(80, 200, 220, 90); g.fillRect(100, 10, 90,
		 * 80);
		 * 
		 * g.setColor(Color.lightGray); g.fillRect(posX, posY, 200, 70);
		 * 
		 * g.setColor(Color.red); g.fillRect(200, 0, 45, 45); g.fillRect(100, 10, 90,
		 * 80);
		 * 
		 * g.setColor(Color.magenta); g.fillRect(200, 55, 60, 135);
		 */
		for (int i = 0; i < 5; i++) {
			rectangulos[i].dibujar(g);
		}
		for (int j = 0; j < rectangulos2.length; j++) {
			rectangulos2[j].dibujar(g);
		}
	}

	/*
	 * public void actualizar() { switch (direccion) { case UP: posY--; if (posY <
	 * 90) direccion = RIGHT; break;
	 * 
	 * case RIGHT: posX++; if (posX > 90) direccion = DOWN;
	 * 
	 * break;
	 * 
	 * case DOWN: posY++; if (posY >= 100) direccion = LEFT;
	 * 
	 * break;
	 * 
	 * case LEFT: posX--; if (posX <= 80) direccion = UP;
	 * 
	 * break;
	 * 
	 * } }
	 */

	public void run() { // Este metodo run no forma parte del ciclo de vida y por tanto hay que llamarle
		while (true) {
			for (int i = 0; i < 5; i++) {
				rectangulos[i].actualizar();
				repaint();
			}
			for (int j = 0; j < rectangulos2.length; j++) {
				rectangulos2[j].actualizar();
			}
			// rectangulo.actualizar();
			// actualizar();
			// posX++;
			// Cada 50 milisegundos reinicia la animación, el repaint hace todo el borrado,
			// por eso a veces parece que parpadea
			try {
				Thread.sleep(50); // Duermelo durante 50 milisegundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
