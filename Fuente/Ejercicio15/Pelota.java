package Ejercicio15;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota {
	int posX, posY, anchura, altura;
	int velX;
	int velY;
	Color color;

	public Pelota(int posX, int posY, int anchura, int altura, Color color) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.anchura = anchura;
		this.altura = altura;
		this.velX = 5;
		this.velY = 5;
		this.color = color;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(posX, posY, anchura, altura);
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
