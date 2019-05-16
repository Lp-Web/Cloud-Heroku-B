package fr.sebastien.leonard;

import fr.sebastien.leonard.model.Book;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class Resource {

    private Client client = ClientBuilder.newClient();

    @PUT
    public Response onPut(
        @QueryParam("idToAdd") String id,
        @QueryParam("numberToAdd") Integer number
    ) {
        WebTarget target = client
                .target(System.getenv("URI"))
                .queryParam("idToAdd", id)
                .queryParam("numberToAdd", number);

        return target.request().put(Entity.entity(String.class, MediaType.APPLICATION_JSON));

        //target.request().buildPut(null).invoke();

        //Response response = target.request().buildPut(null).invoke();

        //return Response.status(200).entity(System.getenv("URI")).build();
    }

}
