package Ejercicio21;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelota21 extends Rectangle {
	int velX, velY, posX, posY;
	Color color;
	Random r;

	public Pelota21(Color color, int posx, int posy, int vx, int vy) {
		super(100, 150, 20, 20);
		r = new Random();
		velX = (int) (Math.random() * 6) + 6;
		velY = (int) (Math.random() * 6) + 6;
		this.color = color;
	}

	public Pelota21(int posX, int posY, Color color) {
		this(posX, posY, (((int) (Math.random() * 13)) - 6), ((int) (Math.random() * 13) - 6));
	}

	public void Dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void Actualizar() {

		if (x >= 280 || x <= 0) {
			velX = -velX;
		}
		if (y >= 280 || y <= 0) {
			velY = -velY;
		}
		x += velX;
		y += velY;

	}
}
