package com.healthymeal.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.entity.MealDetails;

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
}
