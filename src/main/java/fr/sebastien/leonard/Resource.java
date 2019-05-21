package fr.sebastien.leonard;

import fr.sebastien.leonard.model.Book;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/")
public class Resource {

    private Client client = ClientBuilder.newClient();

    @PUT
    public Response onPut(
        @QueryParam("idToAdd") String id,
        @QueryParam("numberToAdd") Integer number
    ) {
        return client
                .target(System.getenv("URI"))
                .queryParam("idToAdd", id)
                .queryParam("numberToAdd", number)
                .request()
                .put(Entity.entity(new Book(), MediaType.APPLICATION_JSON));
    }

}
