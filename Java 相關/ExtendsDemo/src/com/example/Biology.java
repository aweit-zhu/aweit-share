package com.example;

public abstract class Biology {

	protected double lifeYear;
	
	protected Biology(double lifeYear) {
		this.lifeYear = lifeYear;
	}

	protected abstract double getLifYear();

}
