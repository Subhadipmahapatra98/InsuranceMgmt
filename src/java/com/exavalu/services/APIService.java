/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.APIUser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 *
 * @author Avijit Chattopadhyay
 */
public class APIService {
    
    public static APIService loginService = null;
    
    private APIService(){}
    
    public static APIService getInstance()
    {
        if(loginService==null)
        {
            return new APIService();
        }
        else
        {
            return loginService;
        }
    }
    
    public static APIUser consumePolicyDataFromAPI() throws ParseException, org.json.simple.parser.ParseException{
        
        //String result = null;
        //ArrayList<APIUser> policyList = new ArrayList();
        APIUser apiUser = new APIUser();
         try {

		URL url = new URL("https://mocki.io/v1/db7b49d2-0366-462f-8f9f-2fc8b4dde705");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                else{
                    
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());
                    while(scanner.hasNext()){
                        inline += scanner.nextLine();
                    }
                    scanner.close();
                    JSONParser parse = new JSONParser();
                    JSONArray jsonArray = (JSONArray)parse.parse(inline);
                    //JSONArray jsonArray = data_obj.getJSONArra("languages");
                     System.out.println("Size of Json List"+jsonArray.size());
                    for(int i = 0; i < jsonArray.size(); i++){
                        
                        
                        JSONObject obj = (JSONObject)jsonArray.get(i);
                        String policyNumber = obj.get("policyNumber").toString();
                        String coverageValue = obj.get("premiumAmount").toString();
                        String premiumAmount = obj.get("coverageValue").toString();
                        String premiumExpiry = obj.get("policyExpiry").toString();
                        
                        
                        apiUser.setPolicyNumber((policyNumber));
                        apiUser.setCoverageValue(Integer.parseInt(coverageValue));
                        apiUser.setPremiumAmount(Integer.parseInt(premiumAmount));
                        apiUser.setPremiumExpiry(premiumExpiry);
                       
                        
                    }
                   
                    
                }
                 

	  } catch (MalformedURLException ex) {

             Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());

	  } catch (IOException ex) {

             Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());

	  }
          return apiUser;
	}
    
    
    public static APIUser consumeDriverDataFromAPI() throws ParseException, org.json.simple.parser.ParseException{
        
        //String result = null;
        //ArrayList<APIUser> policyList = new ArrayList();
        APIUser apiUser1 = new APIUser();
         try {

		URL url = new URL("https://mocki.io/v1/34e6ad4e-5c6e-4eb0-bfbf-7d195206f0aa");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                else{
                    
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());
                    while(scanner.hasNext()){
                        inline += scanner.nextLine();
                    }
                    scanner.close();
                    JSONParser parse = new JSONParser();
                    JSONArray jsonDriver = (JSONArray)parse.parse(inline);
                    //JSONArray jsonArray = data_obj.getJSONArra("languages");
                     System.out.println("Size of Driver Json List"+jsonDriver.size());
                    for(int i = 0; i < jsonDriver.size(); i++){
                        
                        
                        JSONObject obj = (JSONObject)jsonDriver.get(i);
                        String driverLiscenceNo = obj.get("driverLiscenceNo").toString();
                        String driverName = obj.get("driverName").toString();
                        String drivingHistory = obj.get("drivingHistory").toString();
                        String liscenceValidity = obj.get("liscenceValidity").toString();
                        
                        System.out.println("Size of Driver Json List"+ driverName);
                        
                        apiUser1.setDriverLiscenceNo(driverLiscenceNo);
                        apiUser1.setDriverName(driverName);
                        apiUser1.setDrivingHistory(drivingHistory);
                        apiUser1.setLiscenceValidity(liscenceValidity);
                        System.out.println("Size of Driver Json List" + apiUser1.getDriverLiscenceNo());
                       
                        
                    }
                   
                    
                }
                 

	  } catch (MalformedURLException ex) {

             Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());

	  } catch (IOException ex) {

             Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());

	  }
          return apiUser1;
	}


   
    
    
    
}
