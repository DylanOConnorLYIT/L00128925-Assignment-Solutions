package ie.lyit.hotel;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Customer extends Person implements Serializable
{
	private String emailAddress;   
	private int number;			    

	private static int nextNumber=1;
	
	
	public Customer()
	{
		super();			
		emailAddress=null;
		
		number=nextNumber++;
	}
	
	
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email)
	{
		
		super(t, fN, sn, address, pNo);
		
		emailAddress=email;
		
		number=nextNumber++;
	}

	//Here is my to string method
	@Override
	public String toString()
	{
		return super.toString() + "," + emailAddress;
	}

	//EqualsTo method
	@Override
	public boolean equals(Object obj)
	{
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress()
	{
		return this.emailAddress;
	}	
	
	public int getNumber(){
		return number;
	}
	//This method reads in what the user enters
	   public void read()
	   {
	      JTextField txtNumber = new JTextField();
	      txtNumber.setText("" + this.getNumber());
	      JTextField txtTitle = new JTextField();
	      txtTitle.requestFocus();
	      JTextField txtfirstName = new JTextField();
	      JTextField txtlastName = new JTextField();
	      JTextField txtAddress = new JTextField();
	      JTextField txtEmailAddress = new JTextField();
	      JTextField txtPhoneNumber = new JTextField();

	      Object[] message = 
	    	  {
	          "Please enter the Number:", txtNumber,
	          "Enter the Title:", txtTitle,
	          "Enter First Name:", txtfirstName,
	          "Enter last Name:", txtlastName,
	          "Please enter your Email Address:", txtEmailAddress,
	          "Please enter your Address:", txtAddress,
	          "Enter your Phone Number:", txtPhoneNumber,
	          };

	      int option = JOptionPane.showConfirmDialog(null, message, "Enter cutomer details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION)
	      {
	          //Super is calling the methods from the name class
	    	  super.name.setTitle(txtTitle.getText());
	          super.name.setFirstName(txtfirstName.getText());
	          super.name.setSurname(txtlastName.getText());
	          this.address = txtAddress.getText();
	          this.emailAddress = txtEmailAddress.getText();
	          this.phoneNumber = txtPhoneNumber.getText();
	      }   
		}
}
