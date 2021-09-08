package edu.escuelaing.arem.HttpServer;

import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * This class runs an http server for datagram execution.
 * @author Miguel Angel Rodriguez Siachoque
 * @author Luis Daniel Benavides Navarro
 */
public class HttpServer 
{
    private static final HttpServer _instance = new HttpServer();
    /**
     * This is the constructor method of the class.
     */
    private HttpServer ()
    {   
    }
    /**
     * This method generates the server singleton.
     * @return Singleton.
     */
    private static HttpServer getInstance () 
    {
        return _instance;
    }
    /**
     * Main method that gives the instruction to start the HTTP server.
     * @param args Item to be displayed by the server.
     * @throws IOException Exception of a server malfunction.
     */
    public static void main (String[] args) throws IOException 
    {
        HttpServer.getInstance().startServer(args);
    }
    /**
     * This method starts the HTTP server.
     * @param args Item to be displayed by the server.
     * @throws IOException Exception of a server malfunction.
     */
    public void startServer (String[] args) throws IOException 
    {
        int port = 35000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(1);
        }
        Socket clientSocket = null;
        boolean running = true;
        while (running) {
            try {
                System.out.println("Listo para recibir en puerto: " + port);
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            proccessRequest(clientSocket);
        }
        serverSocket.close();
    }
    /**
     * This method perform the server request process and displays its header, received and request.
     * @param clientSocket Client that wants to run the HTTP server.
     * @throws IOException Exception in the malfunction of some request.
     */
    public void proccessRequest (Socket clientSocket) throws IOException
    {
        BufferedReader in;
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            String method = "";
            String path = "";
            String version = "";
            List<String> headers = new ArrayList<String>();
            while ((inputLine = in.readLine()) != null) {
                if (method.isEmpty()){
                    String[] requestStrings = inputLine.split(" ");
                    method = requestStrings[0];
                    path = requestStrings[1];
                    version = requestStrings[2];
                    System.out.println("Request: " + method + " " + path + " " + version);
                }
                else {
                    System.out.println("Header: " + inputLine);
                    headers.add(inputLine);
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            String responseMsg = createTextResponse(path);
            out.println(responseMsg);
        }
        in.close();
        clientSocket.close();
    }
    /**
     * This method is in charge of reading the content of the files for the HTTP server.
     * @param path The file path to identify and read.
     * @return File content.
     */
    public String createTextResponse (String path)
    {
        Path file = Paths.get("./TestHttpServer" + path);
        Charset charset = Charset.forName("UTF-8");
        String outmsg = "";
        try (BufferedReader reader = Files.newBufferedReader(file,charset)) {
            String line = null;
            while ((line = reader.readLine())!= null) {
                System.out.println(line);
                outmsg = outmsg + "\r\n" + line;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return "HTTP/1.1 200 OK\r\n" + "Content-Type_ text/html\r\n" + "\r\n" + outmsg;
    }
    /**
     * This method defines the type of the file.
     * @param path The file path to identify and read.
     * @return Type of file.
     */
    public String contentType(String path) 
    {
        String mimeType = null;

        if (path.endsWith(".html")) {
            mimeType = "text/html";
        } else if (path.endsWith(".css")) {
            mimeType = "text/css";
        } else if (path.endsWith(".js")) {
            mimeType = "text/javascript";
        } else if (path.endsWith(".svg")) {
            mimeType = "image/jpeg";
        } else if (path.endsWith(".gif")) {
            mimeType = "image/gif";
        } else if (path.endsWith(".jpg")) {
            mimeType = "image/jpg";
        } else if (path.endsWith(".png")) {
            mimeType = "image/png";
        }
        return mimeType;
    }
}