package com.example.GroupMangementSystem.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "blockwisetable")
public class Block extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "floor_id", referencedColumnName = "id")
	private Floor floor;

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	



}
