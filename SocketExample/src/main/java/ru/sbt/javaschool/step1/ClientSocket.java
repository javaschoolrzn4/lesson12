package ru.sbt.javaschool.step1;

import ru.sbt.javaschool.entity.Fallback;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
	
	private static final String DEFAULT_HOST = "localhost";
	private static final int DEFAULT_PORT = 1234;
	
	public static void main(String[] args) throws IOException {
		Socket s = new Socket(DEFAULT_HOST, DEFAULT_PORT);
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
		Fallback m = getFallbackObject();
		out.writeObject(m);
		out.flush();
		System.out.println("Sent obj");
		s.close();
	}
	
	private static Fallback getFallbackObject() {
		return new Fallback();
	}
}
