package club.cheapok.uriBuilds;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;

public class uriBuilders {

    private static final String AUTH_TOKEN_URL = "iaka1";
    private static String AUTH_BASE_URL = "https://cheapok.club";

    public static void main(String[] args) {
        URI uri;
        try{
            uri = new URIBuilder(AUTH_BASE_URL).setPath(AUTH_TOKEN_URL).build();
            System.out.println("Here: "+uri.toString());


        } catch (URISyntaxException exception){
            System.out.println(
                String.format("Bad URI syntax received from baseURL: %s and path: %s", AUTH_BASE_URL, AUTH_TOKEN_URL));

        }
    }

}
