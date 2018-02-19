package Ejercicio20;

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

	public void actualizar(Raqueta raqueta, Ladrillo ladrillos[][]) {
		x += velX;
		y += velY;
		if ((x < 0) || (x > 285)) {
			velX = -velX;
		}

		if ((y < 0) || (intersects(raqueta))) {
			velY = -velY;
		}

		for (int i = 0; i < ladrillos.length; i++) {
			for (int j = 0; j < ladrillos[i].length; j++) {
				if ((ladrillos[i][j].isVisible()) && (intersects(ladrillos[i][j]))) {
					velY = -velY;
					ladrillos[i][j].setVisible(false);
					break;
				}
			}
		}
	}

}