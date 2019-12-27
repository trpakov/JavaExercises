import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServerClient {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 2002);
		BufferedReader inBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("The date on the server is: " + inBufferedReader.readLine());
		socket.close();

	}

}
