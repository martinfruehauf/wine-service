package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BatchService {

    private static final Logger LOG = LoggerFactory.getLogger(BatchService.class);

    List<Batch> batchList; //Mocking the dataset

    public BatchService() {
        batchList = new ArrayList<>();
        batchList.add(new Batch(
                1,
                "MJ-Wein",
                2020,
                "Portwein",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Garten Lohring und Wilde Baeume an der RUB",
                LocalDateTime.now(),
                "Apefel waren ueberreif"));
        batchList.add(new Batch(
                2,
                "MJ-Wein",
                2020,
                "Sherry",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Garten Lohring und Wilde Baeume an der RUB",
                LocalDateTime.now(),
                "Apefel waren ueberreif"));
    }


    public List<Batch> getAllBatches() {
        LOG.info("Get all Batches");

        return batchList;
    }

    public Batch getBatchById(long batchId) {
        for (Batch batch : batchList) {
            if (batch.getId() == batchId) {
                return batch;
            }
        }
        throw new IllegalArgumentException("Could not find batch with id: " + batchId);
    }

}
