package com.example.GroupMangementSystem.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "floortable")
public class Floor extends BaseEntity {

	@OneToMany(mappedBy = "floor",cascade = CascadeType.ALL)

	private List <Block> block;

	public List<Block> getBlock() {
		return block;
	}

	public void setBlock(List<Block> block) {
		this.block = block;
	}

	
	

}
