package ru.sbt.javaschool.step1;

import ru.sbt.javaschool.entity.Fallback;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
				
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
				//ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
				Fallback m = (Fallback) in.readObject();
				System.out.println(m);
			} catch (IOException e)	{
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
}
