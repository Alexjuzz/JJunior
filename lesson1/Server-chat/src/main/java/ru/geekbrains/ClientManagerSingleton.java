package ru.geekbrains;

import java.util.ArrayList;

public class ClientManagerSingleton {
    private static ArrayList<ClientManager> clients;

    private ClientManagerSingleton() {

    }

    public static ArrayList<ClientManager> getClients() {
        if (clients == null) {
            clients = new ArrayList<ClientManager>();
        }
        return clients;
    }
}