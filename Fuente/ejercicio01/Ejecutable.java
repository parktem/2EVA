package ejercicio01;

//Implementar es inscribir instrucciones
public class Ejecutable {

	public static void main(String[] args) {
		Silla silla1; // Silla no da error porque la clase Silla ha sido generada en el mismo
						// directorio, en el arichivo Silla.java
		Silla silla2;

		// Color
		silla1 = new Silla("Verde", 4, true, 300, 40);
		System.out.println("La silla es de color " + silla1.getColor());

		silla2 = new Silla("Roja", 4, true, 300, 40);
		System.out.println("La silla es de color " + silla2.getColor());

		silla1.setColor("Azul");
		System.out.println("La silla es de color " + silla1.getColor());

		// Patas
		System.out.println("La silla tiene " + silla1.getnumPatas() + " patas");

		silla1.setnumPatas(3);
		System.out.println("La silla tiene " + silla1.getnumPatas() + " patas");

		// Respaldo
		System.out.println("La silla tiene " + silla1.getRespaldo() + " respaldo");

		silla1.setRespaldo(false);
		System.out.println("La silla tiene " + silla1.getRespaldo() + " respaldo");

		// Peso
		System.out.println("La silla tiene " + silla1.getPeso() + " kilos");

		silla1.setPeso(400);
		System.out.println("La silla tiene " + silla1.getPeso() + " kilos");

		// Altura
		System.out.println("La silla tiene " + silla1.getAltura() + " altura");

		silla1.setAltura(60);
		System.out.println("La silla tiene " + silla1.getAltura() + " altura");

		silla1.mostrar();

		silla1.setRespaldo(true);
		silla1.mostrar();
	}

}
