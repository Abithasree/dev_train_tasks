package com.example.asmtest.controller;

import com.example.asmtest.entity.Floor;
import com.example.asmtest.repository.FloorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floors")
public class FloorController {

    private final FloorRepository floorRepository;


    public FloorController(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @PostMapping
    public Floor saveFloor(@RequestBody Floor floor) {
        return floorRepository.save(floor);
    }

    @GetMapping
    public List<Floor> getFloors() {
        return floorRepository.findAll();
    }

    @GetMapping("/search")
    public Floor searchFloor(@RequestParam String category) {
        return floorRepository.findByCategory_Name(category);
    }
}
