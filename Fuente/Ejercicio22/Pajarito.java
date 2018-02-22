package Ejercicio22;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pajarito extends Rectangle {

	public static final int SALTAR = 0;
	int velX, velY;
	Color color;

	public Pajarito(Color color) {
		super(150, 150, 40, 30);
		this.color = color;
		velX = 2;
		velY = 2;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar(int direccion) {
		if (direccion == SALTAR) {
			y -= velY + 15;
		}
		y += velY;
	}

}
