package com.amdocs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CurrentDate 
{
	
	public String getCurrentDate() 
	{    
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");  
		   LocalDateTime dateNow = LocalDateTime.now(); 
		   
		   return dtf.format(dateNow);  
	}

}
