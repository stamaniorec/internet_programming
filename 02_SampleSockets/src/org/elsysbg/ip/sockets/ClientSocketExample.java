package org.elsysbg.ip.sockets;

import java.util.Scanner;

public class ClientSocketExample {
	public static void main(String[] args) {
		System.out.println("GET / HTTP/1.1");
		System.out.println("Host:www.example.com");
		System.out.println("Connection:close");
		System.out.println("");
		
		final Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			final String line = scanner.nextLine();
			System.out.println(line);
		}
		scanner.close();
	}
}
