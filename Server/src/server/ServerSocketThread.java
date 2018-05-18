/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ericklopes
 */
public class ServerSocketThread extends Thread{
    private final Socket socket;
    
    public ServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try{
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Float tempC = in.readFloat();
            Float tempF =  (float) (tempC * 1.8 + 32);
            out.writeFloat(tempF);
            out.flush();
            out.close();
            socket.close();
            
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
    
    
    
}
