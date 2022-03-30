import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;


public class requests {
    public static void main(String[] args) {
        RestAssured.baseURI="https://gorest.co.in/";
       RestAssured.basePath="public/v2/users";

        //GET

       /*Response res= (Response)given().when().get().getBody();
       // System.out.println(res.prettyPrint());*/


        //POST

        JSONObject postrequest = new JSONObject();

        postrequest.put("name","charu");
        postrequest.put("email","charusrivastava@gmail.com");
        postrequest.put("gender","female");
        postrequest.put("status","active");
        Response response = given()
                .header("Authorization","Bearer 569ee7ecec0fb28a04a820a482a90b2c689fbc10106c7d99760962b4caae674f ")
                .accept("application/json").contentType("application/json")
                .body(postrequest.toString()).log().all().when().post();
        System.out.println(response.prettyPrint());



    }
}
