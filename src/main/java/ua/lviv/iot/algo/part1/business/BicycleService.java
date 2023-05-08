package ua.lviv.iot.algo.part1.business;

import org.springframework.stereotype.Service;
import ua.lviv.iot.algo.part1.projectorLab.model.Bicycle;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BicycleService {
    private Map<Integer, Bicycle> bicycles = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public Bicycle createBicycle(Bicycle bicycle) {
        bicycle.setId(idCounter.incrementAndGet());
        bicycles.put(bicycle.getId(), bicycle);
        return bicycle;
    }

    public Bicycle getBicycle(Integer bicycleId) {
        return bicycles.get(bicycleId);
    }

    public List<Bicycle> getAllBicycles() {
        return new LinkedList<Bicycle>(bicycles.values());
    }

    public boolean deleteBicycle(Integer bicycleId) {
        return bicycles.remove(bicycleId) != null;
    }

    public Bicycle updateBicycle(Integer bicycleId, Bicycle bicycle) {
        bicycle.setId(bicycleId);
        bicycles.put(bicycleId, bicycle);
        return bicycle;
    }

}
