package com.example.VirtualBookStore.model;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id = UUID.randomUUID();



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
