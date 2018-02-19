package PruebaSnake;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

public class SnakeApp extends Applet implements Runnable {
	Thread animacion;
	Snake snake;
	Color color;

	public static void main(String[] args) {
		SnakeApp snakeapp = new SnakeApp();
	}

	public void init() {
		color = new Color(359099);
		setBackground(color);
		setSize(500, 500);
		snake = new Snake(10, 10, 3, 3, Color.CYAN);
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
		if (tecla == 1006) {
			snake.actualizar(Snake.IZQUIERDA);
		}
		if (tecla == 1007) {
			snake.actualizar(Snake.DERECHA);
		}
		if (tecla == 1005) {
			snake.actualizar(Snake.ARRIBA);
		}
		if (tecla == 1007) {
			snake.actualizar(Snake.ABAJO);
		}
		return true;
	}

}
