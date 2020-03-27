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

  // To store parent vertices of a particular vertex
  int parent[] = new int[10];

  /**
   * Finds parent vertex of a given particular vertex.
   *
   *
   *
   * @param int  m    - Vertex, whose parent vertex has to be found.
   * @return int
   */
  public int find ( int m ) {

    int p = m;

    while ( parent[p] != 0 )
      p = parent[p];

    return p;
  }

  /**
   * Using ranking based technique arranges two 
   * vertice(s) parent's in appropriate fashion.
   *
   *
   * @param int   i     - One vertex.
   * @param int   j     - Second vertex.
   * @return void
   */
  public void union ( int i, int j ) {

    if ( i < j )
      parent[i] = j;
    else
      parent[j] = i;
  }

  /**
   * Kruskal's Algorithm.
   *
   *
   *
   * @param int   a   - Weighted Matrix.
   * @param int   n   - Number of Vertices. 
   * @return void
   */
  public void solve ( int[][] a, int n ) {

    int u = 0,          // First Vertex.
        v = 0,          // Second Vertex.
        k = 0,          // Counter Variable.
        sum = 0,        // Cost of Spanning Tree.
        min;            // Minimum value of edge.

    // Iterating through all the edges
    while ( k < n-1 ) {

      // Initial vertex value
      min = 99;

      // Iterating through entire weighted matrix...
      for ( int i = 1; i <= n; i++ ) {
        for ( int j = 1; j <= n; j++ ) {

          // ...and selecting edge which is minimum and also
          // skipping the iterating if it is a self loop
          if ( a[i][j] < min && i != j ) {
            min = a[i][j];
            u = i;
            v = j;
          }
        }
      }

      // After finding edge with minimum cost i.e. 'u' & 'v'
      // Finding their parent vertices.
      int i = find ( u );
      int j = find ( v );

      // If both vertices parent's vertex are not same
      // that means they are not forming a cycle.
      if ( i != j ) {

        // Rank them by union
        // Show the current edge on screen
        // Add the cost
        // Increment 'k'
        union ( i, j );
        System.out.println ( "(" + u + "," + v + ")" + " = " + a[u][v] );
        sum = sum + a[ u ][ v ];
        k += 1;
      }

      // Set the current minimum edge cost as infinity
      // So that next time again it won't be selected.
      a[u][v] = a[v][u] = 99;
    }

    System.out.println ( "The cost of minimum spanning tree = " + sum );
  }

  public static void main ( String[] args ) {

    Scanner scan = new Scanner ( System.in );     // To scan inputs from user.
    Kruskal kruskal = new Kruskal();              // To find Minimum Cost Spanning Tree.

    int n;                                        // To store Number of vertices.
    int a[][] = new int [ 10 ][ 10 ];             // To store the graph i.e. weighted matrix.

    // Asking user to enter number of vertices on graph
    System.out.print ( "Enter the number of vertices of the graph: " );
    n = scan.nextInt();

    // Scanning graph
    System.out.println ( "Enter the wieghted matrix: " );
    for ( int i = 1; i <= n; i++ ) {
      for ( int j = 1; j <= n; j++ ) {
        a[i][j] = scan.nextInt();
      }
    }

    // Solving graph
    kruskal.solve ( a, n );
    scan.close();
  }
}