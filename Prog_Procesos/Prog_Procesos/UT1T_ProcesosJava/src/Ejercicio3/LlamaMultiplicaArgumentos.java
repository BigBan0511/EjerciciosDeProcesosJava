package Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LlamaMultiplicaArgumentos {

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio3.MultiplicaArgumentos","2","2","2");
		pb.directory(directorio);
		try {
			Process p = pb.start();
			InputStream input = p.getInputStream();
			int c;
			while((c = input.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println("LOG: " + p.waitFor());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
