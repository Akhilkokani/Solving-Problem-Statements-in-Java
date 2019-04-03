import java.util.Scanner;

public class source {

  public static void main ( String[] args ) {

    Scanner scan = new Scanner ( System.in );
    knapsack kSack = new knapsack();

    int[] weights = new int [1000];
    int[] values = new int [1000];

    int number_of_elements = 3;
    int knapsack_weight = 15;

    System.out.print ( "Enter number of elements: " );
    number_of_elements = scan.nextInt();

    System.out.println ( "ENTER WEIGHTS FOR " + number_of_elements + " ELEMENTS: " );
    for ( int i = 1; i <= number_of_elements; i++ ) {

      System.out.print ( "Enter weight of " + i + " element: " );
      weights[i] = scan.nextInt();
    }

    System.out.println ( "ENTER VALUES FOR " + number_of_elements + " ELEMENTS: " );
    for ( int i = 1; i <= number_of_elements; i++ ) {

      System.out.print ( "Enter value of " + i + " element: " );
      weights[i] = scan.nextInt();
    }

    System.out.print ( "Enter Knapsack Weight: " );
    knapsack_weight = scan.nextInt();

    kSack.dynamic ( weights, values, knapsack_weight, number_of_elements );
  }
}

public class knapsack {

  /**
   * Solves using Dynamic Programming Method.
   *
   *
   *
   * @param int weights
   * @param int values
   * @param int knapsack_weight
   * @param int number_of_elements
   * @return void
   */
  public void dynamic ( int[] weights, int[] values, int knapsack_weight, int number_of_elements ) {
    
    int[][] solution = new int [ number_of_elements + 1 ][ knapsack_weight + 1 ];
    int[] selected = new int [ number_of_elements + 1 ];

    int i = 0;
    int j = 0;

    for ( i = 0; i <= number_of_elements; i++ ) {

      for ( j = 0; j <= knapsack_weight; j++ ) {

        if ( i == 0 || j == 0 )
          solution[ i ][ j ] = 0;
        else if ( weights[i] > j )
          solution[ i ][ j ] = solution[ i - 1 ][ j ];
        else
          solution[ i ][ j ] = Math.max ( solution[i-1][j], ( solution[i-1][j - weights[i]] + values[i]) );
      }
    }

    System.out.println ( "The Optimal Solution is: " + solution[number_of_elements][knapsack_weight] );

    for ( i = 0; i < number_of_elements + 1; i++ ) {
      selected[i] = 0;
    }

    i = number_of_elements;
    j = knapsack_weight;

    while ( i > 0 && j > 0 ) {

      if ( solution[i][j] != solution[i-1][j] ) {
        selected[i] = 1;
        j = j - weights[i];
      }
      i -= 1;
    }

    System.out.println ( "Items Selected: " );
    for ( i = 1; i < number_of_elements + 1; i++ ) {

      if ( selected[i] == 1 )
        System.out.print ( i + " " );
    }
    System.out.println ( "" );
  }
}