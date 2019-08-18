package com.amdocs;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BirthdayWishApplication 
{
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ConfigurationReader configurationReader = applicationContext.getBean(ConfigurationReader.class);
		
		ExcelReader excelReader = new ExcelReader();
		
		ArrayList<Employee> employeeDetails = excelReader.readInput();
		
		PhPSendEmail phPSendEmail;
		
		if(employeeDetails.size()==0) {
			
			Employee employee = new Employee();
			employee.setEmail(configurationReader.getAdminEmail());
			employee.setName(configurationReader.getAdminName());
			employeeDetails.add(employee);
			
			phPSendEmail = new PhPSendEmail(employeeDetails);
		}else {
			phPSendEmail = new PhPSendEmail(employeeDetails);
		}
		
		phPSendEmail.sendEmail();
	}

}
