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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Operatie implements Runnable {
    
    volatile PrintWriter out; 
    volatile BufferedReader ina;
    volatile BufferedReader console;
    private String op;
    volatile String intrare;
    volatile String iesire;
    Operatie (Socket a, String operatie) throws IOException 
    {op=operatie;
    out = new PrintWriter(a.getOutputStream(),true);
    ina = new BufferedReader(new InputStreamReader(a.getInputStream()));
    console = new BufferedReader (new InputStreamReader(System.in));
    };
    public void run() 
    {
        if(op=="citire")
        {
            System.out.println("Sunt in threadul de citire");
            try {
                while((intrare = ina.readLine()) != null )
                {
                    System.out.println("Tu: " + intrare);
                    }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(op=="scriere")
        {
            System.out.println("Sunt in threadul de iesire");
            try {
                while((iesire = console.readLine()) != null )
                {
                    
                    
                out.println(iesire);}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
