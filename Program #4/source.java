/**
 * Sort a given set of n integer elements using Quick Sort method and compute its time complexity. 
 * Run the program for varied values of n>5000 and record the time taken to sort. Plot a graph of
 * the time taken versus non graph sheet. The elements can be read from a file or can be generated
 * using the random number generator. Demonstrate using Java how the divide-and-conquer method 
 * works along with its time complexity analysis: worst case, average case and best case.
 *
 *
 * @author Akhil Kokani
 */

import java.util.Random;
import java.util.Scanner;

public class source {

  public static void main ( String[] args ) {
    
    // n => Number of Elements
    // random_numbers => To store all random numbers generated
    // startTime => Calculating at what time sorting began
    // stopTime => Calculating at what time sorting ended
    int n = 2;
    int[] random_numbers = new int[5000];
    long startTime, stopTime;

    // Generator to Random Numbers
    // Scanner to scan inputs from user
    // QuickSort to sort elements
    Random number_generator = new Random();
    Scanner scan = new Scanner ( System.in );
    QuickSort QS = new QuickSort();

    // Asking user to enter n value
    System.out.print ( "Enter N value: " );
    n = scan.nextInt ();

    // Closing scanner
    scan.close();

    // Generating a random number and storing it inside array
    // At the same time, display current generated random number to user
    System.out.println ( "Array before sorting:" );
    for ( int i = 0; i < n; i++ ) {

      random_numbers [ i ] = number_generator.nextInt ( 1000 );
      System.out.print ( random_numbers[i] + " " );
    }
    System.out.println ("");

    // Storing time at what sorting began
    // Sorting all array elements in ascending order
    // Storing time at what sorting ended
    startTime = System.nanoTime();
    QS.sort ( random_numbers, 0, n-1 );
    stopTime = System.nanoTime();

    // Using Formula "(nano-seconds)/1e9" displaying time taken to sort elements
    System.out.println ( "Time taken to sort " + n + " numbers is: " + ((stopTime - startTime)/ 1000000000) + " seconds." );

    // Displaying user sorted array
    System.out.println ( "Sorted Array:" );
    for ( int i = 0; i < n; i++ )
      System.out.print ( random_numbers[i] + " " );
    
    System.out.println ("");
  }
}

public class QuickSort {

  /**
   * Used to divide array and sort elements.
   *
   *
   * @param int a
   * @param int low
   * @param int high
   * @return int
   */
  private int partition ( int[] a, int low, int high ) {

    // To store array element temporarily
    int temp;

    // Storing first element of array
    // Storing low index by incrementing it by 1
    // Storing high index in seperate variable
    int p = a [ low ];
    int i = low + 1;
    int j = high;

    // Untill low is less than high
    while ( low < high ) {
      
      // Until, 'a' element at ith index is less than or equal to 'p'
      // and, 'i' is less than high index
      // Increment 'i' by 1
      while ( a[i] <= p && i < high )
        i += 1;

      // Until 'a' element at jth index is greater than 'p'
      // Decrement 'j' by 1
      while ( a[j] > p )
        j -= 1;

      // If i value is less than j
      // then, swap (interchange) a[i] value with a[j]
      if ( i < j ) {
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      } 
      // else, swap (interchange) a[low] value with a[j]
      else {
        temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
      }
    }

    // If low is not less than high
    return j;
  }

  /**
   * Used to sort elements using recurrsive technique.
   *
   *
   * @param int a
   * @param int low
   * @param int high
   * @return void
   */
  public void sort ( int[] a, int low, int high ) {

    if ( low < high ) {

      // Storing the partitioned index returned by partition()
      // Sorting first half of array
      // Sorting second half of array
      int s = this.partition ( a, low, high );
      sort ( a, low, s-1 );
      sort ( a, s+1, high );
    }
  }
}