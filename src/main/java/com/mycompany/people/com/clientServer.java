/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.people.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Jovany
 */
public class clientServer {
     private static final String HOST = "localhost"; // Dirección del servidor
    private static final int PORT = 12345;          // Puerto del servidor

    public static void main(String[] args) {
        try (
                
                
                
                
                
            Socket socket = new Socket(HOST, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))
                
                
                
        ) {
            System.out.println("Conectado al servidor.");

            // Hilo para escuchar mensajes del servidor
            new Thread(() -> {
                try {
                    String mensaje;
                    while ((mensaje = in.readLine()) != null) {
                        System.out.println(">> " + mensaje);
                    }
                } catch (IOException e) {
                    System.out.println("Desconectado del servidor.");
                }
            }).start();

            // Leer del teclado y mandar al servidor
            String texto;
            while ((texto = teclado.readLine()) != null) {
                out.println(texto);
            }

        } catch (IOException e) {
            System.out.println("No se pudo conectar al servidor.");
        }
    }
}
