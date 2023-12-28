package ru.geekbrains;

import com.mysql.cj.xdevapi.Client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;

public class ClientManager implements Runnable {
    private Socket socket;
    private String name;
    private String uniqueID;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ClientManager(Socket clientsocket) {
        try {
            this.socket = clientsocket;
            uniqueID = UUID.randomUUID().toString();

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            name = bufferedReader.readLine();

            ClientManagerSingleton.getClients().add(this);
            System.out.println(name + " присоединился к чату.");
            broadcastMessage("Server : " + name + " подключиля к чату.");

        } catch (IOException e) {
            closeEverything(clientsocket, bufferedReader, bufferedWriter);
        }

    }

    /**
     * Закрыть все соединения с клиенстким сокетом
     *
     * @param clietnsocket   клиенсткий сокет
     * @param bufferedReader - буфер чтения
     * @param bufferedWriter - Буфер записи
     */
    private void closeEverything(Socket clietnsocket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        ClientManagerSingleton.getClients().remove(this);
        System.out.println(name + " вышел из чата");
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                if(messageFromClient.equals("exit")){
                    closeEverything(socket,bufferedReader,bufferedWriter);
                }
                System.out.println(messageFromClient);
                if(isPrivateMessage(messageFromClient)){
                    String nameValue = messageFromClient.split(" ",3)[1].substring(1);
                    privateMessage(messageFromClient,nameValue);

                }else {
                    broadcastMessage(messageFromClient);
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
    private void privateMessage(String messageFromName,String name){
        for(ClientManager client : ClientManagerSingleton.getClients()){
            try {

                if(name.equals(client.name)){
                    client.bufferedWriter.write(messageFromName);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void broadcastMessage(String messageFromClient) {
        for (ClientManager client : ClientManagerSingleton.getClients()) {
            try {

                if (!client.uniqueID.equals(uniqueID)) {
                    client.bufferedWriter.write(messageFromClient);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }

            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    private boolean isPrivateMessage(String messageFromClient) {
        return messageFromClient.charAt(name.length()+2)=='@';
    }


}
