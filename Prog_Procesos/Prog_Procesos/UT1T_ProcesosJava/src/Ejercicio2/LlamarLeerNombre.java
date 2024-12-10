package Ejercicio2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LlamarLeerNombre {

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio2.LeeNombre", "PEPE");
		pb.directory(directorio);
		try {
			Process p = pb.start();
			int c;
			InputStream input = p.getInputStream();
			while((c = input.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println(p.waitFor());
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
