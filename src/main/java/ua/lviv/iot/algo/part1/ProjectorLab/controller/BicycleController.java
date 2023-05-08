package ua.lviv.iot.algo.part1.projectorLab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.algo.part1.projectorLab.model.Bicycle;
import ua.lviv.iot.algo.part1.projectorLab.dto.BicycleDTO;
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
    public ResponseEntity<?> getBicycle(@PathVariable("id") Integer bicycleId) {
        Bicycle bicycle = bicycleService.getBicycle(bicycleId);
        if (bicycle == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        BicycleDTO bicycleDto = format(bicycle);
        return ResponseEntity.ok(bicycleDto);
    }

    @PostMapping
    public BicycleDTO create(@RequestBody Bicycle bicycle) {
        BicycleDTO bicycleDto = format(bicycleService.createBicycle(bicycle));
        return bicycleDto;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BicycleDTO> deleteBicycle(@PathVariable("id") Integer bicycleId) {
        if (bicycleService.deleteBicycle(bicycleId)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BicycleDTO> updateBicycle(@PathVariable("id") Integer bicycleId,
                                                    @RequestBody Bicycle bicycle) {
        Bicycle updatedBicycle = bicycleService.updateBicycle(bicycleId, bicycle);
        if (updatedBicycle != null) {
            BicycleDTO bicycleDto = format(bicycleService.updateBicycle(bicycleId, bicycle));
            return ResponseEntity.ok(bicycleDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
