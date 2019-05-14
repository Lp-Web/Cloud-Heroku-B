package fr.sebastien.leonard;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class ResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Resource.class);
    }

    @Test
    public void testGetIt() {
        String response = target().path("/").request().get(String.class);
        Assert.assertThat(response, IsEqual.equalTo("Hello, World!"));
    }

}
