package edu.escuelaing.arem.AppBrowser;

import java.io.*;
import java.net.*;

/**
 * This class reads and stores the data from a URL.
 * @author Miguel Angel Rodriguez Siachoque
 * @author Luis Daniel Benavides Navarro
 */
public class URLBrowser 
{
    /**
     * This method reads and stores the information from the URL.
     * @param args URL to read the data.
     * @throws Exception Exception in the case of not finding the file.
     */
    public static void main(String[] args) throws Exception 
    {
        URL site = new URL("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        //URL site = new URL(args[0]);
        boolean answer = readURL(site);
        System.out.println("El proceso termino: " + answer + ".");
    }
    /**
     * This method reads URL.
     * @param site URL to read the data.
     * @return URL found.
     */
    public static boolean readURL (URL site)
    {
        boolean filefound = false;
        String fileURL = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                fileURL += inputLine;
            }
            writeURL(fileURL);
            filefound = true;
        } catch (IOException x) {
            System.err.println(x);
        }
        return filefound;
    }
    /**
     * This method dile URL.
     * @param fileURL Data of URL.
     * @return Confirm that the file has been created.
     */
    public static boolean writeURL (String fileURL) 
    {
        boolean fileCreate = false;
        try {
            try (PrintWriter writer = new PrintWriter("./resultado.html", "UTF-8")) {
                writer.println(fileURL);
            }
            fileCreate = true;
        } catch (Exception e) {
        }
        return fileCreate;
    }
}