package edu.escuelaing.arem.Calculator;

import edu.escuelaing.arem.Calculator.CalculatorServer;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * This Class of test that Square Numbers.
 * @author Miguel Angel Rodriguez Siachoque
 */
public class TestCalculatorServer extends TestCase
{
    /**
     * Bye message test. 
     */
    public void testServer1 () 
    {
        CalculatorServer test1 = new CalculatorServer();
        String res1 = test1.isBye("Bye.");
        assertEquals(res1,"Respuesta de servidor: Bye.");
    }
    /**
     * Square message test. 
     */
    public void testServer2 () 
    {
        CalculatorServer test2 = new CalculatorServer();
        String res2 = test2.isBye("2");
        assertEquals(res2,"El cuadrado de 2: 4.0.");
    }
    /**
     * Square message test. 
     */
    public void testServer3 () 
    {
        CalculatorServer test3 = new CalculatorServer();
        String res3 = test3.isBye("5");
        assertEquals(res3,"El cuadrado de 5: 25.0.");
    }
}