import java.awt.Frame;
import java.awt.Panel;
import java.util.Scanner;

import javax.swing.JTextField;

public class pruebaventana extends Frame {

	public static void main(String[] args) {
		pruebaventana pruebaventana = new pruebaventana();
		Scanner sc = new Scanner(System.in);
		int num;

	}

	public pruebaventana() {
		super("Ventana de prueba");
		JTextField sendtext;
		Panel panel = new Panel();
		sendtext = new JTextField();

		add("North", sendtext);
		this.pack();
		resize(300, 300);
		show();
		int var = Integer.parseInt(sendtext.getText());
		System.out.println(var);
	}

}
