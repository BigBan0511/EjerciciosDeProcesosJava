package uno;

import java.io.IOException;

public class ejemplo9 {

	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("CMD","/C","DIR");
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		Process p = pb.start();

	}

}
