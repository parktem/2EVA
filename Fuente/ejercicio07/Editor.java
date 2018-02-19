package ejercicio07;

import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Editor extends Frame {
	TextArea texto; // Es un input
	MenuBar menuBar;
	FileDialog abrirFichero;
	FileDialog guardarFichero;

	public static void main(String[] args) {
		Editor editor = new Editor();

	}

	public Editor() {
		super("Editor de textos");
		setup();
		pack();
		resize(texto.minimumSize());
		show();

	}

	public void setup() { // Setup = Configuración
		texto = new TextArea(25, 80); // Espera recibir dos enteros, numero de filas y numero de columnas.
		add("Center", texto); // BorderLayout por defecto
		setupMenu();
		abrirFichero = new FileDialog(this, "Abrir Fichero", FileDialog.LOAD); // En el tercer parametro hay que decirle
																				// que tipo de dialogo se abrirá.
		guardarFichero = new FileDialog(this, "Abrir Fichero", FileDialog.SAVE);
	}

	public void setupMenu() {
		menuBar = new MenuBar();
		Menu archivoMenu = new Menu("Archivo");
		archivoMenu.add(new MenuItem("Nuevo"));
		archivoMenu.add(new MenuItem("Abrir"));
		archivoMenu.add(new MenuItem("Guardar"));
		archivoMenu.addSeparator(); // Esto es un separador
		archivoMenu.add(new MenuItem("Salir"));
		menuBar.add(archivoMenu);
		setMenuBar(menuBar);
	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			if (ev.target instanceof MenuItem) {
				if (ev.arg.equals("Salir")) {
					System.exit(0);
					return true;
				} else if (ev.arg.equals("Nuevo")) {
					texto.setText(" ");
					return true;
				} else if (ev.arg.equals("Abrir")) {
					abrirFichero.show();
					String inFile = abrirFichero.getFile();
					// texto.setText(inFile);
					leerFichero(inFile);
					return true;
				} else if (ev.arg.equals("Guardar")) {
					guardarFichero.show();
					String outFile = guardarFichero.getFile();
					guardarFichero(outFile);
					return true;
				} // writeBytes.
			}
		}
		return false;
	}

	public void guardarFichero(String nomFichero) {
		DataOutputStream outStream;
		try {
			outStream = new DataOutputStream(new FileOutputStream(nomFichero));
			String h = texto.getText();
			outStream.writeBytes(h);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void leerFichero(String nomFichero) { // EOF = End of life, señal que indica la finalización del fichero
													// Si el metodo readline es static, se puede acceder a él por el
													// nombre de la clase

		DataInputStream inStream; // Creo Data Input Stream porque es quien contiene la clase readline
		try {

			inStream = new DataInputStream(new FileInputStream(nomFichero)); // Recibe un parametro FileInputStream que
																				// lo
			String nuevo_texto = "";
			String linea;
			while ((linea = inStream.readLine()) != null) {// creo sobre la marcha.
				nuevo_texto += linea + "\n";
			}
			texto.setText(nuevo_texto);
		} catch (FileNotFoundException e) {
			texto.setText("Archivo desconocido");
		} catch (IOException r) {

		} // En un catch se pueden poner dos excepciones

	}

}
