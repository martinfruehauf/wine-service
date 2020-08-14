package application;

import domain.Batch;
import domain.BatchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BatchResourceTest {

    @InjectMocks
    private BatchResource resource;

    @Mock
    private BatchService service;

    @Test
    public void testGetBatches() {
        ArrayList<FullBatchDTO> expected = new ArrayList<>();

        expected.add(new FullBatchDTO(
                1,
                "Wonder Wine",
                2020,
                "Portwein",
                "Apfel",
                new String[] {"10.481707,7.237550", "10.444453,7.251911"},
                "Heinzstr",
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30).toString(),
                "Aepfel waren etwas sauer"
        ));
        expected.add(new FullBatchDTO(
                2,
                "Wonder Wine",
                2019,
                "Portwein",
                "Apfel",
                new String[] {"10.481707,7.237550", "10.444453,7.251911"},
                "Velbert",
                LocalDateTime.of(2019, Month.AUGUST, 20, 18, 30).toString(),
                "Aepfel waren perfekt"
        ));

        ArrayList<Batch> mock = new ArrayList<>();
        mock.add(new Batch(
                1,
                "Wonder Wine",
                2020,
                "Portwein",
                "Apfel",
                new String[] {"10.481707,7.237550", "10.444453,7.251911"},
                "Heinzstr",
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30),
                "Aepfel waren etwas sauer"
        ));
        mock.add(new Batch(
                2,
                "Wonder Wine",
                2019,
                "Portwein",
                "Apfel",
                new String[] {"10.481707,7.237550", "10.444453,7.251911"},
                "Velbert",
                LocalDateTime.of(2019, Month.AUGUST, 20, 18, 30),
                "Aepfel waren perfekt"
        ));

        Mockito.doReturn(mock)
                .when(service)
                .getAllBatches();
        Response response = this.resource.getBatches();

        assertEquals(expected, response.getEntity());


    }

}
