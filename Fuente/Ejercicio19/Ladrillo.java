package Ejercicio19;

import java.awt.Color;
import java.awt.Graphics;

public class Ladrillo extends Rectangulo {
	private boolean visible;

	public Ladrillo(int posX, int posY, int ancho, int alto, Color color) {
		super(posX, posY, ancho, alto, color);
		visible = true;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void dibujar(Graphics g) {
		if (visible) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}

}