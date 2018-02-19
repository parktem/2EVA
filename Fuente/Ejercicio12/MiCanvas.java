package Ejercicio12;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class MiCanvas extends Canvas {
	Dospuntos actual;
	List<Dospuntos> Lista;
	private int tipo;

	public MiCanvas(int tipo) {
		super(); // El metodo constructor de la clase canvas no espera recibir ningún parametro
		setBackground(Color.yellow);
		this.tipo = tipo;
		Lista = new ArrayList();
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void paint(Graphics g) {
		// g.drawString("Hola", 30, 30);
		if (actual != null)
			actual.Dibujar(g);
		for (int i = 0; i < Lista.size(); i++) {
			Lista.get(i).Dibujar(g);
		}

	}

	public boolean mouseDown(Event ev, int x, int y) {
		// Los metodos de tratamiento de eventos del raton esperan recibir un evento y
		// dos enteros con la posición del ratón.
		actual = new Dospuntos(x, y, tipo); // Llamamos al mtodo constructor de 3 valores.
		repaint(); // El metodo repaint borra y vuelve a dibujar
		return false;
	}

	public boolean mouseDrag(Event ev, int x, int y) { // Metodo de arrastrar. Cada vez que se ejecuta hay que cambiar
														// la posición de x e y, porque logicamente se irá moviendo la
														// posición del ratón
		actual.finX = x;
		actual.finY = y;
		repaint();
		return false;
	}

	public boolean mouseUp(Event ev, int x, int y) {
		Lista.add(actual);
		actual = null;
		return true;
	}

	public List getLista() {
		return Lista;
	}

}
