/**
 * PART A::
 *  Write a Java program to read two integers a and b. 
 *  Compute a/b and print, when b is not zero. 
 *  Raise an exception when b is equal to zero.
 *
 *
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class part_a {

  public static void main ( String[] args ) {
    
    // Global Variables
    int a, b;

    // Scanner to scan inputs from user
    Scanner scan = new Scanner ( System.in );

    // Scanning a value
    System.out.print ( "Enter a: " );
    a = scan.nextInt();

    // Scanning b value
    System.out.print ( "Enter b: " );
    b = scan.nextInt();

    // Trying to perform operation a/b
    // and showing result to user
    try {

      int compute = a/b;
      System.out.println ( "a/b is: " + compute );
    }
    // If b is 0, catching the exception
    // and showing to user
    catch ( ArithmeticException Exception ) {
      System.out.println ( "Exception Raised: " + Exception.getMessage() );
    }

    // Closing scanner
    scan.close();
  } 
}