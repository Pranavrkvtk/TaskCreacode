package com.example.VirtualBookStore.dto;

import com.example.VirtualBookStore.model.BaseEntity;

public class OrderRequestDTO  extends BaseEntity{
    private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
