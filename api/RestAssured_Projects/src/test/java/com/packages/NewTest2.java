package com.packages;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;

public class NewTest2 {
  @Test
  public void GetPetDetails() {
      // Specify the base URL to the RESTful web service
      baseURI = "https://petstore.swagger.io/v2/pet";

      
	// Make a request to the server by specifying the method Type and 
      // resource to send the request to.
      // Store the response received from the server for later use.
      Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .when().get("/findByStatus?status=sold"); // Run GET request
   // Extract status from response
      String responseJSON_status = response.then().extract().path("[0].status");
      System.out.println("The Status is "+ responseJSON_status);

      //Extract name from response
      String responseJSON_name = response.then().extract().path("[0].name");
      System.out.println("Name is "+ responseJSON_name);
  
      
      
  }
  
  @Test (priority=2)
  public void GetAssertion() {
	  Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .when().get("/findByStatus?status=sold"); // Run GET request
	  // Assertion for status of pet
      response.then().extract().path("[0].status").equals("sold");
  }

  
  
  @Test (priority=3)
  public void sendPost() {
	  String ROOT_URI="https://petstore.swagger.io/v2/pet";
      String reqBody = "{"
    			
            + "\"id\": 77232,"
	
            + "\"name\": \"Riley\","
	
            + " \"status\": \"alive\""
	
        + "}";
	  Response response= given().contentType(ContentType.JSON)//Set Headers
	  .body(reqBody)
	  .when()
	  .post(ROOT_URI);//Send Post request
	  
	  
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println("The body is"+ body);
	  
  }
  }

