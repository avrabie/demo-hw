package club.cheapok.apacheHttsServers.theclassic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setDoOutput(true);

        //params
        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val");

        DataOutputStream out = new DataOutputStream(con.getOutputStream());
//        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));

        con.setRequestProperty("Content-Type", "application/json");
        String contentType = con.getHeaderField("Content-Type");
        System.out.println(contentType);

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        String cookiesHeader = con.getHeaderField("Set-Cookie");
        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);

//        cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));



//        HttpClient httpClient = HttpClient.newHttpClient();

    }

}
