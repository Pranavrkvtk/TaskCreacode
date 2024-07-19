package com.example.HealthAndFitnessApp.dto;

import com.example.HealthAndFitnessApp.model.BaseEntity;

import jakarta.persistence.Column;

public class FitnessCheckDTO extends BaseEntity {

	private double weight;
	private double height;

	@Column(name = "push_up_count")
	private int pushUpCount;

	@Column(name = "pull_upcount")

	private int pullUpcount;

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getPushUpCount() {
		return pushUpCount;
	}

	public void setPushUpCount(int pushUpCount) {
		this.pushUpCount = pushUpCount;
	}

	public int getPullUpcount() {
		return pullUpcount;
	}

	public void setPullUpcount(int pullUpcount) {
		this.pullUpcount = pullUpcount;
	}

}
