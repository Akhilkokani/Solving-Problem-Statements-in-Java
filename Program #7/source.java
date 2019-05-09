/**
 * From a given vertex in a weighted connected graph, find shortest paths to 
 * other vertices using Dijkstra's algorithm. Write the program in Java.
 * 
 *
 *
 *
 *
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class Dijkstra {

  int distance[] = new int[10];   // To store new minimum distance values from given source vertex.
  int path[] = new int[10];       // To keep track of from via which vertex the given vertex was reached.
  int visited[] = new int[10];    // To keep track of which all vertices have been visited.

  /**
   * Solves the problem using Dijkstras Algorithm.
   *
   *
   *
   * @param int a   Weighted Matrix
   * @param int s   Source Vertex
   * @param int n   Number of Vertices
   * @return void
   */
  public void solve ( int[][] a, int s, int n ) {
    
    // Initially not selecting any vertex
    int selected_vertex = -1;
    
    // Initially setting all vertices distance values as infinity i.e. 99
    // Initially setting Path from which vertex any given vertex is reached to -1
    for ( int v = 1; v <= n; v++ ) {

      distance[v] = 99;
      path[v] = -1;
    }

    // Distance to source vertex is 0
    distance[s] = 0;

    // Iterating through all vertices
    for ( int i = 1; i <= n; i++ ) {
    
      int min = 99;   // Minimum value of vertex, initially
      for ( int v = 1; v <= n; v++ ) {

        // Current vertex's 'v' distance is less than 'min' 
        // and vertex 'v' is also not visited, so,
        // New minimum distance 'min' becomes vertex 'v' distance.
        // and Current vertex 'v' becomes as selected vertex
        if ( distance[v] < min && visited[v] == 0 ) {
          min = distance[v];
          selected_vertex = v;
        }
      }

      // Setting selected vertex as visited
      visited [ selected_vertex ] = 1;

      for ( int v = 1; v <= n; v++ ) {
        
        // Applying Relaxation.
        // Distance from selected vertex + distance from selected vertex to vertex traversing to 'v' < distance of vertex 'v'
        // & Selected vertex is not same as vertex traversing to
        // & Vertex traversing to is not visited before, so...
        if ( (distance[selected_vertex] + a[selected_vertex][v] < distance[v]) && (selected_vertex != v) && visited[v] == 0 ) {
          
          // ...Update the distance of vertex traversing to with relaxation formula
          // and set the path for vertex 'v' from selected vertex.
          distance [ v ] = distance [ selected_vertex ] + a [ selected_vertex ] [ v ];
          path [ v ] = selected_vertex;
        }
      }
    }
  }

  /**
   * Finds via path for given vertex i.e. from which the vertex given vertex was reached.
   *
   *
   *
   * @param int v   Vertex to Find Path for.
   * @param int s   Source Vertex.
   * @return void
   */
  private void path ( int v, int s ) {
    
    if ( path[v] != -1 )
      path ( path[v], s );
    
    if ( v != s )
      System.out.print ( "-> " + v + " ");
  }

  /**
   * To Display the shortest path between source to other vertices.
   *
   *
   *
   * @param int s   Source Vertex.
   * @param int n   Number of Vertices.
   * @return void
   */
  void display ( int s, int n ) {

    System.out.println ( "The shortest path between source " + s + " to remaining vertices are:" );
    for ( int i = 1; i <= n; i++ ) {

      if ( i != s ) {
        System.out.print ( s + " " );
        path ( i, s );
        System.out.print ( "= " + distance[i] + " " );
      }
      System.out.println();
    }
  }

  public static void main ( String[] args ) {

    Scanner scan = new Scanner ( System.in );   // To Scan Inputs from User
    Dijkstra dijkstra = new Dijkstra ();        // Main Algorithm Class

    int n;                          // To Hold Number of Vertices
    int s;                          // To Hold Source Vertex
    int a[][] = new int[10][10];    // To Hold Graph Values i.e. Distances

    // Number of Vertices
    System.out.println ( "Enter the number of vertices: " );
    n = scan.nextInt();

    // Scanning Graph
    System.out.println ( "Enter the weighted matrix: " );
    for ( int i = 1; i <= n; i++ ) {
      for ( int j = 1; j <= n; j++ )  
        a [ i ][ j ] = scan.nextInt();
    }

    // Source Vertex
    System.out.print ( "Enter the source vertex: " );
    s = scan.nextInt();

    dijkstra.solve ( a, s, n );   // Solving using Dijkstra's Algorithm
    dijkstra.display ( s, n );    // Displaying Vertices Distance from Given Source Vertex
    scan.close();
  }
}