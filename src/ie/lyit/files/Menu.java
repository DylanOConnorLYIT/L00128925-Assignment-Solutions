package ie.lyit.files;

import java.util.Scanner;

public class Menu 
{
   private int option;
   
   public void display()
   {
     System.out.println("\t1. Add a Customer");
	 System.out.println("\t2. List the Customers");
	 System.out.println("\t3. View a Customer");
	 System.out.println("\t4. Edit a Customer");
	 System.out.println("\t5. Delete a Customer");
	 System.out.println("\t6. Quit the Menu");		
   }
	
   public void readOption()
   {
      Scanner keyboardIn = new Scanner(System.in);
  	  System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
   	  option=keyboardIn.nextInt();
   }
					
	public int getOption()
	{
	   return option;
	}	
}