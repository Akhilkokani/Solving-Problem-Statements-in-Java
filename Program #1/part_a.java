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

public class source {

  public static void main ( String[] args ) {
    
    String usn = "";
    String name = "";
    String branch = "";
    int phone_number = 0;

    Scanner scan = new Scanner ( System.in );
    student std[] = new student[10];

    for ( int i = 0; i < 2; i++ ) {
      
      std[i] = new student();
      System.out.println ( "Enter " + i + " student data." );
      
      System.out.print ( "Enter USN: " );
      usn = scan.nextLine();

      System.out.print ( "Enter Name: " );
      name = scan.nextLine();

      System.out.print ( "Enter Branch: " );
      branch = scan.nextLine();

      System.out.print ( "Enter Phone Number: " );
      phone_number = scan.nextInt();

      scan.nextLine();
      std[i].add ( usn, name, branch, phone_number );
    }
    scan.close();

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
   * Used to display student details
   *
   * @return void
   */
  public void display() {
    System.out.format ( "%s%20s%20s%20d\n", this.usn, this.name, this.branch, this.phone_number );
  }
}