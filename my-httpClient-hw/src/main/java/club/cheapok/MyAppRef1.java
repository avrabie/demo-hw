package club.cheapok;

import club.cheapok.model.SomePost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MyAppRef1 {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpUriRequest getRequest = RequestBuilder.create("GET")
                                           .setUri("https://jsonplaceholder.typicode.com/posts")
                                           .addHeader("Content-Type","application/json")
                                           .build();

//        HttpGet httpRequest = new HttpGet("https://jsonplaceholder.typicode.com/posts");

        CloseableHttpResponse response = httpclient.execute(getRequest);
        HttpEntity entity = response.getEntity();

        //one way ... but better use EntityUtils :)
        String responseString = EntityUtils.toString(entity);
        System.out.println(responseString);

//        System.out.println(sb.toString());

        //make your json into an object
        Gson gson = new Gson();
        Type listType = new TypeToken<List<SomePost>>() {
        }.getType();
        List<SomePost> posts = gson.fromJson(responseString, listType);
//        posts.stream().forEach(System.out::println);

    }

}
