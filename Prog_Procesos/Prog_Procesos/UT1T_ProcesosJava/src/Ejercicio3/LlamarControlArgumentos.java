package Ejercicio3;

import java.io.File;
import java.io.IOException;

public class LlamarControlArgumentos {

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio3.ControlaArgumentos", "2");
		pb.directory(directorio);
		try {
			Process p = pb.start();
			System.out.println("Error log: " + p.waitFor());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
