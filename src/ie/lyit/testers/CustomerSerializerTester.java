package ie.lyit.testers;
import ie.lyit.serialize.*;
import ie.lyit.files.Menu;
import dao.customerDao;
public class CustomerSerializerTester 
{




	public static void main(String[] args) 
	{
		
		CustomerSerializer customerSerializer = new CustomerSerializer();
		
		customerSerializer.readRecordsFromFile();
		
		customerDao customersDao = new CustomerSerializer();
		
	   
		Menu menuObj = new Menu();
		
		do
		{
			
			menuObj.display();
			
			menuObj.readOption();
			
			switch(menuObj.getOption()){
			   case 1:customerSerializer.add();break;
			   case 2:customerSerializer.list();break;
			   case 3:customerSerializer.view();break;
			   case 4:customerSerializer.edit();break;
			   case 5:customerSerializer.delete();break;
			   case 6:break;				
			   default:System.out.println("INVALID OPTION...");
			}
		}while(menuObj.getOption() != 6);	
																			
				
		customerSerializer.writeRecordsToFile();
	}
}


