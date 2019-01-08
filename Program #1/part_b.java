/**
 * PART B::
 *  Write a Java program to implement the Stack using arrays. Write Push(), Pop(), and Display() methods 
 *  to demonstrate its working.
 *
 * 
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class part_b {

  public static void main ( String[] args ) {
  
    // Temporary Variables
    int element;
    int user_choice = 1;

    // Scanner to scan inputs from user
    // Stack Object
    Scanner scan = new Scanner ( System.in );
    Stack stack = new Stack();

    // Printing menu to user
    System.out.println ( "MENU:\n 1: Push.\n 2: Pop.\n 3: Display." );

    // Iterating through user choice
    while ( user_choice <= 3 ) {

      // Asking user his/her choice
      System.out.print ( "Enter your choice: " );
      user_choice = scan.nextInt();

      // Determining what was user's choice
      switch ( user_choice ) {

        // Inserting element (Push) into stack
        case 1:
          System.out.print ( "Enter element: " );
          element = scan.nextInt();
          stack.push ( element );
          break;

        // Removing element (Pop) from stack
        case 2:
          if ( stack.pop() == true )
            System.out.println ( "One element removed form stack." );
          break;

        // Displaying stack contents
        case 3:
          stack.display();
          break;

        // Quit program, due to invalid choice
        default:
          System.out.println ( "Program Ended." );
          break;
      }
    }

    // Closing scanner
    scan.close();
  }
}

public class Stack {

  // Constant for maximum no. of elements in stack
  // Stack Array
  // Stack 'top pointer' variable with -1
  final static int max_elements_in_stack_array = 100;
  int array[] = new int [ max_elements_in_stack_array ];
  int top = -1;

  /**
   * Used to push (insert) element into stack.
   *
   * @param int element
   * @return boolean
   */
  public boolean push ( int element ) {

    // Stack is full
    if ( this.top == max_elements_in_stack_array - 1 ) {

      System.out.println ( "Stack Overflow." );
      return false;
    }

    this.array [ ++this.top ] = element;
    return true;
  }

  /**
   * Used to pop (remove) element from stack.
   *
   * @return boolean
   */
  public boolean pop() {

    // Stack is empty
    if ( this.top == -1 )  {

      System.out.println ( "Stack Underflow." );
      return false;
    }

    this.top -= 1;
    return true;
  }

  /**
   * Used to display stack contents.
   * 
   * @return boolean
   */
  public boolean display() {

    // Stack is empty
    if ( this.top == -1 ) {

      System.out.println ( "Stack Underflow." );
      return false;
    }

    for ( int i = this.top; i >= 0; i-- ) {
      System.out.format ( "%d ", this.array[i] );
    }

    System.out.print ( "\n" );
    return true;
  }
}