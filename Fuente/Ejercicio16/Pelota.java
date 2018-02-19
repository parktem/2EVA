package Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota {
	int posX, posY, anchura, altura;
	int velX;
	int velY;
	Color color;

	public Pelota(int posX, int posY, int anchura, int altura, Color color) {
		super();
		this.posX = (int) (Math.random() * 270);
		this.posY = (int) (Math.random() * 270);
		this.anchura = anchura;
		this.altura = altura;
		this.velX = (int) (Math.random() * 6) + 2;
		this.velY = (int) (Math.random() * 6) + 2;
		this.color = color;
	}

	public void dibujar(Graphics gg) {
		gg.setColor(color);
		gg.fillOval(posX, posY, anchura, altura);
	}

	public void actualizar() {
		if (posX >= 270 || posX <= 0) {
			velX = -velX;
		}
		if (posY >= 270 || posY <= 0) {
			velY = -velY;
		}
		posX += velX;
		posY += velY;
	}

}
