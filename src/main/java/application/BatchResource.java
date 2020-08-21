package application;

import domain.Batch;
import domain.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/batches")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatchResource {
    private static final Logger LOG = LoggerFactory.getLogger(BatchResource.class);

    @Inject
    private BatchService batchService;

    public BatchResource() {
        LOG.info("Batch Resource created");
    }

    public BatchResource(final BatchService batchService) {
        this.batchService = batchService;
    }

    @GET
    public Response getBatches() {
        LOG.info("Get all Batches");
        List<FullBatchDTO> listFullBatchDTO = new ArrayList<>();
        for(Batch batch: batchService.getAllBatches()) {
            listFullBatchDTO.add(new FullBatchDTO(batch));
        }
        return Response.ok().entity(listFullBatchDTO).build();  // create listFUllBatchDTO !!
    }

    @GET
    @Path("/{batchId}")
    public Response getBatchById(@PathParam("batchId") final long batchId) {
        try {
            LOG.info("Get Batch by id: {}", batchId);
            Batch batch = batchService.getBatchById(batchId);
            FullBatchDTO fullBatchDTO = new FullBatchDTO(batch);
            return Response.ok().entity(fullBatchDTO).build();
        } catch (IllegalArgumentException e) {
            LOG.warn("Could not find batch by id: {}", batchId);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
