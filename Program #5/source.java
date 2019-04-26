/**
 * Sort a given set of n integer elements using Merge Sort method and compute its time complexity.
 * Run the program for varied values of n> 5000, and record the time taken to sort. Plot a graph 
 * of the time taken versus non graph sheet. The elements can be read from a file or can be 
 * generated using the random number generator. Demonstrate using Java how the divide-and-conquer 
 * method works along with its time complexity analysis: worst case, average case and best case.
 *
 *
 *
 * @author Akhil Kokani
 */

import java.util.Random;
import java.util.Scanner;

public class source {

  public static void main ( String[] args ) {
    
    int number_of_elements;       // To store number of elements to be generated inside array
    int array[] = new int[10000]; // Array with max 10K
    long startTime;               // To capture start time of sorting
    long stopTime;                // To capture end time of sorting

    Scanner scan = new Scanner ( System.in );   // To scan input(s) from user
    Random random = new Random();               // To generate random integers
    MergeSort mSort = new MergeSort();          // To sort elements

    // Scanning number of elements from user
    System.out.print ( "Enter value of N: " );
    number_of_elements = scan.nextInt();

    // Closing scanner as we are not going any values from anymore
    scan.close();

    System.out.println ( "Random Numbers: " );
    for ( int i = 0; i < number_of_elements; i++ ) {

      array[i] = random.nextInt (9876);      // Generating random integers
      System.out.print ( array[i] + " " );  // Displaying random integer generated
    }

    startTime = System.currentTimeMillis();         // Capturing start time
    mSort.sort ( array, 0, number_of_elements-1 );  // Sorting elements
    stopTime = System.currentTimeMillis();          // Capturing stop time

    // Displaying user sorted array
    System.out.println ( "\nSorted Array:" );
    for ( int i = 0; i < number_of_elements; i++ ) {
      System.out.print ( array[i] + " " );
    }

    // Displaying total time taken to sort in ms
    System.out.println ( "\nIt took " + (stopTime - startTime) + " milli-seconds to sort array." );
  }
}

public class MergeSort {

  /**
   * Used to merge array elements by comparing.
   *
   *
   * @param int array
   * @param int low
   * @param int mid
   * @param int high
   * @return void
   */
  private void merge ( int[] array, int low, int mid, int high ) {

    int i = low;                        // Lowest index of array
    int j = mid + 1;                    // Index of first element of second half
    int k = low;                        // Index pointer for temporary array
    int resultArray[] = new int[10000]; // Temporary Array

    // Until i & j are in range of array
    while ( i <= mid && j <= high ) {

      // Comparing and Transferring into temporary array (if condition true)
      if ( array[i] < array[j] ) {
        
        resultArray[k] = array[i];
        i += 1;
        k += 1;
      }
      // Transferring into temporary array
      else {

        resultArray[k] = array[j];
        j += 1;
        k += 1;
      }
    }

    // Transferring remaining elements (if any)
    while ( i <= mid )
      resultArray [ k++ ] = array [ i++ ];

    // Transferring remaining elements (if any)
    while ( j <= high )
      resultArray [ k++ ] = array [ j++ ];

    // Transferring all temporary array elements into reference array
    for ( int m = low; m <= high; m++ )
      array [m] = resultArray[m];
  }

  /**
   * Acts as wrap up function for calling both halves of array.
   *
   *
   * @param int array
   * @param int low
   * @param int high
   * @return void
   */
  public void sort ( int[] array, int low, int high ) {

    // Base Condition
    if ( low < high ) {

      int mid = (low + high) / 2;               // Calucalting middle index
      this.sort ( array, low, mid );            // Sorting first half of array
      this.sort ( array, mid+1, high );         // Sorting second half of array
      this.merge ( array, low, mid, high );     // Merging current half of array
    }
  }
}