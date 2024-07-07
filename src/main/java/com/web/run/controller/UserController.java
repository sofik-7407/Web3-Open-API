package com.web.run.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.web.run.model.LoginRS;
import com.web.run.model.RegistrationRS;
import com.web.run.model.UserLoginRQ;
import com.web.run.model.UserRegistrationRQ;

import netscape.javascript.JSObject;



@RestController
@RequestMapping(path ="api/v1/user")
public class UserController {

	@PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrationRS> registerUser(@RequestBody UserRegistrationRQ request) {
		String email = request.getEmail();
		String pasword = request.getPassword();
		String url = "http://localhost:5001/register";
		String response = "";
		RegistrationRS registrationResponse = null;
		if (!email.isEmpty() && !pasword.isEmpty()) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String reqStr = objectMapper.writeValueAsString(request);
				response = sendPostRequest(url, reqStr);
				System.out.println("response "+response);
				registrationResponse = objectMapper.readValue(response, RegistrationRS.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginRS> loginUser(@RequestBody UserLoginRQ request) {
		String email = request.getEmail();
		String pasword = request.getPassword();
		String url = "http://localhost:5001/login";
		String response = "";
		LoginRS loginRes=null;
		if (!email.isEmpty() && !pasword.isEmpty()) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String reqStr = objectMapper.writeValueAsString(request);
				response = sendPostRequest(url, reqStr);

				loginRes = objectMapper.readValue(response, LoginRS.class);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(loginRes, HttpStatus.OK);
	}

	private static String sendPostRequest(String url, String jsonData) throws Exception {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = jsonData.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} else {
			return "POST request failed with response code: " + responseCode;
		}
	}
}
