package Ejercicio23;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Palabra extends Rectangle {
	QuijoteApp quijitoapp = new QuijoteApp();
	String palabra;
	int velX, velY;
	static Random r = new Random();
	static Boolean comprobacion = false;

	public Palabra(String palabra) {
		super(300, r.nextInt(300), palabra.length() * 10, 20);
		velX = 2;
		velY = 2;
		this.palabra = palabra;
	}

	public void dibujar(Graphics g) {
		if (x == 0) {
			g.drawString("Game Over", 130, 150);
			comprobacion = true;
		} else {
			g.setColor(Color.yellow);
			g.fillRect(x, y, width, height);
			g.setColor(Color.red);
			g.drawString(palabra, x + 3, y + 12);
		}
	}

	public void actualizar() {
		x -= velX;
	}

}
