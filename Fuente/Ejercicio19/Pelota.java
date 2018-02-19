package Ejercicio19;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Rectangulo {
	private int velX, velY;

	public int getVelY() {
		return velY;
	}

	public void setVelY() {
		velY = -velY;

	}

	Color color;
	boolean mensaje;
	boolean visibilidad;

	public Pelota() {
		super(100, 150, 15, 15, Color.white);
		velX = 5;
		velY = 5;
	}

	public void dibujar(Graphics gg) {
		gg.setColor(color);
		gg.fillOval(x, y, 15, 15);
	}

	public void actualizar() {
		x += velX;
		y += velY;
		if ((x < 0) || (x > 285)) {
			velX = -velX;
		}
		if (y < 0) {
			velY = -velY;
		}
	}

}