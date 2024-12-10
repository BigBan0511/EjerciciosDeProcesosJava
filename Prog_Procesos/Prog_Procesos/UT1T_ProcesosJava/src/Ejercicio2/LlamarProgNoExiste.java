package Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LlamarProgNoExiste {

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio2.NoExisto");
		pb.directory(directorio);
		try {
			Process p = pb.start();
			InputStream input = p.getInputStream();
			int c;
			if(p.waitFor() == 0) {
				while((c = input.read()) != -1) {
					System.out.println((char)c);
				}
			}else {
				System.out.println(p.waitFor());
				System.out.println(p.getErrorStream());
				InputStreamReader isr = new InputStreamReader(p.getErrorStream());
				BufferedReader br = new BufferedReader(isr);
				String linea = null;
				while((linea = br.readLine()) != null) {
					System.out.println("ERROR --> " + linea);
				}
				br.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
