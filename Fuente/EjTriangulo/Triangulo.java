package EjTriangulo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Triangulo {
	static int coordX[];
	static int coordY[];
	Color color;
	Random r;

	public Triangulo() {
		recalcular();

		r = new Random();
	}

	public void recalcular() {
		coordX = new int[3];
		coordY = new int[3];
		for (int x = 0; x < coordX.length; x++) {
			coordX[x] = r.nextInt(255);
			coordY[x] = r.nextInt(255);
		}
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		// g.drawPolygon(coordX, coordY, 3);
		// g.drawOval(200, 200, 10, 10);
		// g.setColor(color);
		g.fillOval(45, 50, 10, 10);
	}

}
