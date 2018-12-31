/**
 * PART A::
 *  Design a superclass called Staff with details as StaffId, Name, Phone, Salary. 
 *  Extend this class by writing three subclasses namely Teaching (domain, publications), 
 *  Technical (skills), and Contract (period). Write a Java program to read and display 
 *  at least 3 staff objects of all three categories.
 *
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

public class source {

  Scanner scan = new Scanner ( System.in ); 
  String temp_sid, temp_name;
  int temp_phone, temp_salary;

  public static void getStaffInfo() {

    System.out.print ( "Enter Staff ID: " );
    temp_sid = scan.nextLine();

    System.out.print ( "Enter Name: " );
    temp_name = scan.nextLine();

    System.out.print ( "Enter Phone: " );
    temp_phone = scan.nextInt();

    System.out.print ( "Enter Salary: " );
    temp_salary = scan.nextInt();
  }

  public static void main ( String[] args ) {

    String menu = "MENU:\n 1: Add new staff with Teaching Details.\n 2: Add new staff with Contract Details.\n 3: Add new staff with Techinical Skills.\n 4: Display all staff details.\n";
    int counter[] = new int[2];
    int user_choice = 4;
     
    final int max_number_of_staff = 4;

    Teaching teach[] = new Teaching [ 4 ];
    Contract contract[] = new Contract [ max_number_of_staff ];
    Technical technical[] = new Technical [ max_number_of_staff ];

    System.out.println ( menu );

    counter [ "teach" ] = -1;
    counter [ "contract" ] = -1;
    counter [ "technical" ] = -1;

    while ( user_choice < 5 ) {

      System.out.print ( "Enter your option: " );
      user_choice = scan.nextInt();
      scan.nextLine();

      switch ( user_choice ) {
        case 1:
          String temp_domain;
          int temp_publications;

          getStaffInfo();

          System.out.print ( "Enter Staff Domain: " );
          temp_domain = scan.nextLine();

          System.out.print ( "Enter Staff Publications: " );
          temp_publications = scan.nextInt();

          teach [ ++counter["teach"] ] = new Teaching ( temp_sid, temp_name, temp_phone, temp_salary, temp_domain, temp_publications );
          teach [ counter["teach"] ].display_teaching_details();
          break;
      
        default:  
          break;
      }
    }
  }
}

public class Staff {

  String staff_id;
  String name;
  int phone;
  int salary;

  public Staff ( String staff_id, String name, int phone, int salary ) {

    this.staff_id = staff_id;
    this.name = name;
    this.phone = phone;
    this.salary = salary;
  }

  public void display() {

    System.out.println ( "Staff ID: " + staff_id );
    System.out.println ( "Staff Name: " + name );
    System.out.println ( "Staff Phone: " + phone );
    System.out.println ( "Staff Salary: " + salary );
  }
}

public class Teaching extends Staff {

  String domain;
  int publications;

  public Teaching ( String staff_id, String name, int phone, int salary, String domain, int publications ) {

    super ( staff_id, name, phone, salary );
    this.domain = domain;
    this.publications = publications;
  }

  public void display_teaching_details() {

    super.display();
    System.out.println ( "Staff Domain: " + domain );
    System.out.println ( "Staff Publications: " + publications );
  }
}

public class Technical extends Staff {
  
  String skills;

  public Technical ( String staff_id, String name, int phone, int salary, String skills ) {
    
    super ( staff_id, name, phone, salary );
    this.skills = skills;
  }

  public void display_technical_details() {

    super.display();
    System.out.println ( "Staff Skills: " + skills );
  }
}

public class Contract extends Staff {
  
  int period;

  public Contract ( String staff_id, String name, int phone, int salary, int period ) {
    
    super ( staff_id, name, phone, salary );
    this.period = period;
  }

  public void display_technical_details() {

    super.display();
    System.out.println ( "Staff Skills: " + period );
  }
}










































