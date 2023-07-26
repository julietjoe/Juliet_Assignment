package weather;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Assignment {

	public static void main(String[] args) throws Throwable, IOException 
	{
		int choice,condition;
		Scanner scanner1=new Scanner(System.in);
		 boolean flag = true;
		
		
		do 
		{
			System.out.println("................Weather Forcast................");
			System.out.println("Press 1 for getting Temperature Value");
			System.out.println("Press 2 for getting Wind Speed Value");
			System.out.println("Press 3 for getting pressure Value");
			
			choice=scanner1.nextInt();

			switch(choice) 
			{
			case 1:
				System.out.println("Enter the date (eg: 2019-03-27 18:00:00)");
	            scanner1.nextLine();
	            String date1 = scanner1.nextLine();   
		        
				URL url = new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");

				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();

				int responsecode = conn.getResponseCode();
				
				if (responsecode != 200) 
				{
				    throw new RuntimeException("HttpResponseCode: " + responsecode);
				} 
				else 
				{
				  
				    String inline = "";
				    Scanner scanner = new Scanner(url.openStream());
				  
				    while (scanner.hasNext()) 
				    {
				       inline += scanner.nextLine();
				    }
				    
				    scanner.close();

				    JSONParser parse = new JSONParser();
				    JSONObject data_obj = (JSONObject) parse.parse(inline);

				    JSONArray jsonarray = (JSONArray) data_obj.get("list");

				   
				   for (int i = 0; i < jsonarray.size(); i++) 
				   {
		               JSONObject new_obj = (JSONObject) jsonarray.get(i);
		              // System.out.println(jsonarray.get(i));
		               
		               if (new_obj.get("dt_txt").equals(date1)) 
		               {
		                   //System.out.println("All weather value: " + new_obj.get("main"));
		                   JSONObject climate_Object =(JSONObject) new_obj.get("main");
		                  // System.out.println(climate_Object);
		                   System.out.println("\nTemperature value corresponding to " +date1+ " is: " + climate_Object.get("temp"));
		                   break;
		               }
		           }
				   
				}
				
				break;
			case 2:
				System.out.println("Enter the date (eg: 2019-03-27 18:00:00)");
	            scanner1.nextLine();
	            String date2 = scanner1.nextLine(); 
		        
				URL url2 = new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");

				HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
				conn2.setRequestMethod("GET");
				conn2.connect();

				//Getting the response code
				int responsecode2 = conn2.getResponseCode();
				
				if (responsecode2 != 200) {
				    throw new RuntimeException("HttpResponseCode: " + responsecode2);
				} 
				else 
				{
				  
				    String inline = "";
				    Scanner scanner = new Scanner(url2.openStream());
				  
				    while (scanner.hasNext()) 
				    {
				       inline += scanner.nextLine();
				    }
				    
				    //Close the scanner
				    scanner.close();

				    JSONParser parse = new JSONParser();
				    JSONObject data_obj = (JSONObject) parse.parse(inline);

				    JSONArray jsonarray = (JSONArray) data_obj.get("list");

				   for (int i = 0; i < jsonarray.size(); i++) 
				   {
		               JSONObject new_obj = (JSONObject) jsonarray.get(i);
		               //System.out.println(jsonarray.get(i));

		               if (new_obj.get("dt_txt").equals(date2))
		               {
		                   //System.out.println("All weather value: " + new_obj.get("main"));
		                   JSONObject climate_Object =(JSONObject) new_obj.get("wind");
		                   //System.out.println(climate_Object);
		                   System.out.println("\nWind Speed corresponding to " +date2+ " is: " + climate_Object.get("speed"));
		                   break;
		               }
		           }
				   
				}

				break;
			case 3:
				System.out.println("Enter the date (eg: 2019-03-27 18:00:00)");
	            scanner1.nextLine();
	            String date3 = scanner1.nextLine(); 
		        
				URL url3 = new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");

				HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
				conn3.setRequestMethod("GET");
				conn3.connect();

				//Getting the response code
				int responsecode3 = conn3.getResponseCode();
				
				if (responsecode3 != 200) {
				    throw new RuntimeException("HttpResponseCode: " + responsecode3);
				} 
				else 
				{
				    String inline = "";
				    Scanner scanner = new Scanner(url3.openStream());
				  
				   //Write all the JSON data into a string using a scanner
				    while (scanner.hasNext())
				    {
				       inline += scanner.nextLine();
				    }
				    
				    //Close the scanner
				    scanner.close();

				    JSONParser parse = new JSONParser();
				    JSONObject data_obj = (JSONObject) parse.parse(inline);

				    JSONArray jsonarray = (JSONArray) data_obj.get("list");

				    for (int i = 0; i < jsonarray.size(); i++) 
				    {

		               JSONObject new_obj = (JSONObject) jsonarray.get(i);
		              // System.out.println(jsonarray.get(i));

		               if (new_obj.get("dt_txt").equals(date3)) 
		               {
		                   //System.out.println("All weather value: " + new_obj.get("main"));
		                   JSONObject climate_Object =(JSONObject) new_obj.get("main");
		                  // System.out.println(climate_Object);
		                   System.out.println("\nPressure value corresponding to " +date3+ " is: " + climate_Object.get("pressure"));
		                   break;
		               }
		           }
				   
				}
				break;
			default:
			System.out.println("\nInvalid choice!! Please make a valid choice !!!");
	      }
			System.out.println("\nTo exit Press 0..To continue Press any number");
			condition=scanner1.nextInt();
			if(condition==0)
			{
                flag=false;
                System.out.println("Thank you for using this feature");
            }else
            {
                flag=true;
               
            }
		}while(flag);

	}

}
