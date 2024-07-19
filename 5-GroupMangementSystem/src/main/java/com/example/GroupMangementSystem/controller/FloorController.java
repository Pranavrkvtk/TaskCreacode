package com.example.GroupMangementSystem.controller;

import com.example.GroupMangementSystem.Entity.Block;
import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.Entity.Floor;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.FloorDto;
import com.example.GroupMangementSystem.service.IfloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/floors")
public class FloorController {

    @Autowired
    private IfloorService floorService;

    @PostMapping
    public ResponseEntity<CommonResponse> createFloor(@RequestBody FloorDto floorDto) {
        CommonResponse response = floorService.create(floorDto);
        return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateFloor(@PathVariable UUID id, @RequestBody FloorDto floorDto) {
        CommonResponse response = floorService.update(id, floorDto);
        return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getFloorById(@PathVariable UUID id) {
        CommonResponse response = floorService.getById(id);
        return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllFloors() {
        CommonResponse response = floorService.getAll();
        return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteFloor(@PathVariable UUID id) {
        CommonResponse response = floorService.delete(id);
        return ResponseEntity.status(Integer.parseInt(response.getStatuscode())).body(response);
    }

   
//}
}
  
