package Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LlamarSumarIntervalo {

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio1.SumarIntervalo", "2", "5");
		pb.directory(directorio);
		try {
			Process p = pb.start();
			InputStream is = p.getInputStream();
			int c;
			while((c = is.read()) != -1) {
				System.out.print((char)c);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
