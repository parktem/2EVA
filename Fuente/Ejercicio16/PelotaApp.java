package Ejercicio16;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class PelotaApp extends Applet implements Runnable {

	Random r;
	Pelota pelota;
	public Thread animacion;
	Pelota pelotas[];
	Color[] colores = { Color.YELLOW, Color.BLUE, Color.LIGHT_GRAY, Color.RED, Color.magenta, Color.CYAN };

	public static void main(String[] args) {
		PelotaApp pelotaapp = new PelotaApp();
	}

	public void init() {
		r = new Random();
		setSize(300, 300);
		pelotas = new Pelota[4];
		for (int i = 0; i < pelotas.length; i++) {
			pelotas[i] = new Pelota(r.nextInt(270), r.nextInt(270), 30, 30, colores[r.nextInt(6)]);
		}
	}

	public void run() { // Este metodo run no forma parte del ciclo de vida y por tanto hay que llamarle
		while (true) {

			for (int i = 0; i < pelotas.length; i++) {
				pelotas[i].actualizar();
			}

			repaint();
			try {
				Thread.sleep(50); // Duermelo durante 50 milisegundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < pelotas.length; i++) {
			pelotas[i].dibujar(g);
		}
	}

	/*
	 * public void run() { // Este metodo run no forma parte del ciclo de vida y por
	 * tanto hay que llamarle while (true) {
	 * 
	 * 
	 * try { Thread.sleep(50); // Duermelo durante 50 milisegundos } catch
	 * (InterruptedException e) { e.printStackTrace(); } } }
	 */

}
