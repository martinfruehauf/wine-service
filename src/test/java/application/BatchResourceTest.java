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
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30).toString(),
                "Aepfel waren etwas sauer"
        ));
        expected.add(new FullBatchDTO(
                2,
                "Wonder Wine",
                2019,
                "Portwein",
                "Apfel",
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
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30),
                "Aepfel waren etwas sauer"
        ));
        mock.add(new Batch(
                2,
                "Wonder Wine",
                2019,
                "Portwein",
                "Apfel",
                LocalDateTime.of(2019, Month.AUGUST, 20, 18, 30),
                "Aepfel waren perfekt"
        ));

        Mockito.doReturn(mock)
                .when(service)
                .getAllBatches();
        Response response = this.resource.getBatches();

        assertEquals(expected, response.getEntity());
    }

    @Test
    public void testGetBatchById() {
        Mockito.doReturn(new Batch(
                1,
                "Wonder Wine",
                2020,
                "Portwein",
                "Apfel",
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30),
                "Aepfel waren etwas sauer"
        ))
        .when(service)
        .getBatchById(1);
        FullBatchDTO expected = new FullBatchDTO(
                1,
                "Wonder Wine",
                2020,
                "Portwein",
                "Apfel",
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30).toString(),
                "Aepfel waren etwas sauer"
        );

        Response response = this.resource.getBatchById(1);

        assertEquals(expected, response.getEntity());
    }

    @Test
    public void testGetBatchByIdFailForWrongId() {
        Mockito.doThrow(new IllegalArgumentException())
                .when(service)
                .getBatchById(999999);

        Response response = this.resource.getBatchById(999999);

        assertEquals(404, response.getStatus());
    }

}
