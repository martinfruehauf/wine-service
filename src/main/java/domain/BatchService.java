package domain;

import application.BaseBatchDTO;
import infrastructure.stereotypes.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

@Service
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

    public long addBatch(final BaseBatchDTO baseBatchDTO) {
        LOG.info("Add Batch");
        Batch batch = new Batch(baseBatchDTO);
        return batchRepository.addBatch(batch);
    }

    public void updateBatch(final long batchId, final BaseBatchDTO baseBatchDTO) {
        LOG.info("Update todo by id: {}", batchId);
        getBatchById(batchId);
        batchRepository.updateBatch(new Batch(batchId, baseBatchDTO));
    }

}
