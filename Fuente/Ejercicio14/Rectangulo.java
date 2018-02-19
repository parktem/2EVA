package Ejercicio14;

import java.awt.Color;

public abstract class Rectangulo {

	private int posX, posY, anchura, altura;
	private int direccion;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	private Color color;

	public Rectangulo(int posX, int posY, int anchura, int altura, Color color, int direccion) {
		// fillRoad(posX, posY, anchura, altura, direccion);
		this.posX = posX;
		this.posY = posY;
		this.anchura = anchura;
		this.altura = altura;
		this.color = color;
		this.direccion = direccion;

	}

	/*
	 * public void actualizar() {
	 * 
	 * switch (direccion) { case UP: posY--; if (posY < topeUp) direccion = RIGHT;
	 * break;
	 * 
	 * case RIGHT: posX++; if (posX > topeRight) direccion = DOWN;
	 * 
	 * break;
	 * 
	 * case DOWN: posY++; if (posY >= topeDown) direccion = LEFT;
	 * 
	 * break;
	 * 
	 * case LEFT: posX--; if (posX <= topeLeft) direccion = UP;
	 * 
	 * break;
	 * 
	 * } }
	 */

	public abstract void actualizar(); // Estoy creando la obligación de que este metodo se tenga que implementar en
										// las subclases

}
