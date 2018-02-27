package Ejercicio22;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Columna {

	Rectangle r1, r2;
	int velX, px;
	Color color;
	static int ejeX = 275;

	public Columna(int px) {
		int altura = (int) (Math.random() * 200);
		this.px = px;
		r1 = new Rectangle(300 + px, 0, 30, altura);
		r2 = new Rectangle(300 + px, altura + 50, 30, 300 + altura - 50);
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(r1.x, r1.y, r1.width, r1.height);
		g.fillRect(r2.x, r2.y, r2.width, r2.height);
	}

	public void actualizar() {
		r1.x -= 2;
		r2.x -= 2;
	}
}
