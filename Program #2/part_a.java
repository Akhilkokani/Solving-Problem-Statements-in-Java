/**
 * PART A::
 *  Design a superclass called Staff with details as StaffId, Name, Phone, Salary. 
 *  Extend this class by writing three subclasses namely Teaching (domain, publications), 
 *  Technical (skills), and Contract (period). Write a Java program to read and display 
 *  at least 3 staff objects of all three categories.
 *
 * 
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class part_a {

  public static void main ( String[] args ) {

    // Maximum number of staff details
    // To hold 3 counters
    // To hold user choice
    final int max_number_of_staff = 2;
    int counter[] = new int[3];
    int user_choice = 4;

    // Scanner to scan inputs from user
    // Teaching object
    // Technical object
    // Contract object
    Scanner scan = new Scanner ( System.in );
    Teaching teach[] = new Teaching [ max_number_of_staff ];
    Technical technical[] = new Technical [ max_number_of_staff ];
    Contract contract[] = new Contract [ max_number_of_staff ];

    // Printing menu on screen
    System.out.println ( "MENU:\n 1: Add new staff with Teaching Details.\n 2: Add new staff with Technical Details.\n 3: Add new staff with Contract Details.\n 4: Display all staff details.\n" );

    // Intialising all counters
    // Here, counter[0] is for teaching, counter[1] is for technical, and counter[2] for contract
    counter [ 0 ] = -1;
    counter [ 1 ] = -1;
    counter [ 2 ] = -1;

    // Iterating through user choice
    while ( user_choice < 5 ) {

      // Asking user his/her choice
      System.out.print ( "Enter your option: " );
      user_choice = scan.nextInt();

      // Determining user's choice
      switch ( user_choice ) {

        // Add new staff with Teaching Details
        case 1:
          teach [ ++counter[0] ] = new Teaching ();
          break;

        // Add new staff with Technical Details
        case 2:
          technical [ ++counter[1] ] = new Technical ();
          break;

        // Add new staff with Contract Details
        case 3:
          contract [ ++counter[2] ] = new Contract ();
          break;
        
        // Display all staff details
        case 4:
          // No details of any category were entered
          if ( 
            counter[0] != -1 || 
            counter[1] != -1 || 
            counter[2] != -1 
          ) {

            // Displaying Teaching Details
            if ( counter[0] != -1 ) {
              System.out.format ( "------ TEACHING DETAILS ------\n" );
              for ( int i = 0; i <= counter[0]; i++ ) {
                System.out.println ( (i + 1) + " Staff Details:" );
                teach [ i ].display_teaching_details();
              }
            }

            // Displaying Technical Details
            if ( counter[1] != -1 ) {
              System.out.format ( "------ TECHNICAL DETAILS ------\n" );
              for ( int i = 0; i <= counter[1]; i++ ) {
                System.out.println ( (i + 1) + " Technical Details:" );
                technical [ i ].display_technical_details();
              }
            }

            // Displaying Contract Details
            if ( counter[2] != -1 ) {
              System.out.format ( "------ CONTRACT DETAILS ------\n" );
              for ( int i = 0; i <= counter[2]; i++ ) {
                System.out.println ( (i + 1) + " Contract Details:" );
                contract [ i ].display_contract_details();
              }
            }

          } 
          // No details of any category were entered
          else
            System.out.println ( "No details entered." );
          break;

        // Quit program, invalid choice
        default:
          System.out.println ( "Program Ended." );
          break;
      }
    }

    // Closing scanner
    scan.close();
  }
}

public class Staff {

  // Class Globals
  String staff_id;
  String name;
  int phone;
  int salary;

  // Scanner
  Scanner scanner = new Scanner ( System.in );

  /**
   * Class Constructor to assign values to class globals.
   *
   * @param String staff_id
   * @param String name
   * @param String phone
   * @param String salary
   */
  public Staff () {

    System.out.print ( "Enter Staff ID: " );
    this.staff_id = scanner.nextLine();

    System.out.print ( "Enter Name: " );
    this.name = scanner.nextLine();

    System.out.print ( "Enter Phone: " );
    this.phone = scanner.nextInt();

    System.out.print ( "Enter Salary: " );
    this.salary = scanner.nextInt();
  }

  /**
   * To display staff details
   *
   *
   */
  public void display() {

    System.out.println ( "Staff ID: " + staff_id );
    System.out.println ( "Staff Name: " + name );
    System.out.println ( "Staff Phone: " + phone );
    System.out.println ( "Staff Salary: " + salary );
  }
}

public class Teaching extends Staff {

  // Class Globals
  String domain;
  int publications;

  /**
   * Class constructor.
   *
   * @param String staff_id
   * @param String name
   * @param String phone
   * @param String salary
   * @param String domain
   * @param String publication
   */
  public Teaching () {

    // Calling super class's constructor
    super();

    super.scanner.nextLine();

    System.out.print ( "Enter Staff Domain: " );
    this.domain = super.scanner.nextLine();

    System.out.print ( "Enter Staff Publications: " );
    this.publications = super.scanner.nextInt();
  }

  /**
   * To display teaching details.
   *
   *
   */
  public void display_teaching_details() {

    // Calling super class display function
    super.display();
    System.out.println ( "Staff Domain: " + domain );
    System.out.println ( "Staff Publications: " + publications );
  }
}

public class Technical extends Staff {
  
  // Class Global
  String skills;

  /**
   * Class Constructor.
   *
   * @param String staff_id
   * @param String name
   * @param String phone
   * @param String salary
   * @param String skills
   */
  public Technical () {
    
    // Calling super class's constructor
    super();

    super.scanner.nextLine();

    System.out.print ( "Enter Staff Skills: " );
    this.skills = super.scanner.nextLine();
  }

  /**
   * To display teaching details.
   *
   *
   */
  public void display_technical_details() {

    // Calling super class display function
    super.display();
    System.out.println ( "Staff Skills: " + skills );
  }
}

public class Contract extends Staff {

  // Class Global
  int period;

  /**
   * Class Constructor.
   *
   * @param String staff_id
   * @param String name
   * @param String phone
   * @param String salary
   * @param String period
   */
  public Contract () {

    // Calling super class's constructor
    super();

    System.out.print ( "Enter Staff Period: " );
    this.period = super.scanner.nextInt();
  }

  /**
   * To display teaching details.
   *
   *
   */
  public void display_contract_details() {

    // Calling super class display function
    super.display();
    System.out.println ( "Staff Period: " + period );
  }
}