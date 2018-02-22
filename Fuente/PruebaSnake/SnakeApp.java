package PruebaSnake;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

public class SnakeApp extends Applet implements Runnable {
	Thread animacion;
	Snake snake;
	Color color;
	static boolean verificacion;
	public static boolean d1, d2, d3, d4;

	public static void main(String[] args) {
		SnakeApp snakeapp = new SnakeApp();
	}

	public void init() {
		color = new Color(359099);
		setBackground(color);
		setSize(500, 500);
		snake = new Snake(Color.CYAN);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics gg) {
		snake.Dibujar(gg);
	}

	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(100); // Duermelo durante 50 milisegundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean keyDown(Event e, int tecla) {
		int teclaconf = tecla;
		d1 = false;
		d2 = false;
		d3 = false;
		d4 = false;
		if (tecla == 1006) {
			snake.actualizar(Snake.IZQUIERDA);
			d1 = true;
		}
		if (tecla == 1007) {
			snake.actualizar(Snake.DERECHA);
			d2 = true;
		}
		if (tecla == 1005) {
			snake.actualizar(Snake.ARRIBA);
			d3 = true;
		}
		if (tecla == 1004) {
			snake.actualizar(Snake.ABAJO);
			d4 = true;
		}
		return true;
	}

	public static boolean isTecla() {
		return verificacion;
	}

}
