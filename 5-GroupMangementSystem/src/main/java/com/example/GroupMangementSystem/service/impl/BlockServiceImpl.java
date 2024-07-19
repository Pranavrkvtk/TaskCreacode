package com.example.GroupMangementSystem.service.impl;

import com.example.GroupMangementSystem.Entity.Block;
import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.Entity.Floor;
import com.example.GroupMangementSystem.Entity.Rack;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.BlockDto;
import com.example.GroupMangementSystem.repository.IBlockRepository;
import com.example.GroupMangementSystem.repository.IFloorRepository;
import com.example.GroupMangementSystem.service.IBlockService;

import jakarta.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BlockServiceImpl implements IBlockService {

	@Autowired
	private IBlockRepository dao;

	@Autowired
	private IFloorRepository floordao;

	@Override
	public CommonResponse create(BlockDto dto) {
		Block block = new Block();
		BeanUtils.copyProperties(dto, block);
		dao.save(block);
		dto.setId(block.getId()); // Set the ID in the DTO after saving
		return new CommonResponse("success", "201", dto);
	}

	@Override
	public CommonResponse update(UUID id, BlockDto dto) {
		Optional<Block> optionalBlock = dao.findById(id);
		if (!optionalBlock.isPresent()) {
			return new CommonResponse("failure", "404", "Block not found");
		}

		Block block = optionalBlock.get();
		BeanUtils.copyProperties(dto, block); // Update the block entity with DTO data
		block.setId(id); // Ensure the ID is set
		dao.save(block); // Save the updated block

		return new CommonResponse("success", "200", dto);
	}

	@Override
	public CommonResponse getById(UUID id) {
		Optional<Block> optionalBlock = dao.findById(id);
		if (!optionalBlock.isPresent()) {
			return new CommonResponse("failure", "404", "Block not found");
		}

		Block block = optionalBlock.get();
		BlockDto dto = new BlockDto();
		BeanUtils.copyProperties(block, dto); // Copy block entity data to DTO

		return new CommonResponse("success", "200", dto);
	}

	@Override
	public CommonResponse getAll() {
		List<Block> blocks = dao.findAll();
		List<BlockDto> dtos = blocks.stream().map(block -> {
			BlockDto dto = new BlockDto();
			BeanUtils.copyProperties(block, dto);
			return dto;
		}).collect(Collectors.toList());

		return new CommonResponse("success", "200", dtos);
	}

	@Override
	public CommonResponse delete(UUID id) {
		if (!dao.existsById(id)) {
			return new CommonResponse("failure", "404", "Block not found");
		}

		dao.deleteById(id);
		return new CommonResponse("success", "200", "Block deleted successfully");

	}

	@Override
	public Block saveBlock(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public CommonResponse<List<Block>> addBlockToFloor(UUID floorId, List<Block> blocks) {
		
	        Optional<Floor> optionalFloor = floordao.findById(floorId);
	        if (!optionalFloor.isPresent()) {
	            return new CommonResponse("failure", "404", "Floor not found with id: " + floorId);
	        }

	        Floor floor = optionalFloor.get();
	        for (Block block : blocks) {
	            block.setFloor(floor); // Assuming Block has a setFloor method
	        }

	        List<Block> savedBlocks = dao.saveAll(blocks); // Save all blocks to the repository

	        floor.getBlock().addAll(savedBlocks); // Assuming Floor has a getBlocks method
	        floordao.save(floor); // Save the updated floor

	   
	

		return new CommonResponse("success", "201", blocks);
	}
	}
