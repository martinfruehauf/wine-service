package application;

import application.batch.BaseBatchDTO;
import application.batch.BatchResource;
import application.batch.FullBatchDTO;
import domain.batch.Batch;
import domain.batch.BatchService;
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

    @Test
    public void testAddBatch() {
        Mockito.doReturn(4L)
                .when(service)
                .addBatch(new BaseBatchDTO(
                        "Neuer Wein",
                        2020,
                        "Portwein",
                        "Birne",
                        LocalDateTime.MIN.toString(),
                        "Aepfel waren etwas sauer"
                ));
        Response response = this.resource.addBatch(new BaseBatchDTO(
                "Neuer Wein",
                2020,
                "Portwein",
                "Birne",
                LocalDateTime.MIN.toString(),
                "Aepfel waren etwas sauer"
        ));
        assertEquals(201, response.getStatus());
        assertEquals("/api/batches/4", response.getEntity());
    }

    @Test
    public void testUpdateBatch() {
        Mockito.doNothing()
                .when(service)
                .updateBatch(1, new BaseBatchDTO(
                        "Neuer Wein",
                        2020,
                        "Portwein",
                        "Birne",
                        LocalDateTime.MIN.toString(),
                        "Aepfel waren etwas sauer"
                ));
        Response response = this.resource.updateBatch(1, new BaseBatchDTO(
                "Neuer Wein",
                2020,
                "Portwein",
                "Birne",
                LocalDateTime.MIN.toString(),
                "Aepfel waren etwas sauer"
        ));
        assertEquals(204, response.getStatus());
    }

    @Test
    public void testUpdateBatchShouldFailForWrongID() {
        Mockito.doThrow(new IllegalArgumentException())
                .when(service)
                .updateBatch(99999, new BaseBatchDTO(
                        "Neuer Wein",
                        2020,
                        "Portwein",
                        "Birne",
                        LocalDateTime.MIN.toString(),
                        "Aepfel waren etwas sauer"
                ));
        Response response = this.resource.updateBatch(99999, new BaseBatchDTO(
                "Neuer Wein",
                2020,
                "Portwein",
                "Birne",
                LocalDateTime.MIN.toString(),
                "Aepfel waren etwas sauer"
        ));
        assertEquals(404, response.getStatus());
    }

    @Test
    public void testDeleteBatch() {
        Mockito.doNothing()
                .when(service)
                .deleteBatch(1);
        Response response = this.resource.deleteBatch(1);
        assertEquals(204, response.getStatus());
    }

    @Test
    public void testDeleteBatchShouldFailForWrongId() {
        Mockito.doThrow(new IllegalArgumentException())
                .when(service)
                .deleteBatch(99999);
        Response response = this.resource.deleteBatch(99999);
        assertEquals(404, response.getStatus());
    }

}
