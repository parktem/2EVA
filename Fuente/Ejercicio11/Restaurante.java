package Ejercicio11;

import java.awt.Choice;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class Restaurante extends Frame {
	String[] comidas = { "Desayuno", "Almuerzo", "Cena" };
	String platos[][] = { { "Leche", "Café", "Huevo", "Tostadas", "Mermelada", "Bacon" },
			{ "Paella", "Sopa", "Ensalada", "Filete", "Pescado", "Albóndigas", "Hamburguesa" },
			{ "Tortilla", "Sopa", "Hamburguesa", "Ensalada", "Pollo", "Bocadillo", "Sandwich" } };
	Choice chComidas;
	List actual;
	List ListaPlatos[];
	TextField comanda;

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante();

	}

	public Restaurante() {
		super("Aplicación de restaurante");
		setup();
		pack();
		resize(300, 300); // Esto es para que se adapate a el tamaño del interior del Frame
		show();

	}

	public void setup() {
		this.add("North", new Label("Elige tu comida"));
		chComidas = new Choice();
		for (int i = 0; i < comidas.length; i++) {
			chComidas.add(comidas[i]);
		}
		this.add("West", chComidas);

		ListaPlatos = new List[comidas.length];
		for (int i = 0; i < comidas.length; i++) {
			ListaPlatos[i] = new List(5, true);
			for (int j = 0; j < platos[i].length; j++) {
				ListaPlatos[i].add(platos[i][j]);
			}
		}
		actual = ListaPlatos[0];
		this.add("East", actual);
		comanda = new TextField("", 40);
		this.add("South", comanda);

	}

	public boolean handleEvent(Event ev) {
		if (ev.id == Event.WINDOW_DESTROY) {
			System.exit(0);
			return true;
		} else if (ev.id == Event.ACTION_EVENT) {
			if (ev.target instanceof Choice) {
				remove(actual); // Lo mismo, no se le pone this porque ya estamos en Frame. Remove es lo
								// contrario a add.
				actual = ListaPlatos[chComidas.getSelectedIndex()];
				this.add("East", actual);
				this.show();
				return true;
			}
		} else if ((ev.id == Event.LIST_SELECT) || (ev.id == Event.LIST_DESELECT)) {
			String cargados[] = actual.getSelectedItems();
			String peticion = chComidas.getSelectedItem() + ": ";
			for (int i = 0; i < cargados.length; i++) {
				peticion += cargados[i] + " ";
			}
			comanda.setText(peticion);
			return true;
		}
		return false;
	}

	//// Frame.remove(actual);
	// return true;
	// }

}
