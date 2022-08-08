package com.healthymeal.modal;

public class MealDetails {
    String mealName;
    String mealPrice;
    String mealType;
    String mealImage;
	public String getMealImage() {
		return mealImage;
	}
	public void setMealImage(String mealImage) {
		this.mealImage = mealImage;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(String mealPrice) {
		this.mealPrice = mealPrice;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	@Override
	public String toString() {
		return "Meal [mealName=" + mealName + ", mealPrice=" + mealPrice + ", mealType=" + mealType + "]";
	}
}
