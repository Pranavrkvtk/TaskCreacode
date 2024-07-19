package com.example.GroupMangementSystem.service;

import com.example.GroupMangementSystem.Entity.Block;
import com.example.GroupMangementSystem.Entity.Floor;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.FloorDto;

import java.util.List;
import java.util.UUID;

public interface IfloorService {

	CommonResponse create(FloorDto floor);

	CommonResponse update(UUID id, FloorDto floor);

	CommonResponse getById(UUID id);

	CommonResponse getAll();

	CommonResponse delete(UUID id);


}
