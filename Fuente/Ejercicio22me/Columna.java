package Ejercicio22me;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Columna extends Rectangle {
	int velX, px;
	Color color;
	static int ejeX = 275;

	public Columna(Color color, int px) {
		super(1165 - px, 0, 35, 100);
		this.color = color;
		this.px = px;
		velX = 2;
	}

	public Columna(Color color, int px, int aux) {
		super(1165 - px, 180, 35, 120);
		this.color = color;
		this.px = px;
		velX = 2;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void actualizar() {
		x -= velX;
	}
}
