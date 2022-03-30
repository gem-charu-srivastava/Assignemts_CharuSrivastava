import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

    public class httpurlconnection{
        public static void main(String[] args) throws IOException {
            try {
                URL url = new URL("https://reqres.in/api/users");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setDoInput(true);
                conn.setDoOutput(true);

                conn.setRequestMethod("POST");
//            conn.setAuthenticator();
                conn.setRequestProperty("Authorization", "Bearer 4ef6418acd0e6cd51f0d234a06cc6bd488d1b7be4e840a3a14b3c908a7c1fc8a");

                conn.setRequestProperty("Content-Type","application/json");

                String input = "{\"qty\" : 100,\"name\" : \"iPad 4\"}";
                OutputStream os = conn.getOutputStream();
                os.write(input.getBytes());
                os.flush();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String output;
                System.out.println("Output from Server....\n");
                while  ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
                conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }


        }
    }

