/**
 * Find Minimum Cost Spanning Tree of a given connected undirected graph using Prims's algorithm.
 * 
 *
 *
 *
 *
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class Prims {

  /**
   * Constructor which find MCST using Prims Algorithm.
   *
   *
   *
   * @param int w   - Weighted Matrix
   * @param int n   - Number of Vertices
   * @param int s   - Source Vertex
   */
  Prims ( int[][] w, int n, int s ) {

    // To keep a record of which all vertices have been visited
    int visited[] = new int [ 10 ];

    int u = 0,          // To hold the first edge
        v = 0,          // To hold the second edge
        k = 0,          // Counter
        sum = 0,        // To store the cost of Spanning Tree
        flag = 0,       // To indicate whether MCST exists or not
        min;            // To hold minimum edge cost
    
    // Initially, setting all vertices as not visited
    for ( int i = 1; i <= n; i++ ) {
      visited [ i ] = 0;
    }
    
    visited [ s ] = 1;    // Marking source vertex as visited
    k = 1;                // Initialising counter

    // Iterating through all vertices
    while ( k <= n-1 ) {

      // Setting minimum value to highest i.e. infinity
      min = 99;

      // Traversing through weighted matrix
      // and selecting minimum edge
      for ( int i = 1; i <= n; i++ ) {
        for ( int j = 1; j <= n; j++ ) {

          if ( visited[i] == 1 && visited[j] == 0 ) {
            if ( i != j && w[i][j] < min ) {
              min = w [ i ][ j ];
              u = i;
              v = j;
            }
          }
        }
      }

      visited [ v ] = 1;    // Marking destination vertex as visited
      sum = sum + min;      // Adding up the cost with current selected edge cost
      k += 1;               // Incrementing counter

      // Showing the current minimum edge to user
      System.out.println ( u + "->" + v + " = " + min );
    }

    // From 'n' vertices if anyone of the vertex is not visited
    // then MCST does not exist.
    for ( int i = 1; i <= n; i++ ) {
      if ( visited[i] == 0 ) flag = 1;
    }  

    if ( flag == 1 )
      System.out.println ( "No spanning tree" );
    else
      System.out.println ( "The cost of minimum spanning tree is: " + sum );
  }

  public static void main ( String[] args ) {

    // To Scan inputs from user
    Scanner scan = new Scanner ( System.in );

    // To store weighted matrix
    int w[][] = new int [ 10 ][ 10 ];
    
    int s,    // To store source vertex
        n;    // To store number of vertices

    // Scanning number of vertices in graph
    System.out.print ( "Enter the number of vertices: " );
    n = scan.nextInt();
    
    // Scanning weighted matrix
    System.out.println ( "Enter the weighted graph" );
    for ( int i = 1; i <= n; i++ ) {
      for ( int j = 1; j <= n; j++ ) {
        w [ i ][ j ] = scan.nextInt();
      }
    }
    
    // Scanning source vertex
    System.out.print ( "Enter the source vertex: " );
    s = scan.nextInt();

    // Invoking Prims Algorithm
    Prims prims = new Prims ( w, n, s );
    
    scan.close();
  }
}