import java.io.*;
import java.net.*;

public class Client implements Runnable {

	// Declaration of variables
	private static Socket clientSocket = null;
	private static PrintStream outputStream = null;
	private static DataInputStream inputStream = null;
	private static BufferedReader inputLine = null;
	private static boolean closed = false;

	public static void main(String[] args) {

		//Default port number is 2222
		int portNumber = 2222;
		String host = "localhost";


		if (args.length < 2) {
			System.out.println("Usage: java Client <host> <portNumber>.\n" + "[ Host: " + host + " ] [ Port Number: " + portNumber + " ]");
		} else {
			host = args[0];
			portNumber = Integer.valueOf(args[1]).intValue();
		}


		//Initialization of the input and output streams
		//Uses the given port and host to open a socket
		try {
			clientSocket = new Socket(host, portNumber);
			inputLine = new BufferedReader(new InputStreamReader(System.in));
			outputStream = new PrintStream(clientSocket.getOutputStream());
			inputStream = new DataInputStream(clientSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		//ensures that the streams are initialized and the sockets are opened
		if (clientSocket != null && outputStream != null && inputStream != null) {
			try {
				new Thread(new Client()).start();
				while (!closed) {
					outputStream.println(inputLine.readLine().trim());
 				}

				outputStream.close();
	 			inputStream.close();
				clientSocket.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	public void run() {
		String responseLine;
		try {
			while ((responseLine = inputStream.readLine()) != null) {
				System.out.println(responseLine);
          	if (responseLine.indexOf("*** Bye") != -1){ 
				break;
			}
		}
			closed = true;
		} catch (IOException e) {
			System.err.println(e);
		}
    }
}