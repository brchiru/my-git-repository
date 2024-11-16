package org.learnsel;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Current Time: "+ LocalTime.now());
        for (long i = 1; i <= 5000000; i++) {
            i = i * i * i;
            System.out.println( "i = "+ i*i);
        }
        System.out.println("After Time: "+LocalTime.now());
    }
}
