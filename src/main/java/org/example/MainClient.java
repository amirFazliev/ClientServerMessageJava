package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8095;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out =
                     new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in =
                     new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();
            out.println(text);
            String name = in.readLine();
            System.out.println(name);

            while (true) {
                String answer = scanner.nextLine();
                if (answer.equals("yes")) {
                    out.println(answer);
                    break;
                } else if (answer.equals("no")) {
                    out.println(answer);
                    break;
                } else {
                    System.out.println("Try again");
                }
            }
            String answerServer = in.readLine();
            System.out.println(answerServer);

            String ageAnswer = scanner.nextLine();
            out.println(ageAnswer);
            String age = in.readLine();
            System.out.println(age);

            String cityAnswer = scanner.nextLine();
            out.println(cityAnswer);
            String city = in.readLine();
            System.out.println(city);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
