package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(1400);
            Server server = new Server(socket);
            server.runServer();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}