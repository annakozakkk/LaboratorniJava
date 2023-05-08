package ua.lviv.iot.algo.part1.ProjectorLab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.algo.part1.ProjectorLab.model.Bicycle;
import ua.lviv.iot.algo.part1.ProjectorLab.model.BicycleDTO;
import ua.lviv.iot.algo.part1.business.BicycleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bicycles")
public class BicycleController {
    @Autowired
    private BicycleService bicycleService;

    public BicycleDTO format(final Bicycle bicycle) {
        return new BicycleDTO(
                bicycle.getBrand(),
                bicycle.getMaxSpeed(),
                bicycle.getCurrentSpeed(),
                bicycle.getId()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllBicycles() {
        List<BicycleDTO> result = new ArrayList<>();
        if (bicycleService.getAllBicycles().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            for (Bicycle bicycle : bicycleService.getAllBicycles()) {
                result.add(format(bicycle));
            }
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BicycleDTO> getBicycle(@PathVariable("id") Integer bicycleID) {
        Bicycle bicycle = bicycleService.getBicycle(bicycleID);
        if (bicycle == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BicycleDTO bicycleDTO = format(bicycle);
        return ResponseEntity.ok(bicycleDTO);
    }

    @PostMapping
    public BicycleDTO create(@RequestBody Bicycle bicycle) {
        BicycleDTO bicycleDTO = format(bicycleService.createBicycle(bicycle));
        return bicycleDTO;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BicycleDTO> deleteBicycle(@PathVariable("id") Integer bicycleID) {
        if (bicycleService.deleteBicycle(bicycleID)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BicycleDTO> updateBicycle(@PathVariable("id") Integer bicycleID,
                                                    @RequestBody Bicycle bicycle) {
        Bicycle updatedBicycle = bicycleService.updateBicycle(bicycleID, bicycle);
        if (updatedBicycle != null) {
            BicycleDTO bicycleDTO = format(bicycleService.updateBicycle(bicycleID, bicycle));
            return ResponseEntity.ok(bicycleDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
