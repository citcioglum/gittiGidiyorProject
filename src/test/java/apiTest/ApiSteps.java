package apiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class ApiSteps extends TestBaseApi{
    Response response;
@Test
    public void createBoard() {
       setUp();
       spec.pathParams("parametre1",1,"parametre2","boards");

        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name","apiTest");
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token",ConfigReader.getProperty("token"));

        System.out.println(requestBody);

        response =given().
                spec(spec).
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/{parametre1}/{parametre2}");

        response.prettyPrint();

    }
}
