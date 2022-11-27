package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8095;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out =
                             new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
                     BufferedReader in =
                             new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("Write your name");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

                    System.out.println("Are you child? (yes/no)");
                    while (true) {
                        final String answer = in.readLine();
                        if (answer.equals("yes")) {
                            out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                            break;
                        } else if (answer.equals("no")) {
                            out.println(String.format("Welcome to the adult zone,%s! Have a good rest, or a good working day!", name));
                            break;
                        }
                    }

                    System.out.println("How old are you?");
                    final String age = in.readLine();
                    out.println(String.format("%s is greatest age for life", age));

                    System.out.println("Where are you born?");
                    final String city = in.readLine();
                    out.println(String.format("%s is wonderful city in the World", city));
                }
            }
        }
    }
}