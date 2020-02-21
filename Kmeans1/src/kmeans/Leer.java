/*
 * Clase que permite leer datos capturados por el teclado
 */
package kmeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jorge
 */
public class Leer{
    /**
     *Retorna el string capturado desde el teclado.
    */
    public static String dato()
    {
        String sdato;
        sdato = "";
        InputStreamReader isr;
        isr = new InputStreamReader(System.in);
        BufferedReader flujoE;
        flujoE = new BufferedReader(isr);
        try
        {
            sdato = flujoE.readLine();
        }
        catch(IOException e)
        {
            System.err.println("Error de lectura " + e.getMessage());
        }
        return sdato;
    }

    /**
     *Retorna el byte capturado desde el teclado.
    */
    public static byte datoByte(){
        try
        {
            return Byte.parseByte(dato());
        }
        catch(NumberFormatException e)
        {
            System.err.println("Error de lectura " + e.getMessage());
            return Byte.MIN_VALUE;
        }
    }

    /**
     *Retorna el short capturado desde el teclado.
    */
    public static short datoShort()
    {
        try
        {
            return Short.parseShort(dato());
        }
        catch(NumberFormatException e)
        {
            System.err.println("Error de lectura " + e.getMessage());
            return Short.MIN_VALUE;
        }
    }

    /**
     *Retorna el int capturado desde el teclado.
    */
    public static int datoInt()
    {
        try
        {
            return Integer.parseInt(dato());
        }
        catch(NumberFormatException e)
        {
            System.err.println("Error de lectura " + e.getMessage());
            return Integer.MIN_VALUE;
        }
    }

    /**
     *Retorna el long capturado desde el teclado.
    */
    public static long datoLong()
    {
        try
        {
            return Long.parseLong(dato());
        }
        catch(NumberFormatException e)
        {
            System.err.println("Error de lectura " + e.getMessage());
            return Long.MIN_VALUE;
        }
    }

    /**
     *Retorna el float capturado desde el teclado.
    */
    public static float datoFloat()
    {
        try
        {
            return Float.parseFloat(dato());
        }
        catch(NumberFormatException e)
        {
            System.err.println("Error de lectura " + e.getMessage());
            return Float.MIN_VALUE;
        }
    }

    /**
     *Retorna el double capturado desde el teclado.
    */
    public static double datoDouble()
    {
        try
        {
            return Double.parseDouble(dato());
        }
        catch(NumberFormatException e)
        {
            System.err.println("Error de lectura " + e.getMessage());
            return Double.MIN_VALUE;
        }
    }

    /**
     * Retorna el char capturado desde el teclado.
    */
    public static char datoChar()
    {
        char c = ' ';
        char[] c1 = dato().toCharArray();
        if (c1.length == 1)
              c = c1[0];
        return c;
    }

    /**
     * Retorna el boolean capturado desde el teclado.
    */
    public static boolean datoBoolean(String B){
        String b=B;
        if(b.equals(dato())){
            return true;
        }
        return false;
    }        
}
