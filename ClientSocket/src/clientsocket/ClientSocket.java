/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class ClientSocket {
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
       
        if(args.length != 2) 
           
            System.err.println("Bad bad very bad, Server and port, my friend");
        String server = args[0];
        int portNumber = Integer.parseInt(args[1]);
        System.out.println("Trying to connect ...");
        
            Socket client = new Socket(server,portNumber);
                      
            
        
            System.out.println("I did it");
            
           (new Thread(new Operatie(client,"citire"))).start();
            (new Thread(new Operatie(client,"scriere"))).start();
        
    
        
        
        
    }
    
}
