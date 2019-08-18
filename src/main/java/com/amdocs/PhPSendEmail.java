package com.amdocs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;

public class PhPSendEmail 
{
	static ArrayList<Employee> employeeDetails;
	
	PhPSendEmail(ArrayList<Employee> employeeDetails)
	{
		this.employeeDetails = employeeDetails;
	}
	
	private final static String USER_AGENT = "Mozilla/5.0";

	public void sendEmail() throws Exception 
	{
	
		for(Employee e : employeeDetails)
		{
			sendGet(e.getEmail(),e.getName(),e.getTeamEmail());
		}
		
		
	} 
	private static void sendGet(String email,String name,String dl) throws Exception 
	{

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("genproxy.amdocs.com",8080));
		
		String url = "http://unsuspicious-meetin.000webhostapp.com/SendEmail.php?email="+email+"&name="+name+"&dl="+dl;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);

		con.setRequestMethod("GET"); 
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) 
		{
			response.append(inputLine);
		} 
			 
		in.close();

		System.out.println(response.toString());

		} 
}
