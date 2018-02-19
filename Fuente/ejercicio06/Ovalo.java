
package ejercicio06;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ovalo {
	int ejex;
	int ejey;
	Color color;
	int anchura;
	int altura;
	Random r;

	public Ovalo() {
		r = new Random(); // Aqui le damos el valor null
		recalcular();
	}

	public void recalcular() {
		ejex = r.nextInt(200);
		ejey = r.nextInt(200);
		anchura = r.nextInt(100);
		altura = r.nextInt(100);
		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

	public void Dibujar(Graphics g) { // Le pasamos la "hoja en blanco" en la que pintaremos el ovalo.
		g.setColor(color);
		g.fillOval(ejex, ejey, anchura, altura); // Método para dibujar un ovalo.

	}
}
