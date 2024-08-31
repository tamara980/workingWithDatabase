package databaseTestingWorkbenech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCasesTestingDatabase {
	
	//WebDriver driver = new ChromeDriver();
	Connection con;
	Statement stmt;
	ResultSet rs;
	Random rand =new Random();
	@BeforeTest
	public void setup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Tamtt1998###");
		
	}
	
	@Test (priority= 1)
	public void test1ToGetData () throws SQLException {
		stmt = con.createStatement();
		rs= stmt.executeQuery("select * from customers where customerNumber =129 ");
		while(rs.next()) {
			int customerNO = rs.getInt("customerNumber");
			String customerName =rs.getString("customerName");
			String customerAddress = rs.getString("addressLine1");
			System.out.println(customerNO);
			System.out.println(customerName);
			System.out.println(customerAddress);}}
		
		@Test (priority= 2)
		public void AddData() throws SQLException{
			int randomCustomerNumber = rand.nextInt(999)* rand.nextInt(232);
			System.out.println(randomCustomerNumber);
			String query = "insert Into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit)"
					+ "values ("+randomCustomerNumber+",'tamat','tam','dab','0232','ash','ash2','amman','eww','3213','jordan',1002,99.32); ";
					//String query= "insert Into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit)"
						//	+ "values (1011,'tamat','tam','dab','0232','ash','ash2','amman','eww','3213','jordan',1002,99.32);"
						//	+ "insert Into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit)"
						//	+ "values (1012,'tamat','tam','dab','0232','ash','ash2','amman','eww','3213','jordan',1002,99.32);";
							
			stmt= con.createStatement();
			int rowInserted= stmt.executeUpdate(query);
			System.out.println(rowInserted);
			
			
		}
		@Test (priority= 3)
		public void UpdateData() throws SQLException{
		String query= "update customers set customerName ='Tamara1s' where customerNumber= 37668;";
		stmt= con.createStatement();
		int rowUpdated = stmt.executeUpdate(query);
		System.out.println(rowUpdated);
		Statement stmt2;
		String query2= "Select * from customers where customerNumber= 37668;";
		stmt2= con.createStatement();
		rs= stmt2.executeQuery(query2);
		while(rs.next()) {
			String name= rs.getString("customerName");
			int id = rs.getInt("customerNumber");
			System.out.println(name); System.out.println(id);
		}}
	
	

        @Test (priority= 4)
        public void DeleteData() throws SQLException{
        String query= " DELETE FROM customers WHERE customerNumber = 1001;";
        stmt= con.createStatement();
        int rowdeleted= stmt.executeUpdate(query);
        System.out.println(rowdeleted);
        
        }
        }




