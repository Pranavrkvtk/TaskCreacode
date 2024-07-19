package com.example.GroupMangementSystem.controller;

import com.example.GroupMangementSystem.Entity.Block;
import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.Entity.Floor;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.BlockDto;
import com.example.GroupMangementSystem.service.IBlockService;
import com.example.GroupMangementSystem.service.IfloorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/blocks")
public class BlockController {

	@Autowired
	private IBlockService blockService;

	@Autowired
	private IfloorService floorService;

	@PostMapping
	public ResponseEntity<CommonResponse<Block>> createBlock(@RequestBody BlockDto blockDto) {
		CommonResponse<Block> response = blockService.create(blockDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CommonResponse<Block>> updateBlock(@PathVariable UUID id, @RequestBody BlockDto blockDto) {
		CommonResponse<Block> response = blockService.update(id, blockDto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommonResponse<Block>> getBlockById(@PathVariable UUID id) {
		CommonResponse<Block> response = blockService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping
	public ResponseEntity<CommonResponse<List<Block>>> getAllBlocks() {
		CommonResponse<List<Block>> response = blockService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CommonResponse<Void>> deleteBlock(@PathVariable UUID id) {
		CommonResponse<Void> response = blockService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/add-to-floor/{floorId}")
	public ResponseEntity<CommonResponse<List<Block>>> addBlockToFloor(@PathVariable UUID floorId,
			@RequestBody List<Block> blocks) {
		CommonResponse<List<Block>> response = blockService.addBlockToFloor(floorId, blocks);

		return ResponseEntity.status(HttpStatus.valueOf(Integer.parseInt(response.getStatuscode()))).body(response);
	}

}
