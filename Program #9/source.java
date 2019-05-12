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

  Prims ( int[][] w, int n, int s ) {

    int visited[] = new int [ 10 ];

    int u = 0,
        v = 0,
        k = 0,
        sum = 0,
        flag = 0,
        min;
    
    for ( int i = 1; i <= n; i++ ) {
      visited [ i ] = 0;
    }
    
    visited [ s ] = 1;
    k = 1;

    while ( k <= n-1 ) {

      min = 99;
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

      visited [ v ] = 1;
      sum = sum + min;
      k += 1;

      System.out.println ( u + "->" + v + " = " + min );
    }

    for ( int i = 1; i <= n; i++ ) {
      if ( visited[i] == 0 ) flag = 1;
    }  

    if ( flag == 1 )
      System.out.println ( "No spanning tree" );
    else
      System.out.println ( "The cost of minimum spanning tree is: " + sum );
  }

  public static void main ( String[] args ) {
    
    Scanner scan = new Scanner ( System.in );

    int w[][] = new int [ 10 ][ 10 ];
    
    int s,
        n;

    System.out.print ( "Enter the number of vertices: " );
    n = scan.nextInt();
    
    System.out.println ( "Enter the weighted graph" );
    for ( int i = 1; i <= n; i++ ) {
      for ( int j = 1; j <= n; j++ ) {
        w [ i ][ j ] = scan.nextInt();
      }
    }
    
    System.out.print ( "Enter the source vertex: " );
    s = scan.nextInt();

    Prims prims = new Prims ( w, n, s );
    
    scan.close();
  }
}