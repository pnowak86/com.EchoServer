package com.EchoServer.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer{
    public EchoServer(){

    }

    public static void main(String[] args) throws Exception{
	int port = 4444;
	long SLEEP_TIME = 10000L;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Startet server on port " + port);

        while(true){
            System.out.println("Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            String line = reader.readLine();
            System.out.println("Received " + line);
            printWriter.println("Response from server: " +line);
            printWriter.close();
            Thread.sleep(SLEEP_TIME);
        }

    }
}
