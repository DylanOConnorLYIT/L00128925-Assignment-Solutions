package ie.lyit.serialize;
import ie.lyit.hotel.Customer;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import dao.customerDao;

public class CustomerSerializer implements customerDao {

 private ArrayList<Customer> customers;
	
	private final String FILENAME = "customers.ser";	
	
	
	public CustomerSerializer(){
		
		customers = new ArrayList<Customer>();
	}
	//This method adds the Customer details to the arraylist.
	public void add()
	{
		
		Customer customer = new Customer();
		
		customer.read();	
		
		customers.add(customer);
	}
	//This will list the customers in the arraylist
	public void list()
	{
		
        for(Customer tmpCustomer:customers)
			
			System.out.println(tmpCustomer);
	}
	//This will give you the option to a view a specific customer
	public Customer view()
	{
		Scanner keyboardIn = new Scanner(System.in);		

		
		System.out.println("ENTER NUMBER OF CUSTOMER : ");
		int customerToView=keyboardIn.nextInt();
		
		
	    for(Customer tmpCustomer:customers){
		   
		   if(tmpCustomer.getNumber() == customerToView)
		   {
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    
	    
	   
	    return null;		
	}
	//Lets you edit a specific customer within the arraylist
	public void edit()
    {	
		
		Customer tempCustomer = view();
	    if(tempCustomer != null){
		 
		   int index=customers.indexOf(tempCustomer);
		  
		   tempCustomer.read();
		   
		   customers.set(index, tempCustomer);
	    }
	}
	//Used to delete a specific customer within the arraylist
	public void delete()
	{	
		
		Customer tempCustomer = view();
		
	    if(tempCustomer != null)
		   
	       customers.remove(tempCustomer);
	}
	
	
	public void writeRecordsToFile()
	{
		ObjectOutputStream os=null;
		try 
		{
			
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			os = new ObjectOutputStream(fileStream);
				
			os.writeObject(customers);
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot create file to store customers.");
		}
		catch(IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
		finally 
		{
			try 
			{
				os.close();
			}
			catch(IOException ioE)
			{
				System.out.println(ioE.getMessage());
			}
		}
	}
	public void readRecordsFromFile()
	{
		try
		{
			
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream is = new ObjectInputStream(fis);

			
			customers = (ArrayList<Customer>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot find customers file.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}				
	}
	//Trying to set a counter for the arraylist for the customer number to that it implements each time called.
	public int countNumberEqual(ArrayList<Customer> itemList, Customer itemToCheck)
	{
	    int count = 0;
	    for (Customer i : itemList) {
	        if (i.equals(itemToCheck)) {
	          count++;
	        }
	    }
	    return count;
	}


}
