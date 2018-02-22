package Ejercicio21;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PelotitasApp extends Applet implements Runnable {
	List<Pelota21> pelotasrojas;
	List<Pelota21> pelotasamarillas;
	Thread animacion;

	public void init() {
		setSize(300, 300);
		pelotasrojas = new ArrayList<Pelota21>();
		pelotasamarillas = new ArrayList<Pelota21>();
		for (int i = 0; i < 10; i++) {
			pelotasrojas.add(new Pelota21(Color.red));
		}
		for (int i = 0; i < 1; i++) {
			pelotasamarillas.add(new Pelota21(Color.YELLOW));
		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i < pelotasrojas.size(); i++) {
			pelotasrojas.get(i).Dibujar(g);
		}

		for (int i = 0; i < pelotasamarillas.size(); i++) {
			pelotasamarillas.get(i).Dibujar(g);
		}
	}

	public void run() { // Este metodo run no forma parte del ciclo de vida y por tanto hay que llamarle
		while (true) {
			try {
				for (int i = 0; i < pelotasrojas.size(); i++) {
					pelotasrojas.get(i).Actualizar();
				}

				for (int i = 0; i < pelotasamarillas.size(); i++) {
					pelotasamarillas.get(i).Actualizar();
				}
				for (int i = 0; i < pelotasrojas.size(); i++) {
					for (int j = 0; j < pelotasamarillas.size(); j++) {
						if (pelotasamarillas.get(j).intersects(pelotasrojas.get(i))) {
							pelotasrojas.remove(i);
							pelotasamarillas
									.add(new Pelota21(pelotasrojas.get(i).x, pelotasrojas.get(i).y, Color.yellow));
						}
					}
				}
			} catch (IndexOutOfBoundsException e) {
				repaint();
			}
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

}
