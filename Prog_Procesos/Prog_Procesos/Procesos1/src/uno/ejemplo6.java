package uno;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ejemplo6 {

	public static void main(String[] args) {
		//Variables de entorno y argumentos de comandos
		
		ProcessBuilder pb = new ProcessBuilder("CALC");
		Map entorno = pb.environment();
		System.out.println("Variables de entorno: ");
		System.out.println(entorno);
		
		List l = pb.command();
		Iterator iter = l.iterator();
		System.out.println("\nArgumentos del comando:");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
