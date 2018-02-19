package ejercicio08;

import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;

public class FrameApp extends Frame {
	MenuBar porDefecto;
	MenuBar alternativo;
	String tituloInicial;
	int cursores[] = { CROSSHAIR_CURSOR, DEFAULT_CURSOR, E_RESIZE_CURSOR, HAND_CURSOR, MOVE_CURSOR, NE_RESIZE_CURSOR,
			NW_RESIZE_CURSOR, N_RESIZE_CURSOR, SE_RESIZE_CURSOR, TEXT_CURSOR, WAIT_CURSOR }; // Los cursores se definen
																								// como enteros.
	int posCursor = 0;

	Color colores[] = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray,
			Color.magenta, Color.orange, Color.pink, Color.red };
	int posColor = 0;
	Color fuentecolores[] = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green,
			Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red };
	int posFuenteColor = 0;
	String fuentes[] = { "Helvetica", "TimesRoman", "Courier", "Dialog", "DialogInput", "ZapfDingbats" };
	int posLetra = 0;

	public static void main(String[] args) {
		FrameApp frameApp = new FrameApp();

	}

	public FrameApp() {
		super("Trabajando con Frame");
		tituloInicial = this.getTitle(); // No es necesario poner this, puto pesado, estas en el frame.
		setup();
		pack();
		resize(400, 400);
		show();
	}

	public void setup() { // Setup = Configuración
		setupMenus();
		setupPaneles();
	}

	public void setupPaneles() {
		Panel principal = new Panel();
		principal.setLayout(new GridLayout(4, 1)); // 4 filas y 1 columna.tu lo que quieres es pelea puta
		principal.add(new Label("Cambiar las caracteristicas de la ventana", Label.CENTER));

		Panel panel1 = new Panel();
		Panel panel2 = new Panel();
		panel1.add(new Button("Titulo"));
		panel1.add(new Button("MenuBar"));
		panel1.add(new Button("Resizable"));
		principal.add(panel1);
		principal.add(new Label("Salidas en la ventana", Label.CENTER)); // Cursor, background, fontground, font
		panel2.add(new Button("Cursor"));
		panel2.add(new Button("Background"));
		panel2.add(new Button("Foreground"));
		panel2.add(new Button("Font"));
		principal.add(panel2);
		add("South", principal);

	}

	public void paint(Graphics g) { // Le llamas como quieras a graphics porque es local
		g.drawString("Modificando carateristicas", 120, 150);
	}

	public void setupMenus() {
		porDefecto = new MenuBar();
		Menu fileMenu = new Menu("File");
		fileMenu.add(new MenuItem("Exit"));
		porDefecto.add(fileMenu);
		this.setMenuBar(porDefecto);

		alternativo = new MenuBar();
		Menu archivoMenu = new Menu("Archivo");
		archivoMenu.add(new MenuItem("Salir"));
		alternativo.add(archivoMenu);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) { // Hacer click en un boton es hacer click es un evento de accion.
			if (ev.target instanceof Button) {
				if (ev.arg.equals("Exit")) {
					System.exit(0);
					return true;
				} else if (ev.arg.equals("Titulo")) {
					if (tituloInicial.equals(getTitle())) {
						setTitle("Titulo Alternativo");
					} else {
						setTitle(tituloInicial);
					}
					return true;
				} else if (ev.arg.equals("MenuBar")) {
					if (porDefecto.equals(getMenuBar())) {
						setMenuBar(alternativo);
					} else {
						setMenuBar(porDefecto);
					}

					return true;
				} else if (ev.arg.equals("Resizable")) { // Devuelve un booleano
					setResizable(!isResizable());
					return true;
				} else if (ev.arg.equals("Cursor")) {
					setCursor(cursores[posCursor]);
					posCursor++;
					if (posCursor == cursores.length - 1) {
						posCursor = 0;
					}
					return true;

				} else if (ev.arg.equals("Background")) {
					setBackground(colores[posColor]);
					posColor++;
					if (posColor == colores.length - 1) {
						posColor = 0;
					}
					return true;
				} else if (ev.arg.equals("Foreground")) {
					setForeground(fuentecolores[posFuenteColor]);
					posFuenteColor++;
					if (posFuenteColor == fuentecolores.length - 1) {
						posFuenteColor = 0;
					}
					return true;
				} else if (ev.arg.equals("Font")) {
					setFont(new Font(fuentes[posLetra], Font.PLAIN, 10));
					if (posLetra == fuentes.length - 1) {
						posLetra = 0;
					}
					return true;
				}
			}
		}
		return false;
	}

}
