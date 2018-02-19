package Ejercicio19;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Rectangulo extends Rectangle{
	Color color;
    public Rectangulo(int posX, int posY, int ancho, int alto, Color color) {
		super(posX, posY, ancho, alto);
		this.color = color;
    }
    
    abstract void dibujar(Graphics g);
    
}