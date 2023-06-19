package ua.lviv.iot.algo.part1.ProjectorLab;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.algo.part1.projector.model.*;
import ua.lviv.iot.algo.part1.projector.writer.BicycleWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;


public class BicycleWriterTest {
    private static final String RESULT_FILE = "result.csv";
    private static final String EXPECTED_FILE = "expected.csv";
    private BicycleWriter bicycleWriter = new BicycleWriter();
    List<AbstractBicycle> bicycles = new LinkedList<>();


    @BeforeEach
    public void setUp() throws IOException {
        bicycleWriter = new BicycleWriter();
        bicycles = new LinkedList<>();
        bicycles.add(new Bicycle("Colnago", 23.0, 12.0));
        bicycles.add(new Bicycle("Trek", 45.0, 30.0));
        bicycles.add(new ElectricBicycle("Colnago", 60, 40, 35, 0.2));
        bicycles.add(new ElectricBicycle("Giant", 70, 30, 45, 0.6));
        bicycles.add(new ElectricScooter("Bolt", 30, 15, 2, 15));
        bicycles.add(new ElectricScooter("Bolt", 40, 12, 3, 17));
        bicycles.add(new GyroScooter("Smart Balance", 30, 10, 20, 36, 0.2));
        bicycles.add(new GyroScooter("Smart Balance", 50, 20, 30, 48, 0.5));

    }

    @Test
    public void testEmptyWrite() throws IOException {
        File file = new File(RESULT_FILE);
        Files.deleteIfExists(Path.of(RESULT_FILE));
        Assertions.assertFalse(file.exists());

    }

    @Test
    public void testWriteListOfBicycles() throws IOException {

        bicycleWriter.write(bicycles);
        Path expected = new File(RESULT_FILE).toPath();
        Path actual = new File(EXPECTED_FILE).toPath();
        Assertions.
                assertEquals(-1L,
                        Files.mismatch(expected, actual));

    }

    @Test
    public void testFileOverride() throws FileNotFoundException {
        List<AbstractBicycle> bicycles = new LinkedList<>();

        bicycleWriter.write(bicycles);
    }
}
