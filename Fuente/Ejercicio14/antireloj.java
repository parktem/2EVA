package Ejercicio14;

import java.awt.Color;
import java.awt.Graphics;

public class antireloj extends Rectangulo {

	private Color color;
	private int posX, posY, anchura, altura;
	private int direccion;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;

	private int topeUp, topeDown, topeLeft, topeRight;

	public antireloj(int posX, int posY, int anchura, int altura, Color color, int direccion) {
		super(posX, posY, anchura, altura, color, direccion);
		this.posX = posX;
		this.posY = posY;
		this.anchura = anchura;
		this.altura = altura;
		this.color = color;
		this.direccion = direccion;
		topeUp = posX - 10;
		topeDown = posX;
		topeRight = posY + 10;
		topeLeft = posY;
	}

	public void actualizar() {

		switch (direccion) {
		case UP:
			posX--;
			if (posX < topeUp)
				direccion = RIGHT;
			break;

		case RIGHT:
			posY++;
			if (posY > topeRight)
				direccion = DOWN;

			break;

		case DOWN:
			posX++;
			if (posX >= topeDown)
				direccion = LEFT;

			break;

		case LEFT:
			posY--;
			if (posY <= topeLeft)
				direccion = UP;

			break;

		}
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(posX, posY, anchura, altura);
	}
}
