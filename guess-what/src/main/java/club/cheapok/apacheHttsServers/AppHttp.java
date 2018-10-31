package club.cheapok.apacheHttsServers;

import static org.apache.http.protocol.HTTP.USER_AGENT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class AppHttp {

    public static void main(String[] args) throws IOException {
        String url = "http://www.google.com/search?q=httpClient";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        System.out.println("Status code: "+response.getStatusLine()
                                   .getStatusCode());
        InputStream content = response.getEntity()
                                      .getContent();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

    }

}
