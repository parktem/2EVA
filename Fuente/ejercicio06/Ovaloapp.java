package ejercicio06;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class Ovaloapp extends Frame {
	Ovalo ovalo;

	public static void main(String args[]) {
		Ovaloapp Ovaloapp = new Ovaloapp();
	}

	public Ovaloapp() {
		super("Dibujando ovalos");

		ovalo = new Ovalo();

		Panel panel = new Panel();
		Button boton1 = new Button("Salir");
		Button boton2 = new Button("Siguiente");
		// aqu�, si en add no pongo nada, se me meter� en la clase Frame y no es lo que
		// quiero
		panel.add(boton1);
		panel.add(boton2);

		add("South", panel);
		// add("South", boton2);
		// this est� implicito, no es necesario ponerlo
		this.pack(); // El metodo pack ordena como le digamos, es imprescindible para Frame
		resize(300, 300); // Dimensiones de ventana
		show(); // Cuando tacha un m�todo es porque est� "anticuado"
	}

	public void paint(Graphics g) {
		ovalo.Dibujar(g);
	}

	public boolean handleEvent(Event ev) { // Sobreescribimos en el metodo"override" return false;
		if (ev.id == Event.WINDOW_DESTROY) {
			/*
			 * WINDOW_DESTROY es un atributo constante, es decir tiene el modificador final,
			 * y tambi�n estatic, es decir, se puedde acceder a �l a traves del nombre de la
			 * clase.
			 */
			System.exit(0); // Se le pone 0 porque espera recibir un valor, sin m�s.
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			/*
			 * Action event es un evento de accion, pero para cada objeto el evento de
			 * acci�n es diferente.
			 */
			if (ev.target instanceof Button) {
				if ("Salir".equals(ev.arg)) {
					// target nos devuelve sobre que clase de objeto se ha producido el evento.
					// instanceof es un comparador (es una resta)
					System.exit(0);
					return true;
				} else if ("Siguiente".equals(ev.arg)) {
					// ovalo = new Ovalo();
					// repaint(); //Cada vez se ir� reservando una zona de memoria distinta.
					ovalo.recalcular(); // Aqu� en cambio se reserva solo una zona de memoria sobre la que se cambiar�
										// el ovalo.
					repaint();
					return true;
				}
			}
		}
		return false;
	}
}
