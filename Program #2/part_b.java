/**
 * PART B::
 *  Write a Java class called Customer to store their name and date_of_birth. The date_of_birth
 *  format should be dd/mm/yyyy. Write methods to read customer data as <name, dd/mm/yyyy> and
 *  display as <name, dd, mm, yyyy> using StringTokenizer class considering the delimiter
 *  character as “/”.
 *
 *
 * @author Akhil Kokani
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class part_b {

  public static void main ( String[] args ) {

    // Customer object
    Customer customer;
    
    // Initliasing object
    // Reading values from user
    // Displaying values (modfied) to user
    customer = new Customer();
    customer.read();
    customer.display();
  }
}

public class Customer {

  // Class Globals
  private String name;
  private String dob;
  private String[] data = new String[1];

  // Scanner to scan inputs from user
  Scanner scanner = new Scanner ( System.in );

  /**
   * To read values name and date of birth.
   *
   *
   * @return void
   */
  public void read () {

    String temp_data;

    System.out.println ( "Enter your name and date of birth, like this: <name, dd/mm/yyyy>" );
    temp_data = scanner.nextLine();

    this.data = temp_data.split ( "," );
    this.name = this.data[0];
    this.dob = this.data[1];

    scanner.close();
  }

  /**
   * To display values modifed name and date of birth.
   *
   *
   * @return void
   */
  public void display() {

    StringTokenizer string_tokenizer;
    int number_of_tokens;
    
    // String Tokenizer with delimiter as '/'
    // Counting number of tokens
    string_tokenizer = new StringTokenizer ( this.dob, "/" );
    number_of_tokens = string_tokenizer.countTokens();

    System.out.print ( this.name + "," );

    // Printing modifed name and date of birth
    while ( number_of_tokens != 0 ) {
      
      // Current token is not last token in string_tokenzier
      // NOTE: To prevent comma ',' appear even after printing year (yyyy); We are using this logic.
      if ( number_of_tokens != 1 )
        System.out.print ( string_tokenizer.nextToken() + ", " );
      else
        System.out.print ( string_tokenizer.nextToken() );
      number_of_tokens -= 1;
    }

    System.out.print ( "\n" );
  }
}
