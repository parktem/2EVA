package Ejercicio22me;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PajaritoApp extends Applet implements Runnable {
	List<Columna> columnassup;
	List<Columna> columnasdown;
	public static Image imagen;
	Pajarito pajarito;
	Thread animacion;
	Random r;
	Color[] colores = { Color.DARK_GRAY, Color.green, Color.MAGENTA, Color.PINK };
	public static boolean tocado = false;

	public void init() {
		r = new Random();
		imagen = getImage(getDocumentBase(), "jhonny.png");
		setSize(300, 300);
		columnassup = new ArrayList<Columna>();
		columnasdown = new ArrayList<Columna>();
		for (int i = 0; i < 10; i++) {
			columnassup.add(new Columna(colores[r.nextInt(4)], i * 100));
		}
		for (int i = 0; i < 10; i++) {
			columnasdown.add(new Columna(colores[r.nextInt(4)], i * 100, 1));
		}
		pajarito = new Pajarito(Color.blue);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		pajarito.dibujar(g);
		for (int i = 0; i < columnassup.size(); i++) {
			columnassup.get(i).dibujar(g);
		}
		for (int i = 0; i < columnassup.size(); i++) {
			columnasdown.get(i).dibujar(g);
		}

	}

	public void run() {
		while (true) {
			pajarito.actualizar(1);
			for (int i = 0; i < columnassup.size(); i++) {
				columnassup.get(i).actualizar();
			}
			for (int i = 0; i < columnassup.size(); i++) {
				columnasdown.get(i).actualizar();
			}
			for (int i = 0; i < columnassup.size(); i++) {
				if (pajarito.intersects(columnassup.get(i)) || (pajarito.intersects(columnasdown.get(i)))) {
					tocado = true;
				}
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
