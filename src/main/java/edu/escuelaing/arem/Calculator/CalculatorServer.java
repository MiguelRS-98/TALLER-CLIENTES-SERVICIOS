package edu.escuelaing.arem.Calculator;

import java.io.*;
import java.net.*;

/**
 * This class your task is to square the numbers provided by the client.
 * @author Miguel Angel Rodriguez Siachoque
 * @author Luis Daniel Benavides Navarro
 */
public class CalculatorServer 
{
    /**
     * Main method that gets input from client and prints results square numbers.
     * @param args input from client.
     * @throws IOException Exception in the case of not finding the port.
     */
    public static void main(String[] args) throws Exception 
    {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir en puerto: 35000.");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) !=null) {
            System.out.println("Mensaje recibido: " + inputLine);
            out.println(isBye(inputLine));
            if (isBye(inputLine).equals("Respuesta de servidor: Bye.")) {
                break;
            }
        }
        System.out.println("Cerrando el servidor...");
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    /**
     * This method is to confirm if the client wants to shut down the server or not.
     * @param inputLine input from client.
     * @return Server response.
     */
    public static String isBye (String inputLine) 
    {
        if (inputLine.equals("Bye.")) {
            return "Respuesta de servidor: " + inputLine;
        }
        else {
            return squareNum(inputLine);
        }
    }
    /**
     * This method squares the numbers.
     * @param inputLine input from client.
     * @return calculation of square number.
     */
    public static String squareNum (String inputLine) 
    {
        double input = Double.parseDouble(inputLine);
        double input2 = input * input;
        return "El cuadrado de " + inputLine +": " + input2 + ".";
    }
}