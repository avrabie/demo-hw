package club.cheapok.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class Hello {
    @GET
    public String iaka() {
        return "Iaka guessed";
    }
}
