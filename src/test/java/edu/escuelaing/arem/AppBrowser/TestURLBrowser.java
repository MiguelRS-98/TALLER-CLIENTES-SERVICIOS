package edu.escuelaing.arem.AppBrowser;

import edu.escuelaing.arem.AppBrowser.URLBrowser;
import java.net.MalformedURLException;
import java.net.URL;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * This Class of test that URL Reader.
 * @author Miguel Angel Rodriguez Siachoque
 */
public class TestURLBrowser extends TestCase 
{
    /**
     * URL protocols test. 
     */
    public void testServer1 () throws MalformedURLException
    {
        URL site = new URL("http://google.com/");
        URLBrowser test1 = new URLBrowser();
        assertEquals(test1.readURL(site),true);
    }
    /**
     * URL protocols test. 
     */
    public void testServer2 () throws MalformedURLException
    {
        URL site = new URL("https://www.facebook.com/");
        URLBrowser test1 = new URLBrowser();
        assertEquals(test1.readURL(site),true);
    }
    /**
     * URL protocols test. 
     */
    public void testServer3 () throws MalformedURLException
    {
        URL site = new URL("https://www.youtube.com/");
        URLBrowser test1 = new URLBrowser();
        assertEquals(test1.readURL(site),true);
    }
}