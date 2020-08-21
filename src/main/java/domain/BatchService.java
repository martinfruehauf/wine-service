package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class BatchService {
    @Inject
    private BatchRepository batchRepository;

    private static final Logger LOG = LoggerFactory.getLogger(BatchService.class);

    List<Batch> batchList; //Mocking the dataset

    public BatchService() {
    }

    public List<Batch> getAllBatches() {
        LOG.info("Get all Batches");

        return batchRepository.getBatches();
    }

    public Batch getBatchById(final long batchId) {
        LOG.info("Get Batch by id: {}", batchId);
        Batch batch = batchRepository.getBatchById(batchId);
        if (batch == null) {
            LOG.info("Batch by id {} does not exist", batchId);
            throw new IllegalArgumentException("Could not find batch with id: " + batchId);
        }
        return batch;
    }

}
