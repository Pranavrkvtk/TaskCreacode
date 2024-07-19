package com.example.GroupMangementSystem.service.impl;

import com.example.GroupMangementSystem.Entity.Book;
import com.example.GroupMangementSystem.Entity.College;
import com.example.GroupMangementSystem.Entity.Institution;
import com.example.GroupMangementSystem.Entity.Rack;
import com.example.GroupMangementSystem.commonresponse.CommonResponse;
import com.example.GroupMangementSystem.dto.RackDto;
import com.example.GroupMangementSystem.repository.IRackRepository;
import com.example.GroupMangementSystem.service.IRackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RackServiceImpl implements IRackService {

    @Autowired
    private IRackRepository dao;

    @Override
    public CommonResponse create(RackDto rackDto) {
        Rack rack = new Rack();
        BeanUtils.copyProperties(rackDto, rack);
        dao.save(rack);
        rackDto.setId(rack.getId());
        return new CommonResponse("success", "201", rackDto);
    }

    @Override
    public CommonResponse update(UUID id, RackDto rackDto) {
        Optional<Rack> optionalRack = dao.findById(id);
        if (!optionalRack.isPresent()) {
            return new CommonResponse("failure", "404", "Rack not found");
        }

        Rack rack = optionalRack.get();
        BeanUtils.copyProperties(rackDto, rack);
        rack.setId(id);
        dao.save(rack);

        return new CommonResponse("success", "200", rackDto);
    }

    @Override
    public CommonResponse getById(UUID id) {
        Optional<Rack> optionalRack = dao.findById(id);
        if (!optionalRack.isPresent()) {
            return new CommonResponse("failure", "404", "Rack not found");
        }

        Rack rack = optionalRack.get();
        RackDto rackDto = new RackDto();
        BeanUtils.copyProperties(rack, rackDto);
        return new CommonResponse("success", "200", rackDto);
    }

    @Override
    public CommonResponse getAll() {
        List<Rack> racks = dao.findAll();
        List<RackDto> rackDtos = racks.stream()
                .map(rack -> {
                    RackDto rackDto = new RackDto();
                    BeanUtils.copyProperties(rack, rackDto);
                    return rackDto;
                })
                .collect(Collectors.toList());

        return new CommonResponse("success", "200", rackDtos);
    }

    @Override
    public CommonResponse delete(UUID id) {
        if (!dao.existsById(id)) {
            return new CommonResponse("failure", "404", "Rack not found");
        }

        dao.deleteById(id);
        return new CommonResponse("success", "200", "Rack deleted successfully");
    }

	@Override
	public CommonResponse<List<Book>> addBooksToRack(UUID rackUUID, List<Book> Books) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public CommonResponse<List<Book>> addBooksToRack(UUID rackUUID, List<Book> Books) {
//	    Optional<Rack> rackOptional = dao.findById(rackUUID);
//	    if (!rackOptional.isPresent()) {
//	        return new CommonResponse<>("failure", "404", "Rack not found");
//	    }
//
//	    Rack rack = rackOptional.get();
//	    for (Book book : Books) {
//	        book.setRack(rack); // Set the Rack for each Book
//	    }
//
//	    rack.setBook(Books);; // Set the list of Books in the Rack
//	    dao.save(rack); // Save the Rack entity to persist the changes
//
//	    return new CommonResponse<>("success", "200",  Books);
//	}
}
