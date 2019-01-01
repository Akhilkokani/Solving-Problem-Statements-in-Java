/**
 * PART A::
 *  Create a Java class called Student with the following details as variables within it. 
 *  (i) USN 
 *  (ii) Name 
 *  (iii) Branch 
 *  (iv) Phone Number
 *  Write a Java program to create nStudent objects and print the USN, Name, Branch, and Phone Number 
 *  of these objects with suitable headings.
 * 
 * 
 * @author Akhil Kokani
 */

import java.util.Scanner;

public class part_a {

  public static void main ( String[] args ) {
    
    // Temporary variables
    String usn = "";
    String name = "";
    String branch = "";
    int phone_number = 0;

    // Scanner to scan inputs from user
    // Declaring 10 student objects
    Scanner scan = new Scanner ( System.in );
    student std[] = new student[10];

    // Scanning two student details from user
    for ( int i = 0; i < 2; i++ ) {

      // Initialising student object
      // Telling user which student detail he/she is entering
      std[i] = new student();
      System.out.println ( "Enter " + (i + 1) + " student data." );

      // USN
      System.out.print ( "Enter USN: " );
      usn = scan.nextLine();

      // Name
      System.out.print ( "Enter Name: " );
      name = scan.nextLine();

      // Branch
      System.out.print ( "Enter Branch: " );
      branch = scan.nextLine();

      // Phone Number
      System.out.print ( "Enter Phone Number: " );
      phone_number = scan.nextInt();

      // Swalloing \n character
      // Adding student record
      scan.nextLine();
      std[i].add ( usn, name, branch, phone_number );
    }

    // Closing scanner
    scan.close();

    // Displaying student details
    for ( int i = 0; i < 2; i++ ) {
      System.out.println ( "Displaying " + i + " student data." );
      std[i].display();
    }
  }
}

public class student {
  
  // Class Globals
  String usn;
  String name;
  String branch;
  int phone_number;

  /**
   * Used to add new student record.
   *
   * @param string u
   * @param string n
   * @param string b
   * @param int u
   * @return void
   */
  public void add ( String u, String n, String b, int p ) {

    this.usn = u;
    this.name = n;
    this.branch = b;
    this.phone_number = p;
  }

  /**
   * Used to display student details.
   *
   * @return void
   */
  public void display() {
    System.out.format ( "%s%20s%20s%20d\n", this.usn, this.name, this.branch, this.phone_number );
  }
}