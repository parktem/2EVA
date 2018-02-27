package Ejercicio24;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PelotasExamen extends Applet implements Runnable {
	public final static int LATERAL = 900;
	public final static int FRONTAL = 900;
	Thread animacion;
	List<Pelotitasexamen> pelotas;
	int cont = 0;

	public void init() {
		setSize(LATERAL, FRONTAL);
		pelotas = new ArrayList<Pelotitasexamen>();
		pelotas.add(new Pelotitasexamen(Color.BLUE));
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		for (int i = 0; i < pelotas.size(); i++) {
			pelotas.get(i).dibujar(g);
		}
	}

	public void run() {
		while (true) {
			repaint();
			for (int i = 0; i < pelotas.size(); i++) {
				pelotas.get(i).actualizar();
			}
			try {
				Thread.sleep(50);
				for (int j = 0; j < pelotas.size(); j++) {

					if (pelotas.get(j).y < 0) {
						pelotas.add(new Pelotitasexamen(Color.blue));
						System.out.println(cont++);
					}
				}
			} catch (InterruptedException e) {

			}
		}
	}
}
