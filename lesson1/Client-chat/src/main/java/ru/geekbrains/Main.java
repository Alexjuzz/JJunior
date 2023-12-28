package ru.geekbrains;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket clientSocket = new Socket(address, 1400);
            Client client = new Client(clientSocket, name);

            InetAddress inetAddress = clientSocket.getInetAddress();
            System.out.println("InetAddress: "  + inetAddress);
            System.out.println("REMOTE IP : " + inetAddress.getHostAddress());
            System.out.println("LOCAL PORT : " + clientSocket.getLocalPort());

            client.listenForMessage();
            client.sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}