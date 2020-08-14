package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BatchService {

    private List<Batch> batchList;

    private static final Logger LOG = LoggerFactory.getLogger(BatchService.class);

    public BatchService() {}


    public List<Batch> getAllBatches() {
        LOG.info("Get all Batches");
        List<Batch> listBatch = new ArrayList<>();
        listBatch.add(new Batch(
                1,
                "MJ-Wein",
                2020,
                "Portwein",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Garten Lohring und Wilde Baeume an der RUB",
                LocalDateTime.now(),
                "Apefel waren ueberreif"));
        listBatch.add(new Batch(
                2,
                "MJ-Wein",
                2020,
                "Sherry",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Garten Lohring und Wilde Baeume an der RUB",
                LocalDateTime.now(),
                "Apefel waren ueberreif"));
        return listBatch;
    }


}
