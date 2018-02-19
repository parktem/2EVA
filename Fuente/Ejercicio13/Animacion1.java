package Ejercicio13;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;

public class Animacion1 extends Frame implements Runnable { // Runnable no es una clase, es una interfaz y se implementa
	// Implements obliga a implementar todos los metodos que haya declarado en el
	// interfaz. En este caso metodo run
	String frames[] = { "*", "**", "***", "****", "*****", "****", "***", "**", "*" };
	Thread animacion;
	int position = 0;

	public static void main(String[] args) {
		Animacion1 animacion = new Animacion1();

	}

	public Animacion1() {
		super("Dibujando en el Frame");
		setup();
		pack();
		resize(400, 400);
		show();
		animacion = new Thread(this); // Le podemos pasar un Frame, nada, objetos...
		animacion.start(); // Este metodo start llama al metodo run y lo convierte en un thread
	}

	public void run() {
		do {
			try {
				position = (++position) % frames.length;
				repaint();
				Thread.sleep(100); // Espera recibir un entero con el numero de milisegundos que vamos a dormirlo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public void paint(Graphics g) {
		g.drawString(frames[position], 70, 100);
	}

	public void setup() {

	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		}
		return false;
	}

}
