package fr.sebastien.leonard;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("/")
public class Resource {

    @PUT
    public Response onPut(HttpServletRequest request) {

        return Response.status(200).entity("Hello, World!").build();
    }

}
