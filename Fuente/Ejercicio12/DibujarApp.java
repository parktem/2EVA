package Ejercicio12;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class DibujarApp extends Frame {
	MiCanvas canvas;

	public static void main(String[] args) {
		DibujarApp dibujarApp = new DibujarApp();
	}

	public DibujarApp() {
		super("Dibujando en el Frame");
		setup();
		pack();
		resize(400, 400);
		show();

	}

	public void setup() {
		setupMenuBar();
		canvas = new MiCanvas(Dospuntos.LINEA);
		add("Center", canvas);
	}

	public void setupMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Fichero");
		menu.add(new MenuItem("Nuevo"));
		menu.addSeparator();
		menu.add(new MenuItem("Salir"));
		menuBar.add(menu);

		Menu menu2 = new Menu("Dibujar");
		menu2.add(new MenuItem("Linea"));
		menu2.add(new MenuItem("Ovalo"));
		menu2.add(new MenuItem("Rectángulo"));
		menuBar.add(menu2);

		setMenuBar(menuBar);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			if (ev.arg.equals("Salir")) {
				System.exit(0);
				return true;
			} else if (ev.arg.equals("Linea")) {
				canvas.setTipo(Dospuntos.LINEA);
				return true;
			} else if (ev.arg.equals("Ovalo")) {
				canvas.setTipo(Dospuntos.OVALO);
				return true;
			} else if (ev.arg.equals("Rectángulo")) {
				canvas.setTipo(Dospuntos.RECTANGULO);
				return true;
			} else if (ev.arg.equals("Nuevo")) {
				canvas.getLista().clear();
				canvas.repaint();
				return true;
			}
		}
		return false;
	}
}
