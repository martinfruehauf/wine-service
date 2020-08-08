package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/batches")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatchResource {
    private static final Logger LOG = LoggerFactory.getLogger(BatchResource.class);

    @GET
    public Response getBatches() {
        return Response.ok().entity(listFullBatchDTO);  // create listFUllBatchDTO !!
    }
}
