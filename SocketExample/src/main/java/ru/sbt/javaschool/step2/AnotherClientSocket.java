package ru.sbt.javaschool.step2;

import ru.sbt.javaschool.entity.Fallback;
import ru.sbt.javaschool.entity.Parameter;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AnotherClientSocket {
	
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
		Fallback fallback = new Fallback();
		
		fallback.setParameters( new ArrayList<Parameter>());
		
		return fallback;
	}
}
