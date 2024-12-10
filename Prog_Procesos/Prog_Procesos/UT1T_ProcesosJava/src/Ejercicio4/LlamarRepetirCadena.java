package Ejercicio4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LlamarRepetirCadena {

	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
		System.out.println("Introduzca una cadena:");
		String cadena = datos.nextLine();
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio4.RepetirCadena",cadena);
		pb.directory(new File(".\\bin"));
		try {
			System.out.println("Con el redirect:");
			pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
			Process p = pb.start();
			
			/*System.out.println("Con el InputStream");
			InputStream is= p.getInputStream();
			int c;
			while((c = is.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println("Valor salida = " + p.waitFor());
			is.close();*/
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
