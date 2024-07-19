package com.example.GroupMangementSystem.service.impl;

import com.example.GroupMangementSystem.Entity.Block;
import com.example.GroupMangementSystem.Entity.Floor;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.FloorDto;
import com.example.GroupMangementSystem.repository.IBlockRepository;
import com.example.GroupMangementSystem.repository.IFloorRepository;
import com.example.GroupMangementSystem.service.IfloorService;

import jakarta.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FloorServiceImpl implements IfloorService {

	@Autowired
	private IFloorRepository dao;

	@Autowired
	private IBlockRepository blockdao;

	@Override
	public CommonResponse create(FloorDto floorDto) {
		Floor floor = new Floor();
		BeanUtils.copyProperties(floorDto, floor);
		dao.save(floor);
		floorDto.setId(floor.getId());
		return new CommonResponse("success", "201", floorDto);
	}

	@Override
	public CommonResponse update(UUID id, FloorDto floorDto) {
		Optional<Floor> optionalFloor = dao.findById(id);
		if (!optionalFloor.isPresent()) {
			return new CommonResponse("failure", "404", "Floor not found");
		}

		Floor floor = optionalFloor.get();
		BeanUtils.copyProperties(floorDto, floor);
		floor.setId(id);
		dao.save(floor);

		return new CommonResponse("success", "200", floorDto);
	}

	@Override
	public CommonResponse getById(UUID id) {
		Optional<Floor> optionalFloor = dao.findById(id);
		if (!optionalFloor.isPresent()) {
			return new CommonResponse("failure", "404", "Floor not found");
		}

		Floor floor = optionalFloor.get();
		FloorDto floorDto = new FloorDto();
		BeanUtils.copyProperties(floor, floorDto);
		return new CommonResponse("success", "200", floorDto);
	}

	@Override
	public CommonResponse getAll() {
		List<Floor> floors = dao.findAll();
		List<FloorDto> floorDtos = floors.stream().map(floor -> {
			FloorDto floorDto = new FloorDto();
			BeanUtils.copyProperties(floor, floorDto);
			return floorDto;
		}).collect(Collectors.toList());

		return new CommonResponse("success", "200", floorDtos);
	}

	@Override
	public CommonResponse delete(UUID id) {
		if (!dao.existsById(id)) {
			return new CommonResponse("failure", "404", "Floor not found");
		}

		dao.deleteById(id);
		return new CommonResponse("success", "200", "Floor deleted successfully");
	}

}