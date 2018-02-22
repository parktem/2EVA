package Ejercicio22;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Columna extends Rectangle {
	int velX, px;
	Color color;
	static int ejeX = 275;

	public Columna(Color color, int px) {
		super(265 - px, 0, 35, 120);
		this.px = px;
		this.velX = velX;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void actualizar() {
		x -= velX;
	}
}
