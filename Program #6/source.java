/**
 * Implement in Java, the 0/1 Knapsack problem using:
 * 1. Dynamic Programming method.
 * 2. Greedy method.
 *
 *
 *
 *
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class source {

  public static void main ( String[] args ) {

    Scanner scan = new Scanner ( System.in );   // To scan values from user.
    knapsack kSack = new knapsack();            // To solve knapsack problem using Greedy and Dynamic Methods.

    int[] weights = new int [1000];             // To hold object weights.
    int[] values = new int [1000];              // To hold object profits.

    int number_of_elements = 3;                 // Number of items in knapsack, default 3.
    int knapsack_weight = 15;                   // Maximum capcaity of knapsack, default 15.

    // Scanning number of elements.
    System.out.print ( "Enter number of elements: " );
    number_of_elements = scan.nextInt();

    // Scanning weight of every element.
    System.out.println ( "ENTER WEIGHTS FOR " + number_of_elements + " ELEMENTS: " );
    for ( int i = 1; i <= number_of_elements; i++ ) {

      System.out.print ( "Enter weight of " + i + " element: " );
      weights[i] = scan.nextInt();
    }

    // Scanning profit of every element.
    System.out.println ( "ENTER VALUES FOR " + number_of_elements + " ELEMENTS: " );
    for ( int i = 1; i <= number_of_elements; i++ ) {

      System.out.print ( "Enter value of " + i + " element: " );
      values[i] = scan.nextInt();
    }

    // Scanning maximum capacity of knapsack.
    System.out.print ( "Enter Knapsack Weight: " );
    knapsack_weight = scan.nextInt();

    // Solving it using Greedy Method.
    kSack.greedy ( weights, values, knapsack_weight, number_of_elements );
  }
}

public class knapsack {

  /**
   * Solves using Dynamic Programming Method.
   *
   *
   *
   * @param int weights               Array consisting object weights.
   * @param int values                Array consisting object profits.
   * @param int knapsack_weight       Total Knapsack Weight.
   * @param int number_of_elements    Total Number of Elements.
   * @return void
   */
  public void dynamic ( int[] weights, int[] values, int knapsack_weight, int number_of_elements ) {
    // Coming Soon... ;)
  }


  
  /**
   * From the given array finds the largest element and return's its index value.
   *
   *
   *
   * @param double  ratios                            Array consisting knapsack ratio (Profit/Weight) values.
   * @param int     number_of_elements                Number of elements in the array.
   * @return int
   */
  private int get_highest_ratio ( double ratios[], int number_of_elements ) {

    int highest_index = 1;          // Initially point the highest index to first value.
    double highest = ratios[1];     // Initially consider first element as highest element.

    // Using squential search technique
    // Finding highest ratio and returning its index.
    for ( int i = 1; i <= number_of_elements; i++ ) {

      if ( ratios[i] > highest ) {
        highest = ratios[i];
        highest_index = i;
      }
    }
    return highest_index;
  }



  /**
   * Solves using Greedy Method.
   *
   *
   *
   * @param int weights               Array consisting object weights.
   * @param int values                Array consisting object profits.
   * @param int knapsack_weight       Total Knapsack Weight.
   * @param int number_of_elements    Total Number of Elements.
   * @return void
   */
  public void greedy ( int[] weights, int[] values, int knapsack_weight, int number_of_elements ) {

    double total_profit = 0;                      // To hold Total Profit.
    int temp = number_of_elements;                // Temporary variable to number of elements.
    double remaining_weight = knapsack_weight;    // Remaining weight, initally set to total knapsack weight.

    double ratios[] = new double [ 1000 ];        // To hold (Profit/Weight) Ratios for all elements.
    int selected_items[] = new int [ 1000 ];      // To hold items which are selected.

    // Identifying Profit/Weight Ratio for all elements and
    // Setting all items as not selected (-1 is used to indicate as item not selected and, -2 for item selected).
    for ( int i = 1; i <= number_of_elements; i++ ) {

      selected_items [ i ] = -1;
      ratios [ i ] = values[i] / weights[i];
    }

    // Iterating through all elements
    while ( number_of_elements > 0 ) {

      // Identifying highest ratio from ratio[] array.
      // NOTE: 'temp' variable holds to number of elements.
      int highest_ratio_index = get_highest_ratio ( ratios, temp );

      // Whole item has to be selected not a fraction of it
      if ( (remaining_weight - weights[highest_ratio_index]) > 0 ) {
        
        // Substracting remaining weight with current objects weight.
        // Adding current total profit with current objects profit.
        // Indicating current item as selected.
        remaining_weight = remaining_weight - weights [ highest_ratio_index ];
        total_profit = total_profit + values [ highest_ratio_index ];             
        selected_items [ highest_ratio_index ] = -2;
      }
      // Fraction of an item has to be selected not whole item
      else if ( remaining_weight < weights[highest_ratio_index] ) {
        
        // Adding current profit with, by dividing remaining weight with current object weight 
        // and multiplying it with current object's profit.
        // Substracting remaining weight with, by dividing remaining weight with current object weight 
        // and multiplying it with current object's weight.
        // Indicating current item as selected.
        total_profit = total_profit + ((double) remaining_weight/weights[highest_ratio_index] ) * values [ highest_ratio_index ];
        remaining_weight = remaining_weight - ((double) remaining_weight/weights[highest_ratio_index] ) * weights [ highest_ratio_index ];
        selected_items [ highest_ratio_index ] = -2;
      }

      // Resetting current item's ratio value to -1, so that next item it won't be selected again.
      // Reducing number of item to iterate by 1.
      ratios [ highest_ratio_index ] = -1;
      number_of_elements -= 1;
    }

    // Displaying Total Profit and Items Selected
    System.out.print ( "Total Profit: " + total_profit + " \nItems Selected: " );
    for ( int i = 1; i <= temp; i++ ) {
      if ( selected_items[i] == -2 )
        System.out.print ( i + " " );
    }
    System.out.println();
    return;
  }
}