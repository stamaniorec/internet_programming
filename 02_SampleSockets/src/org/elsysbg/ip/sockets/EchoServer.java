package org.elsysbg.ip.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EchoServer {
	private final int port;
	private boolean running;
	private List<ClientHandler> clients = Collections.synchronizedList(
			new LinkedList<ClientHandler>()
	);
	private ServerSocket serverSocket;
	
	public EchoServer(int port) {
		this.port = port;
	}
	
	public void startServer() throws IOException {
		setRunning();
		serverSocket = new ServerSocket(port);
		while(isRunning()) {
			final Socket socket = serverSocket.accept();
			final ClientHandler client = new ClientHandler(this, socket);
			clients.add(client);
			new Thread(client).start();
		}
		serverSocket.close();
	}
	
	private synchronized void setRunning() {
		if(isRunning()) {
			throw new IllegalStateException("Already running");
		}
		running = true;
	}
	
	private synchronized boolean isRunning() {
		return running;
	}

	public synchronized void stopServer() throws IOException {
		if(!running) {
			throw new IllegalStateException("Not running");
		}
		running = false;
		serverSocket.close();
		serverSocket = null;
		for(ClientHandler next : clients) {
			next.stopClient();
		}
	}

	public synchronized void onClientStopped(ClientHandler clientHandler) {
		clients.remove(clientHandler);
	}
}
