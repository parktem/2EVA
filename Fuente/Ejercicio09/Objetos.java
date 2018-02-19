package Ejercicio09;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;

public class Objetos extends Frame {
	TextArea textArea;

	public static void main(String[] args) {
		Objetos objeto = new Objetos();
	}

	public Objetos() {
		super("Trabajo con objetos");
		setup();
		pack();
		resize(800, 400);
		show();
	}

	public void setup() {
		Panel principal = new Panel();
		principal.setLayout(new GridLayout(3, 3));
		Panel[][] paneles = new Panel[3][3];
		for (int i = 0; i < paneles.length; i++) {
			for (int j = 0; j < paneles.length; j++) {
				paneles[i][j] = new Panel();

			}
		}
		paneles[0][0].add(new Label("Campo de texto"));
		paneles[0][0].add(new MiTextField("", 15)); // TextField es un iput al que se le pueden pasar dos paramentros:
													// el
													// string y la anchura.

		principal.add(paneles[0][0]);

		textArea = new TextArea(5, 15);
		paneles[0][1].add(textArea);
		principal.add(paneles[0][1]);

		paneles[0][2].add(new MiBoton("Vaciar TextArea", textArea));
		principal.add(paneles[0][2]);

		paneles[1][0].add(new MiCanvas());
		principal.add(paneles[1][0]);

		String[] choiceStrings = { "Sí", "No", "Quizás" };
		paneles[1][1].add(new Label("Choice: "));
		principal.add(paneles[1][1]);

		paneles[1][1].add(new MiChoice(choiceStrings, textArea));
		principal.add(paneles[1][1]);

		String[] deportes = { "Futbol sala", "Tenis", "Golf", "Petanca" };
		paneles[1][2].add(new MiLista(3, false, deportes, textArea));
		principal.add(paneles[1][2]);

		String[] colores = { "", "Rojo", "Verde", "Azul" };
		paneles[2][0].add(new MicheckBoxGroup(colores));
		principal.add(paneles[2][0]);
		paneles[2][1].setLayout(new BorderLayout());
		paneles[2][1].add(new MiScrollbar(Scrollbar.VERTICAL, 50, 10, 0, 5, textArea));
		principal.add(paneles[2][1]);

		paneles[2][2].add(new MiScrollbar(Scrollbar.HORIZONTAL, 50, 10, 0, 50, textArea));
		principal.add(paneles[2][2]);

		/*
		 * for (int i = 0; i < 3; i++) { for (int j = 0; j < 3; j++) {
		 * principal.add(paneles[i][j]); ESTO ES PARA NO TENER QUE ESTAR ADERIENDO A
		 * PRINCIPAL CADA PANEL LÍNEA POR LÍNEA. } }
		 */

		this.add("Center", principal);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		}
		return false;
	}

}

class MiTextField extends TextField { // Pueden haber distintas clases en un fichero Java, pero solo una será pública
	public MiTextField(String frase, int longitud) {
		super(frase, longitud);
		// *ANOTACION, en un botón, el evento de acción es un click, en un input el
		// evento de acción es el enter.
	}

	public boolean action(Event ev, Object arg) {
		String texto = this.getText();
		this.setText(texto.toUpperCase());
		return true;
	}
}

class MiBoton extends Button {
	TextArea textoArea;

	public MiBoton(String frase, TextArea xx) {
		super(frase);
		textoArea = xx;
	}

	public boolean action(Event ev, Object arg) {
		textoArea.setText(" ");
		return true;
	}

}

class MiCanvas extends Canvas {
	int ejex = 20;
	int ejey = 20;

	public MiCanvas() {
		super();
		resize(75, 75);
		setBackground(Color.yellow); // Aquí puede ir un this, pero ya se entiende que es de la clase en la que estoy
		setForeground(Color.red);
		show();
	}

	public void paint(Graphics g) { // El paint no nos lo inventamos, forma parte del ciclo de vida del Canvas, y se
									// ejecuta el solo.
		g.fillRect(ejex, ejey, 5, 5); // Dibujas un rectangulo
	}

	public boolean mouseDown(Event ev, int x, int y) { // Evento muy concreto (hacer click con el boton izquierdo, no
														// hace falta indicar donde, porque ya estamos en Canvas
														// Los dos enteros son el eje x y el eje y donde hacemos click

		ejex = x;
		ejey = y;
		repaint();
		return true;
	}
}

/*
 * Tenemos que hacer el metodo constructor que esperará recibir el vector de
 * Strings que hemos cargado antes. El metodo constructor de Choice no espera
 * recibir ningún paramentro, y que para meter items dentro del metodo Choice,
 * hay que utilizar el metodo addItems, que logicamente espera recibir un
 * String.
 */
class MiChoice extends Choice {

	TextArea texto;

	public MiChoice(String[] choiceStrings, TextArea tt) {
		super(); // El metodo, como he dicho antes, no espera recibir nada, por tanto el super se
					// puede o no se puede poner.
		for (int i = 0; i < choiceStrings.length; i++) {
			addItem(choiceStrings[i]);
		}
		this.texto = tt;
	}

	public boolean action(Event ev, Object arg) {
		String element = getSelectedItem();
		texto.setText(element);
		return true;
	}
}

class MiLista extends List {
	// El evento de la clase list es doble click, porque un click es solo
	// seleccionar.
	TextArea textArea;

	public MiLista(int filas, boolean m, String[] deportes, TextArea t) {
		super(filas, m);
		for (int i = 0; i < deportes.length; i++) {
			addItem(deportes[i]); // Con poner add ya está bien.
		}
		textArea = t;
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.ACTION_EVENT) {
			textArea.setText("Doble Click");
			return true;
		} else if (ev.id == Event.LIST_SELECT) {
			textArea.setText("Elemento Seleccionado");
			return true;
		} else if (ev.id == Event.LIST_DESELECT) {
			textArea.setText("Elemento Deseleccionado");
			return true;
		}
		return false;
	}
}

class MicheckBoxGroup extends Panel {
	Checkbox checkboxes[];
	TextField texto;

	public MicheckBoxGroup(String colores[]) {
		super();
		setLayout(new GridLayout(colores.length - 1, 1));
		add(new Label(colores[0]));
		checkboxes = new Checkbox[colores.length - 1];
		for (int i = 1; i < colores.length; i++) {
			checkboxes[i - 1] = new Checkbox(colores[i]);
			add(checkboxes[i - 1]);
		}
		texto = new TextField("", 15);
		add(texto);
	}

	public boolean action(Event ev, Object arg) {
		if (ev.target instanceof Checkbox) {
			String mostrar = "";
			for (int i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].getState()) { // Devuelve un valor booleano, por eso no hay que escribir == ...
					mostrar += checkboxes[i].getLabel();
				}
				texto.setText(mostrar);
			}
			return true;
		}
		return false;
	}
}

class MiScrollbar extends Scrollbar {
	TextArea text;

	public MiScrollbar(int orientacion, int posicion, int altura, int inicio, int fin, TextArea tt) {
		super(orientacion, posicion, altura, inicio, fin);
		text = tt;

	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.SCROLL_LINE_UP) {
			text.setText("Linea Up : Posicion" + this.getValue()); // Este getValue nos devuelve la posición de la barra
			return true;
		} else if (ev.id == Event.SCROLL_LINE_DOWN) {
			text.setText("Line Down: Posicion" + this.getValue());
			return true;
		} else if (ev.id == Event.SCROLL_PAGE_UP) {
			text.setText("Page Up: Posicion" + this.getValue());
			return true;
		} else if (ev.id == Event.SCROLL_PAGE_DOWN) {
			text.setText("Page Down: Posicion" + this.getValue());
			return true;
		} else if (ev.id == Event.SCROLL_ABSOLUTE) {
			text.setText("Absolute: Posicion" + this.getValue());
			return true;
		}
		return false;
	}
}
