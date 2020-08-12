package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("/batches")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatchResource {
    private static final Logger LOG = LoggerFactory.getLogger(BatchResource.class);


    @GET
    public Response getBatches() {
        LOG.info("Get all Batches");
        List<FullBatchDTO> listFullBatchDTO = new ArrayList<>();
        listFullBatchDTO.add(new FullBatchDTO(
                1,
                "MJ-Wein",
                2020,
                "Portwein",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Garten Lohring und Wilde Baeume an der RUB",
                LocalDateTime.now(),
                "Apefel waren ueberreif"));
        listFullBatchDTO.add(new FullBatchDTO(
                2,
                "MJ-Wein",
                2020,
                "Sherry",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Garten Lohring und Wilde Baeume an der RUB",
                LocalDateTime.now(),
                "Apefel waren ueberreif"));
        return Response.ok().entity(listFullBatchDTO).build();  // create listFUllBatchDTO !!
    }
}
