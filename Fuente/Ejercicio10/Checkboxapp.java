package Ejercicio10;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Checkboxapp extends Frame {
	CheckBoxPanel chbPanel;
	CheckBoxPanelGroup chbGPanel;

	public static void main(String[] args) {
		Checkboxapp checkboxapp = new Checkboxapp();
	}

	public Checkboxapp() {
		super("Aplicacion de Checkboxes");
		setup();
		pack();
		resize(minimumSize()); // Esto es para que se adapate a el tamaño del interior del Frame
		show();

	}

	public void setup() {
		String[] deportes = { "Futbol", "Natación", "Baloncesto", "Tenis", "Ajedrez" };
		String[] edades = { "Menos de 10", "Entre 10 y 30", "Entre 30 y 60", "Más de 60" };
		chbPanel = new CheckBoxPanel("¿Qué deportes te gustan?", deportes);
		chbGPanel = new CheckBoxPanelGroup("¿Qué edad tienes?", edades);

		this.add("West", chbPanel);
		this.add("East", chbGPanel);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		}
		return false;
	}

}

class CheckBoxPanel extends Panel {
	Checkbox checkboxes[];

	public CheckBoxPanel(String pregunta, String[] opciones) {
		super();
		this.setLayout(new GridLayout(opciones.length + 1, 1));
		add(new Label(pregunta));
		checkboxes = new Checkbox[opciones.length - 1];
		for (int i = 0; i < opciones.length - 1; i++) {
			checkboxes[i] = new Checkbox(opciones[i]);
			add(checkboxes[i]);
		}

	}
}

class CheckBoxPanelGroup extends CheckBoxPanel { // Subclase de una subclase que hemos creado nosotrsos

	public CheckBoxPanelGroup(String pregunta, String[] opciones) {
		super(pregunta, opciones);
		CheckboxGroup grupo = new CheckboxGroup();
		for (int i = 0; i < checkboxes.length; i++) {
			checkboxes[i].setCheckboxGroup(grupo);
		}
	}
}
