/**
 * PART B::
 *  Write a Java program to implement the Stack using arrays. Write Push(), Pop(), and Display() methods 
 *  to demonstrate its working.
 *
 * 
 * @author Akhil Kokani
 */

public class part_b {

  public static void main ( String[] args ) {
  
    // Temporary Variables
    int element = null;

    // Scanner to scan inputs from user
    // Stack Object
    Scanner scan = new Scanner ( System.in );
    Stack stack = new Stack();
    
    // Asking user to enter 5 elements
    System.out.println ( "Enter 5 elements" );
    for ( int i = 0; i < 5; i++ ) {

      System.out.print ( "Enter data: " );

      // Scanning and storing information into variable element
      // Pushing element into stack
      element = scan.nextInt();
      stack.push ( element );
    }

    // Displaying stack contents to user
    System.out.println ( "Displaying Stack Contents." );
    stack.display();
  }
}

public class Stack {

  // Constant for maximum no. of elements in stack
  // Stack Array
  // Stack top pointer variable with -1
  final static int max_elements_in_stack_array = 100;
  int array[] = new int [ max_elements_in_stack_array ];
  int top = -1;

  /**
   * Used to push (insert) element into stack.
   *
   * @param int element
   * @return void
   */
  public void push ( int element ) {

    // Stack is full
    if ( this.top = max_elements_in_stack_array - 1 ) {

      System.out.println ( "Stack Overflow." );
      return;
    }

    this.array [ ++this.top ] = element;
  }

  /**
   * Used to pop (remove) element from stack.
   *
   * @return void
   */
  public void pop() {

    // Stack is empty
    if ( this.top == -1 )  {

      System.out.println("Stack Underflow.");
      return;
    }

    this.top -= 1;
  }

  /**
   * Used to display stack contents.
   * 
   * @return void
   */
  public void display() {

    // Stack is empty
    if ( this.top == -1 )
      System.out.println("Stack Underflow.");

    for ( int i = this.top; i >= 0; i-- ) {
      System.out.format ( "%d ", this.array[i] );
    }

    System.out.print("\n");
  }
}