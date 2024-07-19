package com.example.GroupMangementSystem.service;

import com.example.GroupMangementSystem.Entity.Block;
import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.Entity.Floor;
import com.example.GroupMangementSystem.Entity.Institution;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.BlockDto;

import java.util.List;
import java.util.UUID;

public interface IBlockService {

    CommonResponse create(BlockDto dto);

    CommonResponse update(UUID id, BlockDto dto);

    CommonResponse getById(UUID id);

    CommonResponse getAll();

    CommonResponse delete(UUID id);
    
    Block saveBlock(Block block);
    
    CommonResponse<List<Block>> addBlockToFloor(UUID floorId, List<Block> blocks);



}
