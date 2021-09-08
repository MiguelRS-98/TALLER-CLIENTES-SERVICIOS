package edu.escuelaing.arem.URLComponents;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class gets a URL and shows the methods of it.
 * @author Miguel Angel Rodriguez Siachoque
 * @author Luis Daniel Benavides Navarro
 */
public class URLComponents 
{
    /**
     * This method prints URL the protocols.
     * @param args URL to read the protocols.
     * @throws MalformedURLException Misconfigured URL exception.
     */
    public static void main(String[] args) throws MalformedURLException 
    {
        URL personalSite = new URL ("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        //URL personalSite = new URL(args[0]);
        System.out.println("protocol:" + getProtocol(personalSite));
        System.out.println("authority:" + getAuthority(personalSite));
        System.out.println("host:" + getHost(personalSite));
        System.out.println("port:" + getPort(personalSite));
        System.out.println("path:" + getPath(personalSite));
        System.out.println("query:" + getQuery(personalSite));
        System.out.println("file:" + getFile(personalSite));
        System.out.println("ref:" + getRef(personalSite));
    }
    /**
     * This method gets the URL protocols
     * @param site URL to read the protocols.
     * @return Protocol URL.
     */
    public static String getProtocol (URL site) 
    {
        return site.getProtocol();
    }
    /**
     * This method gets the URL Authority.
     * @param site URL to read the protocols.
     * @return Authority URL.
     */
    public static String getAuthority (URL site) 
    {
        return site.getAuthority();
    }
    /**
     * This method gets the URL Host.
     * @param site URL to read the protocols.
     * @return Host URL.
     */
    public static String getHost (URL site) 
    {
        return site.getHost();
    }
    /**
     * This method gets the URL Port.
     * @param site URL to read the protocols.
     * @return Port URL.
     */
    public static String getPort (URL site) 
    {
        return site.getPort()+"";
    }
    /**
     * This method gets the URL Path.
     * @param site URL to read the protocols.
     * @return Path URL.
     */
    public static String getPath (URL site) 
    {
        return site.getPath();
    }
    /**
     * This method gets the URL Query.
     * @param site URL to read the protocols.
     * @return Query URL.
     */
    public static String getQuery (URL site) 
    {
        return site.getQuery();
    }
    /**
     * This method gets the URL File.
     * @param site URL to read the protocols.
     * @return File URL.
     */
    public static String getFile (URL site) 
    {
        return site.getFile();
    }
    /**
     * This method gets the URL Reference.
     * @param site URL to read the protocols.
     * @return Reference URL.
     */
    public static String getRef (URL site) 
    {
        return site.getRef();
    }
}