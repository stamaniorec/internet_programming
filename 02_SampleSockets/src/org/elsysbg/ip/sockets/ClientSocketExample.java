package org.elsysbg.ip.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocketExample {
	public static void main(String[] args) throws UnknownHostException, IOException {
		final Socket socket = new Socket("www.example.com", 80);
		final PrintStream out = new PrintStream(socket.getOutputStream());
		out.println("GET / HTTP/1.1"); // or /index.html
		out.println("Host:www.example.com");
		out.println("Connection:close");
		out.println("");
		
		final Scanner scanner = new Scanner(socket.getInputStream());
		while(scanner.hasNextLine()) {
			final String line = scanner.nextLine();
			System.out.println(line);
		}
		scanner.close();
		out.close();
		socket.close();
	}
}
