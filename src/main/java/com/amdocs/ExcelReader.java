
package com.amdocs;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExcelReader
{ 	public static String dateOfBirth;
	public static String dateAsString;
	public static Cell name;
	public static Cell mailId;
	public static Cell teamEmail;
	
	
    public String XLSX_FILE_PATH;
    static ArrayList<Employee> employeeDetails = new ArrayList<Employee> ();
   

    public ArrayList<Employee> readInput() throws IOException, InvalidFormatException, ParseException 
    {
    	
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ConfigurationReader configurationReader = applicationContext.getBean(ConfigurationReader.class);
		
		XLSX_FILE_PATH=configurationReader.getExcelFilePath();
    	
    	Workbook workbook = WorkbookFactory.create(new FileInputStream(XLSX_FILE_PATH));
        Sheet sheet = workbook.getSheetAt(0);
     
       for (Row row: sheet) {
        	if(row.getRowNum()==0 || row.getRowNum()==1){
        		   continue; 
        		  }
        	Cell cell = row.getCell(2);
            if (cell != null) {
            	dateOfBirth = cell.getStringCellValue();
            	validateDate(row);
            }
        }
        workbook.close();
        return employeeDetails;
    }
    
   
    public void validateDate(Row row) {
    	
    	CurrentDate currentDate = new CurrentDate();
		dateAsString =currentDate.getCurrentDate();
		
		if(dateOfBirth.equals(dateAsString))
      	{
    		Employee employee = new Employee();
    		Cell name=row.getCell(1);
    		employee.setName(name.toString());
    		Cell mailId=row.getCell(3);
    		employee.setEmail(mailId.toString());
    		Cell teamMail=row.getCell(4);
    		employee.setTeamEmail(teamMail.toString());
    		
    		employeeDetails.add(employee);
    }
		
		
    	
    }
    
  
    
   
    
}