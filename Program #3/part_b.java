/**
 * Part B
 *  Write a Java program that implements a multi-thread application that has three threads. 
 *  First thread generates a random integer for every 1 second; second thread computes the 
 *  square of the number and prints; third thread will print the value of cube of the number.
 *
 * 
 * @author Akhil Kokani
 */

import java.util.Random;

public class part_b {

  public static void main ( String[] args ) {
    
    // Initiliasing firstThread object
    // and invoking thread object
    firstThread fT = new firstThread();
    fT.start();
  }
}

public class firstThread extends Thread {

  // Class Globals
  public int randomInt = 1;

  /**
   * Overiding Thread method
   *
   *
   * @return void
   */
  public void run () {
    
    // Random Number Generator
    Random random = new Random ();

    // Infinite Loop
    while ( true ) {

      try {

        // Generating, Storing, and Displaying random integer generated
        randomInt = random.nextInt ( 100 );
        System.out.println ( "\nRandom generated is: " + randomInt );

        // Invoking Second Thread (Squaring a number)
        Thread threadTwo = new Thread ( new secondThread(randomInt) );
        threadTwo.start();

        // Invoking Third Thread (Cube of a number)
        Thread threadThree = new Thread ( new thirdThread(randomInt) );
        threadThree.start();

        // Pausing for 1000ms (1s)
        Thread.sleep ( 1000 );
      } 
      catch ( Exception e ) {
        System.out.println ( "Exception Raised. " + e.getMessage() );
      }
    }
  }
}

public class secondThread implements Runnable {

  // Class Global
  private int squareOfANumber = 1;

  /**
   * Constructor to calculate square of a number.
   *
   *
   * @param int randomInt
   */
  public secondThread ( int randomInt ) {
    this.squareOfANumber = randomInt * randomInt;
  }

  /**
   * To display square of a number.
   *
   *
   * @return void
   */
  public void run () {
    System.out.println ( "Square of Random Number is: " + this.squareOfANumber );
  }
}

public class thirdThread implements Runnable {

  // Class Global
  private int cubeOfANumber = 1;

  /**
   * Constructor to calculate cube of the number.
   *
   *
   * @param int randomInt
   */
  public thirdThread ( int randomInt ) {
    this.cubeOfANumber = randomInt * randomInt * randomInt;
  }

  /**
   * To display cube of number.
   *
   *
   * @return void
   */
  public void run () {
    System.out.println ( "Cube of Random Number is: " + this.cubeOfANumber );
  }
}