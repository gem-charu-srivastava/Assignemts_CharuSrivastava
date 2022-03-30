import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpClient;

public class httpclient {
    public static void main(String[] args)  {
        try{
            String result = sendPOST("https://reqres.in/api/users");
            System.out.println(result);
        }catch (IOException e) {
            e.printStackTrace();
        }
        }

    private static String sendPOST(String url)throws IOException {
        CloseableHttpClient httpClient= HttpClients.createDefault();
        String result="";

        HttpPost post = new HttpPost(url);
        post.addHeader("Accept","application/json");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer 4ef6418acd0e6cd51f0d234a06cc6bd488d1b7be4e840a3a14b3c908a7c1fc8a");


        JSONObject testcase = new JSONObject();
        testcase.put("name", "Charu Srivastava");
        testcase.put("job", "Graduate Engineer Trainee");

        post.setEntity(new StringEntity(testcase.toString()));
        CloseableHttpResponse response = httpClient.execute(post);
        result = EntityUtils.toString(response.getEntity());

        return result;
    }}



