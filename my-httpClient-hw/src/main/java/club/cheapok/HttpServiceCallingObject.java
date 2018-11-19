package club.cheapok;

import club.cheapok.model.SomePost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpServiceCallingObject {


    CloseableHttpClient httpclient = HttpClients.createDefault();

    HttpUriRequest getRequest = RequestBuilder.create("GET")
                                              .setUri("http://jsonplaceholder.typicode.com/posts")
                                              .addHeader("Content-Type", "application/json")
                                              .build();


    public HttpServiceCallingObject() {
    }

    public HttpResponse makeGetCall() throws IOException {
        return httpclient.execute(getRequest);
    }

    public List<SomePost> getPosts() throws IOException {
        CloseableHttpResponse response = httpclient.execute(getRequest);
        HttpEntity entity = response.getEntity();

        //one way ... but better use EntityUtils :)
        String responseString = EntityUtils.toString(entity);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<SomePost>>() {
        }.getType();
        List<SomePost> posts = gson.fromJson(responseString, listType);
        return posts;
    }


}
