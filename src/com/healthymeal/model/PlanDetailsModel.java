package com.healthymeal.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.healthymeal.dbConnectivity.DbConnectivity;
import com.healthymeal.entity.Meal;
import com.healthymeal.entity.Plans;

public class PlanDetailsModel {

	// get each day details from plan
	public ArrayList<Meal> getPlanDetails(String planName) {
		ArrayList<Meal> aList = new ArrayList<>();
		try {
			ResultSet rs = DbConnectivity.query(
					"select * from planperday where planId=(select" + " PlanId from plans where planName=?)", planName);
			while (rs.next()) {
				aList.add(new Meal(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return aList;
	}

	// get Plan
	public ArrayList<Plans> getPlan() {
		ArrayList<Plans> plans = new ArrayList<Plans>();
		try {
			ResultSet data = DbConnectivity.query("select * from plans");
			while (data.next()) {
				Plans plan = new Plans();
				plan.setPlanName(data.getString(2));
				plan.setPlanDays(data.getString(3));
				plan.setPlanPrice(data.getString(4));
				plan.setWeightFrom(data.getString(5));
				plan.setWeightTo(data.getString(6));
				plans.add(plan);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return plans;
	}

	// create Plan
	public ArrayList<String> createPlan() {
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

	// delete plan
	public boolean deletePlan(String planName) {
		try {
			int res = DbConnectivity.update("delete from plans where planName=?", planName);
			if (res > 0)
				return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	
	// get user buyed Plan
	public Plans getBuyedPlan(String email) {
		Plans plans = null;
		try {
			ResultSet rs = DbConnectivity
					.query("select * from plans where planName=(select BuyedPlan from user where email=?)", email);

			if (rs.next()) {
				plans = new Plans();
				plans.setPlanName(rs.getString(2));
				plans.setPlanDays(rs.getString(3));
				plans.setPlanPrice(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return plans;
	}
}
