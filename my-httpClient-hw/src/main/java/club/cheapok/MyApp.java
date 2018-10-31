package club.cheapok;

import club.cheapok.model.SomePost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class MyApp {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpRequest = new HttpGet("https://jsonplaceholder.typicode.com/posts");

        CloseableHttpResponse response = httpclient.execute(httpRequest);
        HttpEntity entity = response.getEntity();

        //one way ... but better use EntityUtils :)
        InputStream content = entity.getContent();
        InputStreamReader inputStreamReader = new InputStreamReader(content);
        char[] buffer = new char[1024];
        StringBuilder sb = new StringBuilder();
        int len;
        while ((len = inputStreamReader.read(buffer)) != -1) {
            sb.append(buffer, 0, len);
        }
//        System.out.println(sb.toString());

        //make your json into an object
        Gson gson = new Gson();
        Type listType = new TypeToken<List<SomePost>>() {
        }.getType();
        List<SomePost> posts = gson.fromJson(sb.toString(), listType);
        posts.stream().forEach(System.out::println);
    }

}
