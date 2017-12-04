package dao;
import java.util.*;


import ie.lyit.hotel.Customer;
public interface customerDao {
	
	public void add();
	public void list();
	public Customer view();
	public void delete();
	public void edit();
	public void writeRecordsToFile();
	public void readRecordsFromFile();

}
