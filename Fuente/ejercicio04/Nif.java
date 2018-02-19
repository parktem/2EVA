package ejercicio04;

public class Nif {

	int dni;
	char letra;
	static char tabla[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
			'H', 'L', 'C', 'K', 'E' };

	public Nif(int dni, char l) throws Exception {
		if ((dni < 10000000) || (dni > 99999999))
			throw new Exception("El DNI no es correcto"); // throw es para lanzar una excepción
		this.dni = dni;
		letra = l;
		if (letra != tabla[dni % 23]) {
			throw new Exception("La letra no es correcta");
		} else {
			System.out.println("Letra correcta");
		}
	}

	public Nif(int dni) throws Exception {
		if ((dni < 10000000) || (dni > 99999999))
			throw new Exception("El DNI no es correcto"); // throw es para lanzar una excepción

		letra = tabla[dni % 23];
	}

	public Nif(char l) {
		letra = l;
		System.out.println(letra);
	}

	public void Mostrar() {
		System.out.println("La letra de su dni es " + letra);
	}
}
