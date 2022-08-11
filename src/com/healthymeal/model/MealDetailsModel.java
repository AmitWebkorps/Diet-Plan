package com.healthymeal.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthymeal.entity.MealDetails;
import com.healthymeal.util.DbConnectivity;

public class MealDetailsModel {

	public boolean addMeal(MealDetails mDetails) throws IOException {
		FileOutputStream outputstream = null;
		InputStream inputstream = null;
		if (mDetails.getMealImagePart() != null) {
			inputstream = mDetails.getMealImagePart().getInputStream();
			try {
				outputstream = new FileOutputStream(
						"C:\\Users\\dell\\Documents\\workspace-sts-3.9.12.RELEASE\\HealthyMeals\\WebContent\\images\\"
								+ mDetails.getMealName() + ".png");
				int bytes = 0;

				while ((bytes = inputstream.read()) != -1)
					outputstream.write(bytes);

				int res = DbConnectivity.update("insert into meals values(?,?,?,?,?)", mDetails.getMealName(),
						mDetails.getMealName() + ".png", mDetails.getMealPrice(), mDetails.getMealType(),
						mDetails.getMealIngredients());
				if (res > 0)
					return true;
			} catch (FileNotFoundException | SQLException e) {
				System.out.println(e);
			} finally {

				if (outputstream != null) {
					inputstream.close();
					outputstream.close();
				}
			}
		}
		return false;
	}

	
	
	public ArrayList<MealDetails> getMealDetails()
	{
		ArrayList<MealDetails> aList = new ArrayList<>();
		try {
			ResultSet data = DbConnectivity.query("select * from meals");
			while (data.next()) {
				MealDetails meal = new MealDetails();
				meal.setMealName(data.getString(1));
				meal.setMealImage(data.getString(2));
				meal.setMealPrice(data.getString(3));
				meal.setMealType(data.getString(4));
				aList.add(meal);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return aList;
	}
	
	public ArrayList<String> getMealName() {
		ArrayList<String> mealName = new ArrayList<>();
		try {
			// getting value from database and storing it in the ArrayList
			ResultSet rs = DbConnectivity.query("Select * from meals");
			while (rs.next()) {
				mealName.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mealName;
	}

}
