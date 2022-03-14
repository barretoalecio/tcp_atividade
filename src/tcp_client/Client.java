package tcp_client;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
	final static Socket socket = getSocketConnection();

	final static PrintWriter printWriter = getPrintWriter();
	final static InputStreamReader inputStreamReader = getInputStreamReader();
	final static BufferedReader bufferedReader = getBufferedReader();

	final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		run();
	}

	private static void run() throws IOException {

		printWriter.println("Enviando mensagem do Cliente para o servidor");
		printWriter.flush();
		System.out.println("Server: " + bufferedReader.readLine());
	}

	private static Socket getSocketConnection() {
		try {
			return new Socket("localhost", 8080);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static PrintWriter getPrintWriter() {
		try {
			return new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static InputStreamReader getInputStreamReader() {
		try {
			return new InputStreamReader(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static BufferedReader getBufferedReader() {
		return new BufferedReader(inputStreamReader);
	}
}
