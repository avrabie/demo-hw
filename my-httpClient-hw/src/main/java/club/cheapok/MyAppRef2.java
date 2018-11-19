package club.cheapok;

import com.sun.tools.internal.ws.processor.model.Request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.methods.RequestBuilder;

public class MyAppRef2 {

    public static void main(String[] args) throws IOException {
        String urlToRead = "https://jsonplaceholder.typicode.com/posts";
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            result.append(line);
        }
        br.close();
        System.out.println(result.toString());


    }

}
