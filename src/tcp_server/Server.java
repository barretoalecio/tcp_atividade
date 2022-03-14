package tcp_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	final static ServerSocket serverSocket = getServerSocket(8080);
	final static Socket socket = getSocket();

	final static PrintWriter printWriter = getPrintWriter();
	final static InputStreamReader inputStreamReader = getInputStreamReader();
	final static BufferedReader bufferedReader = getBufferedReader();

	final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		run();
	}

	private static void run() throws IOException {
		System.out.println("Cliente Conectado");

		printWriter.println("Enviando mensagem do Servidor para o cliente");
		printWriter.flush();
		System.out.println("Client: " + bufferedReader.readLine());
	}

	private static ServerSocket getServerSocket(int port) {
		try {
			return new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Socket getSocket() {
		try {
			return serverSocket.accept();
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
