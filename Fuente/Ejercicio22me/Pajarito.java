package Ejercicio22me;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pajarito extends Rectangle {
	static PajaritoApp pajaritoapp = new PajaritoApp();
	public static final int SALTAR = 0;
	int velX, velY;
	Color color;
	Image imagen;

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
			// g.drawImage(PajaritoApp.imagen, x, y, (int) (getWidth() - 250), (int)
			// (getHeight() - 250), pajaritoapp);

		} else {
			g.setColor(Color.red);
			g.drawString("GAME OVER", 150, 150);
		}
	}

	public void actualizar(int direccion) {
		if (direccion == SALTAR) {
			y -= velY + 15;
		}
		y += velY;
	}

}
