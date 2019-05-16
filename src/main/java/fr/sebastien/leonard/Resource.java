package fr.sebastien.leonard;

import com.google.gson.Gson;
import fr.sebastien.leonard.model.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/")
public class Resource {

    @GET
    public Response onGet() {
        return Response.status(200).entity("Hello, World!").build();
    }

    @PUT
    public Response onPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return Response.status(200).entity("A").build();
    }

}
