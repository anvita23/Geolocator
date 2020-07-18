package com.test.com;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import org.json.simple.JSONObject;
public class Send_HTTP_Request2 {
	public static void main(String[] args) {
     try {
         Send_HTTP_Request2.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws IOException {
     String url = "http://api.ipinfodb.com/v3/ip-city/?key=235e4582ef0437ba419e6f8c1ff70f0fac7d694d6cc4ec9095d94262e4f1064f&ip=122.170.50.209&format=json";
     try{
//to handle NoRouteToHostException
	URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     con.setRequestMethod("POST");
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
}
catch(Exception ex){
	e.printStackTrace();
}
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     try {
//To handle FileNotFoundException
   	  //putting the values in a json file
        FileWriter file = new FileWriter("E:/output.json");
        file.write(response.toString());
        file.close();
     } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
   }
}
