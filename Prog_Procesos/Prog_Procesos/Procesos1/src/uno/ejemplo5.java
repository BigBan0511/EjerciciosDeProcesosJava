package uno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ejemplo5 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD", "DATE");
		try {
			Process p = pb.start();
			OutputStream os = p.getOutputStream();
			os.write("date 01-12-22/n".getBytes());
			os.flush();
			os.close();

			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String linea = "";
			while((linea = br.readLine()) != null) {
				System.out.println("Salida --> " + linea);
			}
			br.close();

			InputStream ise = p.getErrorStream();
			InputStreamReader isre = new InputStreamReader(ise);
			BufferedReader bre = new BufferedReader(isre);
			String lineaE = "";
			while((linea = bre.readLine()) != null) {
				System.out.println("ERROR --> " + lineaE);
			}
			bre.close();
			
			int exitVal = p.waitFor();
			System.out.println("VALOR DE SALIDA --> " + exitVal);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
