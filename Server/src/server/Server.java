/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ericklopes
 */
public class Server {

    private static final int porta = 12345;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Server Socket criado...");
        while(true) {
            System.out.println("Aguardando conexões...");
            Socket socket = serverSocket.accept();
            System.out.println("Conectou ...");
            new ServerSocketThread(socket).start();
        }
    }
    
}
