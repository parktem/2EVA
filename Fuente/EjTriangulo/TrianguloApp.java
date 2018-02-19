package EjTriangulo;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class TrianguloApp extends Frame {
	Triangulo triangulo;

	public static void main(String[] args) {
		TrianguloApp trianguloApp = new TrianguloApp();
	}

	public TrianguloApp() {
		super("Dibujar triangulos");
		Triangulo triangulo = new Triangulo();
		Panel panel1 = new Panel();
		Button boton1 = new Button("Salir");
		Button boton2 = new Button("Siguiente");
		panel1.add(boton1);
		panel1.add(boton2);
		add("North", panel1);
		pack();
		resize(400, 400);
		show();
	}

	public void paint(Graphics g) {
		triangulo.dibujar(g);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			if (ev.target instanceof Button) {
				if ("Salir".equals(ev.arg)) {
					System.exit(0);
					return true;
				}

				if ("Siguiente".equals(ev.arg)) {
					triangulo.recalcular();
					repaint();

					return true;
				}

			}

		}

		return false;
	}
}
