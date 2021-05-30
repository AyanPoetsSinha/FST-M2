import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Tests {
	// Declare request specification
    RequestSpecification requestSpec;
    // Declare response specification
    ResponseSpecification responseSpecPost;
    ResponseSpecification responseSpecGet;
    ResponseSpecification responseSpecDel;
    
    String ssh;
    int token_id;
    AuthenticationScheme token_st;
    
    @BeforeClass
    public void setUp() {
    	 requestSpec = new RequestSpecBuilder()
                 // Set content type
                 .setContentType(ContentType.JSON)
                 .addHeader("Authorization", "token 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")
               // Set base URL
                 .setBaseUri("https://api.github.com")
                 
                 // Build request specification
                 .build();
    	 responseSpecPost = new ResponseSpecBuilder()
                 // Check status code in response
                 .expectStatusCode(201)
                 // Check response content type
                 .expectContentType("application/json")
                 // Check if response contains name property
              //   .expectBody("status", equalTo("alive"))
                 // Build response specification
                 .build();
    	 responseSpecGet = new ResponseSpecBuilder()
                 // Check status code in response
                 .expectStatusCode(200)
                 // Check response content type
                 .expectContentType("application/json")
                 // Check if response contains name property
              //   .expectBody("status", equalTo("alive"))
                 // Build response specification
                 .build();
    	 responseSpecDel = new ResponseSpecBuilder()
                 // Check status code in response
                 .expectStatusCode(204)
                 // Check response content type
                 .expectContentType("application/json")
                 // Check if response contains name property
              //   .expectBody("status", equalTo("alive"))
                 // Build response specification
                 .build();
    	
    	
    	 ssh="ssh-rsa AAAAB3NzaC1yc2";
    }
    
    @Test(priority=1)
    public void addToken() {
    //	String ROOT_URI="https://api.github.com/user/keys";
    	String reqBody = "{\n" + 
    			"    \"title\": \"TestAPIKey\",\n" + 
    			"    \"key\": \"ssh-rsa AAArMl8bjHKHt1qQQ7gbwtNVrOxKt8Zb6ipWtp0KkvB98XkU3cOxzt92JR1/T4UXHWpZYlydmu2SBLLQ1rvnUDgaB9CpbPqp1KUPru00bdyOCzutqDpyT/YJIk5PsXA8nwsG7Lp3Ey0i18HWvfZ/jJtMd3TgEQPqjWiTp7++KIZZI13HE8aFBiMKvy3ifQ8xAuCmm6xUufGO859yOPuGrwlPXzEFeEFcM5tKertTBU1kLZPEzqMnUJ0wixNN0Ifxfe3UeTHEjzHqLDDRamDmkyCcnS1tBehHcN/U3MfYv5XWAfxp1y+Nftu9tERDQxxcwug9mf66FJomBrOQ5pGcMA6gCA75SsYxTMIiqn28WszBSTSruGcSXB6amc7L+aU+AlgdjNGxUDZxXei3pdubuEUmHFtYPxUM7nWhlIYyiVmaz8dEHMJGd4jI2Lrao3Pm1G7tZmg8h6fzQk1G+8QqAkCoqTHKIHCvwnnvN81Xa4yt9a+uzCIa5F2LTz5Ck=" + 
    			"\"\n" + 
    			"}";
    	
        Response response = given()
        		
        		.contentType(ContentType.JSON)
        		
        		.spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post("/user/keys"); // Send POST request
        String resbody=response.getBody().asPrettyString();
        System.out.println(resbody);
        token_id = response.then().extract().path("id");
        System.out.println(token_id);
        //String responseJSON_status = response.then().extract();
      // System.out.println(responseJSON_status); 
        //Saving the token
        
      // token= response.then().extract().path("key");
     // Assertion for status of PostToken
       response.then().statusCode(201);
    }
    @Test(priority=2)
    public void getToken() {
    	Response response = given().spec(requestSpec) // Use requestSpec
				.when().get("/user/keys"); // Send GET Request
		String resBody = response.getBody().asPrettyString();
		System.out.println(resBody);
		// Assertions
		response.then().statusCode(200);
    	
    }
    @Test(priority=3)
    public void deleteToken() {
    	Response response = given().spec(requestSpec) // Use requestSpec
				.pathParam("keyId", token_id).when().delete("/user/keys/{keyId}"); // Send GET Request
		String resBody = response.getBody().asPrettyString();
		System.out.println(resBody);
		// Assertions
		response.then().statusCode(204);
    	
    }
}
