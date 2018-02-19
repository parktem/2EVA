package ejercicio03;

public class ejecutable {

	public static void main(String[] args) {
		perro perro1;
		gallo gallo1;
		gallo1 = new gallo(1, 20, "16/5/1998", 20);
		perro1 = new perro(1, 20, "16/5/1998", "Caniche");
		perro1.setPeso(2);
		perro1.habla();
		gallo1.habla();

	}

}
