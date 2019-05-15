package fr.sebastien.leonard;

import com.google.gson.Gson;
import fr.sebastien.leonard.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class Resource {

    private Client client = ClientBuilder.newClient();
    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        WebTarget target = client.target(System.getenv("URI"));
        Invocation.Builder builder = target.request();
        String json = builder.get(String.class);

        List<Book> list = this.gson.fromJson(json, ArrayList.class);
        return list.size() + " ";
    }

}
