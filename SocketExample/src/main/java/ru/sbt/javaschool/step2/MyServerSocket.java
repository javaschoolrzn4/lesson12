package ru.sbt.javaschool.step2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
	
	private static final int DEFAULT_PORT = 1234;
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
		while (true)
		{
			try
			{
				System.out.println("Waiting for servers on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				Thread thread = new EchoThread(server);
				thread.run();
				
			} catch (IOException e)	{
				e.printStackTrace();
				break;
			}
		}
	}
	
}
