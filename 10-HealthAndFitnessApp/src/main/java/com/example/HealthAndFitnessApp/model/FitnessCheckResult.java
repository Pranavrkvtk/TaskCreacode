package com.example.HealthAndFitnessApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fitnesscheck")
public class FitnessCheckResult extends BaseEntity {

	private double weight;
	private double height;
	private int pushUpCount;
	private int pullUpcount;

	@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
