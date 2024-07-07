package com.web.run.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.run.model.HotelBookingRQ;
import com.web.run.model.HotelBookingRS;
import com.web.run.model.HotelRS;
import com.web.run.model.RegistrationRS;

@RestController
@RequestMapping("/v1")
public class HotelController {

    @GetMapping(value = "/getHotels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelRS> searchHotels(@RequestParam String token) {
    		String url="http://localhost:5001/get-hotel";
    		HotelRS hotelRes=null;
    		ObjectMapper objectMapper=new ObjectMapper();
    		try {
				String response=sendGetRequest(url,token);
				System.out.println("Respons "+response);
				hotelRes=objectMapper.readValue(response, HotelRS.class);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	return new ResponseEntity<>(hotelRes,HttpStatus.OK);
        
    }

    @PostMapping(value = "/hotels/book",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelBookingRS> bookHotel(@RequestHeader("token") String token, @RequestBody HotelBookingRQ request) {
    	 String url="http://localhost:5001/book-hotel";
    	 HotelBookingRS hotelBookingRS=null;
    	 try {
				ObjectMapper objectMapper = new ObjectMapper();
				String reqStr = objectMapper.writeValueAsString(request);
				 String response = sendPostRequest(url, token,reqStr);
				 System.out.println("Res: "+response);
				System.out.println("response "+response);
				hotelBookingRS = objectMapper.readValue(response, HotelBookingRS.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
    	
		return  new ResponseEntity<>(hotelBookingRS, HttpStatus.OK);
        
    }
    public static String sendGetRequest(String url, String token) throws IOException {
        URL apiUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // Set request method
        connection.setRequestMethod("GET");

        // Set headers
        connection.setRequestProperty("token", token);

        // Get response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read response body
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            responseBuilder.append(inputLine);
        }
        in.close();

        return responseBuilder.toString();
    }
    public static String sendPostRequest(String url, String token, String jsonRequest) throws IOException {
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("token", token);

        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonRequest.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        StringBuilder response = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
        } else {
            response.append("POST request failed with response code: ").append(responseCode);
        }
        return response.toString();
    }
}

