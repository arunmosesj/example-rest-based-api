package org.screative.gardpower;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try {
            ExpressServer.initializeServer("Sureya", 9000, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
