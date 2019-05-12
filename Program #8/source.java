/**
 * Find Minimum Cost Spanning Tree of a given connected undirected graph using Kruskal's algorithm.
 * Use Union-Find algorithms in your program.
 *
 *
 *
 *
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class Kruskal {

  int parent[] = new int[10];

  public int find ( int m ) {

    int p = m;

    while ( parent[p] != 0 )
      p = parent[p];

    return p;
  }

  public void union ( int i, int j ) {

    if ( i < j )
      parent[i] = j;
    else
      parent[j] = i;
  }

  public void solve ( int[][] a, int n ) {

    int u = 0,
        v = 0,  
        k = 0,
        sum = 0,
        min;

    while ( k < n-1 ) {

      min = 99;
      for ( int i = 1; i <= n; i++ ) {
        for ( int j = 1; j <= n; j++ ) {

          if ( a[i][j] < min && i != j ) {
            min = a[i][j];
            u = i;
            v = j;
          }
        }
      }

      int i = find ( u );
      int j = find ( v );

      if ( i != j ) {

        union ( i, j );
        System.out.println ( "(" + u + "," + v + ")" + " = " + a[u][v] );
        sum = sum + a[ u ][ v ];
        k += 1;
      }

      a[u][v] = a[v][u] = 99;
    }

    System.out.println ( "The cost of minimum spanning tree = " + sum );
  }

  public static void main ( String[] args ) {
    
    Kruskal kruskal = new Kruskal(); 
    Scanner scan = new Scanner ( System.in );

    int n;
    int a[][] = new int [ 10 ][ 10 ];

    System.out.print ( "Enter the number of vertices of the graph: " );
    n = scan.nextInt();

    System.out.println ( "Enter the wieghted matrix: " );
    for ( int i = 1; i <= n; i++ ) {
      for ( int j = 1; j <= n; j++ ) {
        a[i][j] = scan.nextInt();
      }
    }

    kruskal.solve ( a, n );
    scan.close();
  }
}