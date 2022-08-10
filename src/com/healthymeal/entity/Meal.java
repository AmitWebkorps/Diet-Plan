package com.healthymeal.entity;

public class Meal {
   String breakFast;
   String morningSnacks;
   String lunch;
   String afternoonSnacks;
   String dinner;
   String hydration;
   
   
   public String getBreakFast() {
	return breakFast;
}
public void setBreakFast(String breakFast) {
	this.breakFast = breakFast;
}
public String getMorningSnacks() {
	return morningSnacks;
}
public void setMorningSnacks(String morningSnacks) {
	this.morningSnacks = morningSnacks;
}
public String getLunch() {
	return lunch;
}
public void setLunch(String lunch) {
	this.lunch = lunch;
}
public String getAfternoonSnacks() {
	return afternoonSnacks;
}
public void setAfternoonSnacks(String afternoonSnacks) {
	this.afternoonSnacks = afternoonSnacks;
}
public String getDinner() {
	return dinner;
}
public void setDinner(String dinner) {
	this.dinner = dinner;
}
public String getHydration() {
	return hydration;
}
public void setHydration(String hydration) {
	this.hydration = hydration;
}

public Meal(String breakFast, String morningSnacks, String lunch, String afternoonSnacks, String dinner,
		String hydration) {
	super();
	this.breakFast = breakFast;
	this.morningSnacks = morningSnacks;
	this.lunch = lunch;
	this.afternoonSnacks = afternoonSnacks;
	this.dinner = dinner;
	this.hydration = hydration;
}
@Override
public String toString() {
	return "Meal [breakFast=" + breakFast + ", morningSnacks=" + morningSnacks + ", lunch=" + lunch
			+ ", afternoonSnacks=" + afternoonSnacks + ", dinner=" + dinner + ", hydration=" + hydration + "]";
}
   
}
