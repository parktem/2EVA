package Ejercicio24;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelotitasexamen extends Rectangle {
	int posX, posY, anchura, altura;
	int velX;
	int velY;
	Color color;
	static Random r = new Random();

	public Pelotitasexamen(Color color) {
		super(r.nextInt(275), r.nextInt(275), 20, 20);
		velX = 15;
		velY = 15;
	}

	public void dibujar(Graphics gg) {
		gg.setColor(color);
		gg.fillOval(x, y, width, height);
	}

	public void actualizar() {
		if (x >= PelotasExamen.LATERAL - 20 || x <= 0) {
			velX = -velX;
		}
		if (y >= PelotasExamen.FRONTAL - 20 || y < 0) {
			velY = -velY;
		}
		x += velX;
		y += velY;
	}
}
