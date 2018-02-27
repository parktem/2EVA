package Ejercicio23;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class QuijoteApp extends Applet implements Runnable {

	String quijote[] = { "En", "un", "lugar", "de", "la", "Mancha", "cuyo", "nombre", "no", "quiero", "acordarme", "no",
			"hace", "mucho", "tiempo", "que", "vivía", "un", "hidalgo", "de", "los", "de", "lanza", "en", "astillero",
			"adarga", "antigua", "rocin", "flaco", "y", "galgo", "corredor" };
	List<Palabra> palabras;
	Thread animacion;
	int temporizador = 0;
	final int TIEMPO = 30;
	int index = 0;

	public void init() {
		setSize(300, 300);
		palabras = new ArrayList<Palabra>();

		palabras.add(new Palabra(quijote[0]));
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < palabras.size(); i++) {
			palabras.get(i).dibujar(g);
		}
	}

	public void run() {
		while (true) {
			for (int i = 0; i < palabras.size(); i++) {
				palabras.get(i).actualizar();

			}
			temporizador = (temporizador + TIEMPO) % 3000;
			if (temporizador == 0) {
				index++;
				palabras.add(new Palabra(quijote[index]));
			}
			if (Palabra.comprobacion == true) {
				animacion.stop();
			}
			repaint();
			try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {

			}
		}
	}

	public boolean mouseDown(Event ev, int x, int y) {
		if (palabras.get(0).inside(x, y)) {
			palabras.remove(0);
		}
		repaint();
		return true;
	}

}
