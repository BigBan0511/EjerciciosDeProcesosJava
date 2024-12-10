package uno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejemplo3 {

	public static void main(String[] args) {
		try {
			Process p = new ProcessBuilder("CMD","/C","DIRE").start();
			
			//Capturamos el stream de salida
			InputStream i = p.getInputStream();
			
			//Mostramos por pantalla caracter a caracter con read()
			int c;
			while ((c = i.read())!= -1) {
				System.out.print((char)c);
			}
			i.close();
			
			//Comprobacion error 0 bien 1 mal
			int exitVal;
			try {
				//Esperamos a que el subproceso p finalice
				//Recoge la devolucion de System.exit()
				exitVal = p.waitFor();
				System.out.println("\nValor de salida " + exitVal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			InputStream errorInput = p.getErrorStream();
			BufferedReader bufferInput = new BufferedReader(new InputStreamReader(errorInput));
			String linea = null;
			while((linea = bufferInput.readLine()) != null) {
				System.out.println("ERROR " + linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
