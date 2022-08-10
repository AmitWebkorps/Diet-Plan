package com.healthymeal.entity;

import javax.servlet.http.Part;

public class MealDetails {
    private String mealName;
    private String mealPrice;
    private String mealType;
    private String mealImage;
    private Part mealImagePart;
    private String mealIngredients;
	public String getMealIngredients() {
		return mealIngredients;
	}
	public void setMealIngredients(String mealIngredients) {
		this.mealIngredients = mealIngredients;
	}
	public Part getMealImagePart() {
		return mealImagePart;
	}
	public void setMealImagePart(Part mealImagePart) {
		this.mealImagePart = mealImagePart;
	}
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
