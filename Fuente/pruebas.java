import java.util.Scanner;

public class pruebas {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int recogida;
		recogida = sc.nextInt();
		if (recogida == 1) {
			System.out.println("Es correcto");
		} else {
			throw new Exception("No es correcto");
		}
	}

}
