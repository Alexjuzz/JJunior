package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements ReposServer {

    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void runServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключен новый клиент!");
                ClientManager clientManager = new ClientManager(clientSocket);
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        } catch (IOException e) {
            closeServer();
        }
    }

    private void closeServer() {
        try {
            if (serverSocket != null) serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
