package com.example.GroupMangementSystem.controller;

import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.RackDto;
import com.example.GroupMangementSystem.service.IRackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/racks")
public class RackController {

    @Autowired
    private IRackService rackService;

    @PostMapping
    public ResponseEntity<CommonResponse> createRack(@RequestBody RackDto rackDto) {
        CommonResponse response = rackService.create(rackDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateRack(@PathVariable UUID id, @RequestBody RackDto rackDto) {
        CommonResponse response = rackService.update(id, rackDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getRackById(@PathVariable UUID id) {
        CommonResponse response = rackService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllRacks() {
        CommonResponse response = rackService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteRack(@PathVariable UUID id) {
        CommonResponse response = rackService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
//    
//    @PostMapping("/{rackUUID}/books")
//    public CommonResponse<List<Book>> addBooksToRack(
//            @PathVariable UUID rackUUID,
//            @RequestBody List<Book> books
//    ) {
//        return rackService.addBooksToRack(rackUUID, books);
//    }
}
