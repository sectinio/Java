/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

/**
 *
 * @author Administrator
 */
import java.net.*;
import java.io.*;
 
public class EchoServer {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 2) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[1]);
        String hostName = args[0];
         
        try (
            ServerSocket serverSocket =
                new ServerSocket(Integer.parseInt(args[1]));
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
                
                 Socket echoSocket = new Socket(hostName, portNumber);
           
             PrintWriter out1 =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in1 =
                new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                
                             
          
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in)
        )) {
            String userInput;
            String receivedInput;
            while ((userInput = stdIn.readLine()) != null || (receivedInput = in1.readLine()) != null ){
                out.println(userInput);
                System.out.println(in1.readLine());
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}