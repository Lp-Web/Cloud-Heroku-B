package fr.sebastien.leonard;

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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        String text = "Hello, World! " + client.target(System.getenv("URI"));

        WebTarget target = client.target(System.getenv("URI"));
        Invocation.Builder builder = target.request();
        List<Book> response = builder.get(List.class);

        for(Book book : response) {
            System.out.println(book.getId() + " " + book.getTitle());
        }

        return text;
    }

}
