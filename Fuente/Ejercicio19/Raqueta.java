package Ejercicio19;

import java.awt.Color;
import java.awt.Graphics;

public class Raqueta extends Rectangulo {
	public static final int DERECHA = 0;
	public static final int IZQUIERDA = 1;
	public int velX;

	public Raqueta() {
		super(125, 250, 50, 10, Color.red);
		velX = 10;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void actualizar(int direccion) {
		if (direccion == DERECHA) {
			x += velX;
		} else if (direccion == IZQUIERDA) {
			x -= velX;
		}
		if (x < 0)
			x = 0;
		if (x > 250)
			x = 250;
	}

}
