package api.test;

import org.testng.annotations.*;
import api.utilities.*;
import io.restassured.response.Response;
import api.endpoints.UserEndPoints;
import api.payload.*;
public class DatadrivenTest {

	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	
	public void testPostUser(String userId,String userName,String firstName,String lastName, String useremail, String password, String phoneNumber) {}
		
	User userPayload= new User();
	
	userPayload.setId(Integer.parseInt(userId));
	userPayload.setUsername(userName);
	userPayload.setFirstName(firstName);
	userPayload.setLastName(lastName);
	userPayload.setEmail(userEmail);
	userPayload.setPassword(password);
	userPayload.setPhone(phoneNumber);
	
	Response response = UserEndPoints.createUser(userPayload);
	Assert.assertEquals(response.getStatusCode(),200);
	
	
	
}
