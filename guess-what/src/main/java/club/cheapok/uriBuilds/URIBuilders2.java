package club.cheapok.uriBuilds;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;

public class URIBuilders2 {

    public static void main(String[] args) {
        URI uri = null;
        String deviceCLLI = "ALTACAAL00W";
        String postStagingTemplateName = "PostStaging-" + deviceCLLI;
        String deviceGroupName = "SdwanDeviceWorkflow-" + deviceCLLI;

        String versaBaseUrl = "https://96.118.247.58:9183";
        String path = new StringBuilder("nextgen/binddata/templateData/template/")
            .append(postStagingTemplateName).append("/")
            .append("devicegroup").append("/")
            .append(deviceGroupName).toString();

        try {
            uri = new URIBuilder(versaBaseUrl).setPath(path)
                                              .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println(uri.toString());
    }

}
