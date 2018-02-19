package Ejercicio20;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Arkanoid extends Applet implements Runnable {
	public static final int FILAS = 5;
	public static final int COLUMNAS = 10;
	Color colpelota;
	Pelota pelota;
	Raqueta raqueta;
	Color[] colores = { Color.cyan, Color.blue, Color.GREEN, Color.pink, Color.YELLOW };
	Ladrillo[][] ladrillos;
	Thread animacion;
	Image imagen;
	Graphics noseve;

	public void init() {
		colpelota = new Color(0166255);
		setSize(300, 300);
		setBackground(Color.BLACK);
		raqueta = new Raqueta();
		ladrillos = new Ladrillo[FILAS][COLUMNAS];
		pelota = new Pelota();
		for (int i = 0; i < ladrillos.length; i++) {
			for (int j = 0; j < ladrillos[i].length; j++) {
				ladrillos[i][j] = new Ladrillo((j * 30) + 1, (i * 20) + 1, 28, 10, colores[i]);
			}
		}

		imagen = createImage(300, 300);
		noseve = imagen.getGraphics();
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 300, 300);
		for (int i = 0; i < ladrillos.length; i++) {
			for (int j = 0; j < ladrillos[i].length; j++) {
				ladrillos[i][j].dibujar(g);
			}
		}
		pelota.dibujar(g);
		raqueta.dibujar(g);
		if (pelota.y > 300)
			g.drawString("Game Over", 125, 140);

	}

	public void run() {
		while (true) {
			pelota.actualizar(raqueta, ladrillos);
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {

			}
		}
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start(); // llama al método run()
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean keyDown(Event e, int tecla) {
		if (tecla == 1006) {
			raqueta.actualizar(Raqueta.IZQUIERDA);
		}
		if (tecla == 1007) {
			raqueta.actualizar(Raqueta.DERECHA);
		}
		return true;
	}

}