package Ejercicio18;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PelotaApp extends Applet implements Runnable {
	public static final int NUMPEL = 100;
	List<Pelota> pelotas; // pelotass es una lista cuyos objetos son de la clase Pelota
	Random r;
	Pelota pelota;
	public Thread animacion;
	Image imagen; // Un objeto de la clase Image lleva un objeto graohics dentro
	Graphics noseve;
	Color[] colores = { Color.YELLOW, Color.BLUE, Color.LIGHT_GRAY, Color.RED, Color.magenta, Color.CYAN };

	public static void main(String[] args) {
		PelotaApp pelotaapp = new PelotaApp();
	}

	public void init() {
		setBackground(Color.black);
		r = new Random();
		setSize(300, 300);
		pelotas = new ArrayList<Pelota>();
		for (int i = 0; i < NUMPEL; i++) {
			pelotas.add(new Pelota(r.nextInt(270), r.nextInt(270), 30, 30, colores[r.nextInt(6)]));
		}
		imagen = createImage(300, 300); // Este metodo llama al método constructor. Llamandolo instanciamos el objeto de
										// la clase imagen.
		noseve = imagen.getGraphics(); // El objeto noseve apunta a la dirección de memoria del objeto graphics del
										// objeto imagen.
	}

	public void run() { // Este metodo run no forma parte del ciclo de vida y por tanto hay que llamarle
		while (true) {

			for (int i = 0; i < pelotas.size(); i++) {
				pelotas.get(i).actualizar();
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
		noseve.setColor(Color.white);
		noseve.fillRect(0, 0, 300, 300);
		for (int i = 0; i < pelotas.size(); i++) {
			pelotas.get(i).dibujar(noseve);
		}
		g.drawImage(imagen, 0, 0, this); // Posicion x, y, y dónde (applet)
	}

	public void update(Graphics g) {
		paint(g);
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
