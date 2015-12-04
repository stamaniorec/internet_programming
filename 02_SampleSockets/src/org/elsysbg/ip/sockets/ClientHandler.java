package org.elsysbg.ip.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
	private final Socket socket;
	private EchoServer echoServer;
	private static final String COMMAND_STOP_SERVER = "stopServer";

	public ClientHandler(EchoServer echoServer, Socket socket) {
		this.echoServer = echoServer;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			final PrintStream out = new PrintStream(socket.getOutputStream());
			final Scanner scanner = new Scanner(socket.getInputStream());
			while(scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				if(COMMAND_STOP_SERVER.equals(line)) {
					echoServer.stopServer();
					break;
				}
				out.println(line);
			}
			scanner.close();
			out.close();
		} catch(IOException e) {
			// TODO check if closed before printing the error
			e.printStackTrace();
		} finally {
			echoServer.onClientStopped(this);
		}
	}
	
	public void stopClient() throws IOException {
		socket.close();
		// TODO add variable closed
	}
	
}
