package Ejercicio2;

public class LeeNombre {

	public static void main(String[] args) {
		try {
			String nombre = args[0];
			System.out.println(nombre);
			System.exit(0);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.exit(1);
		}
	}

}
