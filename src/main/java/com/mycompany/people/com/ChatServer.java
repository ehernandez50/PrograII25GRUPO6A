/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.people.com;
  import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Jovany
 */
public class ChatServer {

  

    private static final int PORT = 12345;
    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        
        
        
        System.out.println("Servidor de chat iniciado...");
        try (
            ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                ClientHandler handler = new ClientHandler(socket);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    static void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            
            
            
            
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Conectado al servidor. Escribe tu mensaje:");

                String message;
                while ((message = in.readLine()) != null) {
                    
                    System.out.println("Mensaje recibido: " + message);
                    ChatServer.broadcast(message, this);
                }
            } catch (IOException e) {
                System.out.println("Cliente desconectado.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {}
                ChatServer.removeClient(this);
            }
        }

        void sendMessage(String message) {
            out.println(message);
        }
    }
}


