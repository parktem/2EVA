package PruebaSnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Snake extends Rectangle {
	public static final int DERECHA = 0;
	public static final int IZQUIERDA = 1;
	public static final int ABAJO = 2;
	public static final int ARRIBA = 3;
	int posX, posY, anchura, altura, velY, velX;
	Color color;

	public Snake(int posX, int posY, int anchura, int altura, Color color) {
		this.color = color;
		this.posX = posX;
		this.posY = posY;
		this.anchura = anchura;
		this.altura = altura;
		velY = 3;
		velX = 3;
	}

	public void Dibujar(Graphics gg) {
		gg.setColor(color);
		gg.fillRect(velX, posY, posX, posY);
	}

	public void actualizar(int direccion) {
		if (direccion == DERECHA) {
			x += velX;
		} else if (direccion == IZQUIERDA) {
			x -= velX;
		} else if (direccion == ARRIBA) {
			y += velY;
		} else if (direccion == ABAJO) {
			y -= velY;
		}

	}

}
