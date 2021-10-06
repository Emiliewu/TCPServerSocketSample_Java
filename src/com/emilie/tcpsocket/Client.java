package com.emilie.tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			//1. create client socket, assign server address and server port
			Socket socket = new Socket("localhost", 8888);
			
			//2. get output stream, send message to server
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("Username: Emilie; password:123456");
			pw.flush();
			socket.shutdownOutput();
			
			//3. Get input stream, read server response
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = br.readLine()) != null) {
				System.out.println("Client side, message from server:" + info);
			}
			
			//4. Close
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
