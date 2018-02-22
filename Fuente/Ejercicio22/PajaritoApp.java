package Ejercicio22;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PajaritoApp extends Applet implements Runnable {
	List<Columna> columnas;
	Pajarito pajarito;
	Thread animacion;

	public void init() {
		setSize(300, 300);
		columnas = new ArrayList<Columna>();
		for (int i = 0; i < 10; i++) {
			columnas.add(new Columna(Color.RED, i * 100));
		}
		pajarito = new Pajarito(Color.blue);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		pajarito.dibujar(g);
		for (int i = 0; i < columnas.size(); i++) {
			columnas.get(i).dibujar(g);
		}
	}

	public void run() {
		while (true) {
			pajarito.actualizar(1);
			for (int i = 0; i < columnas.size(); i++) {
				columnas.get(i).actualizar();
			}
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {

			}
		}
	}

	public boolean mouseDown(Event ev, int x, int y) {
		pajarito.actualizar(Pajarito.SALTAR);
		repaint();
		return true;
	}

}
