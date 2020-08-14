package domain;

import infrastructure.stereotypes.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatchService {

    private List<Batch> batchList;

    private static final Logger LOG = LoggerFactory.getLogger(BatchService.class);

    public BatchService() {}

    @PostConstruct
    public void init() {
        LOG.info("BatchService initialized");
        batchList = new ArrayList<>();
        batchList.add(new Batch(
                1,
                "Wonder Wine",
                2020,
                "Portwein",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Melschedeweg",
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30),
                "Aepfel waren etwas sauer"
        ));
        batchList.add(new Batch(
                2,
                "Wonder Wine",
                2019,
                "Portwein",
                "Apfel",
                new String[] {"51.481707,7.237550", "51.444453,7.251911"},
                "Velbert",
                LocalDateTime.of(2019, Month.AUGUST, 20, 18, 30),
                "Aepfel waren perfekt"
        ));
    }

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
