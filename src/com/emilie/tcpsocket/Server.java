package com.emilie.tcpsocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			//1. Create ServerSocket, assign port, listen
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//count clients
			int count = 0;
			System.out.println("starting server, please wait for connection");
			//Listen to the client connection
			while(true) {
				//start listen, wait for client connection
				socket = serverSocket.accept();
				//Create new thread
				ServerThread serverThread = new ServerThread(socket);
				//start thread
				serverThread.start();
				count++;
				System.out.println("Number of connections: " + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("Current client IP: " + address.getHostAddress());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
