package ru.sbt.javaschool.step2;

import ru.sbt.javaschool.entity.Fallback;

import java.io.*;
import java.net.Socket;

public class EchoThread extends Thread {
	
	protected Socket socket;
	
	public EchoThread(Socket clientSocket) {
		this.socket = clientSocket;
	}
	
	public void run() {
		InputStream inp = null;
		ObjectInputStream brinp = null;
		Fallback line = null;
		try {
			inp = socket.getInputStream();
			brinp = new ObjectInputStream(inp);
			line = (Fallback)brinp.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(line);
		
	}
	
}
