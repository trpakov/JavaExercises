import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DataServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(2002);
		while (true) {
			Socket socket = serverSocket.accept();
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
			outputStreamWriter.write(new Date() + "\n");
			outputStreamWriter.close();
			socket.close();
		}
	}
}
