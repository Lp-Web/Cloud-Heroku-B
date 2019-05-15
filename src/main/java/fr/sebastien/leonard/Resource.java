package fr.sebastien.leonard;

import com.google.gson.Gson;
import fr.sebastien.leonard.model.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class Resource {

    private Client client = ClientBuilder.newClient();

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            if(request.getParameter("idToAdd") == null || request.getParameter("numberToAdd") == null) {
                return Response.status(400).entity("You must give the idToAdd and numberToAdd in parameters of the request").build();
            }

            Long id = Long.parseLong(request.getParameter("idToAdd"));
            Long add = Long.parseLong(request.getParameter("numberToAdd"));

            WebTarget target = client.target(System.getenv("URI"))
                    .path("/")
                    .queryParam("idToAdd", id)
                    .queryParam("numberToAdd", add);

            Invocation.Builder builder = target.request();
            return builder.put(null);
        } catch (Exception ex) {
            return Response.status(400).entity("You must give the idToId, and numberToId in parameters of the request").build();
        }

    }

}
