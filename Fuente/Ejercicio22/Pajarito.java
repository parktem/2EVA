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
		if (PajaritoApp.tocado == false) {
			g.setColor(color);
			g.fillOval(x, y, width, height);
		} else {
			g.fillOval(x, y, width, height);
			g.setColor(Color.red);
			g.drawString("Game Over", 150, 150);
		}
	}

	public void actualizar(int direccion) {
		if (PajaritoApp.tocado == false) {
			if (direccion == SALTAR) {
				y -= velY + 20;
			}
			y += velY + 1;

		} else {
			y += velY + 10;
		}
	}

}
