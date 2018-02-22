package PruebaSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Snake extends Rectangle {
	static SnakeApp snakeapp = new SnakeApp();
	public static final int DERECHA = 0;
	public static final int IZQUIERDA = 1;
	public static final int ABAJO = 2;
	public static final int ARRIBA = 3;
	int posX, posY, anchura, altura, velY, velX;
	public static boolean d1, d2, d3, d4;
	Color color;

	public Snake(Color color) {
		super(150, 150, 20, 20);
		this.color = color;
		velY = 3;
		velX = 3;
	}

	public void Dibujar(Graphics gg) {
		gg.setColor(color);
		gg.fillRect(x, y, width, height);
	}

	public void actualizar(int direccion) {
		d1 = false;
		d2 = false;
		d3 = false;
		d4 = false;

		if (direccion == DERECHA) {
			for (int i = 0; i < 10; i++) {
				x += velX + width;
			}
			d1 = true;
		} else if (direccion == IZQUIERDA) {
			x -= velX + width;
		} else if (direccion == ARRIBA) {
			y += velY + width;
		} else if (direccion == ABAJO) {
			y -= velY + width;
		}

	}

}
