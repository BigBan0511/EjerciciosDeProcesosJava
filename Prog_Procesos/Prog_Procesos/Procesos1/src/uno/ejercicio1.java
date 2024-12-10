package uno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) {
		try {
			Process p = new ProcessBuilder("CMD","/C","DIRE").start();
			InputStream is = p.getInputStream();
			int c;
			while((c = is.read()) != -1) {
				System.out.println("Valor de entrada " + (char)c);
			}
			is.close();

			int valorSalida;
			try {
				valorSalida = p.waitFor();
				System.out.println("Valor de salida " + valorSalida);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			InputStream leerEntrada = p.getErrorStream();
			BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(leerEntrada));
			String linea;
			while((linea = bufferEntrada.readLine()) != null) {
				System.out.println("ERROR " + linea);
			}
		}catch(IOException e) {
			System.out.println("Error");
		}
	}

}
