package com.healthymeal.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthymeal.entity.Meal;
import com.healthymeal.entity.Plans;
import com.healthymeal.util.DbConnectivity;

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
	public boolean createPlan(Plans plan) {
		try {

			int respon = DbConnectivity.update(
					"insert into Plans(planname,plandays,planprice,weightFrom,weightTo) value(?,?,?,?,?)",
					plan.getPlanName(), plan.getPlanDays(), plan.getPlanPrice(), plan.getWeightFrom(),
					plan.getWeightTo());
			if (respon > 0)
				return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
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

	public boolean checkBuyedPlan(String userEmail) {
		try {
			ResultSet rs = DbConnectivity.query("select BuyedPlan from user where email=?", userEmail);
			if (rs.next() && rs.getString(1) == null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean buyPlan(Plans plans, String userEmail) {
		try {
			int res = DbConnectivity.update("update user set BuyedPlan=? , " + "planday=? where email=? ",
					plans.getPlanName(), plans.getPlanDays(), userEmail);
			if (res > 0)
				return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean setPLanDeatils(String planName, ArrayList<Meal> mealObject) {

		ResultSet rs;
		try {
			rs = DbConnectivity.query("select planid from plans where planName=?", planName);
			if (rs.next()) {
				String planId = rs.getString(1);
				if (planId != null) {
					for (int count = 0; count < mealObject.size(); count++) {

						DbConnectivity.update("insert into PlanPerDay() values(?,?,?,?,?,?,?,?)", planId,
								"" + count + 1, mealObject.get(count).getBreakFast(),
								mealObject.get(count).getMorningSnacks(), mealObject.get(count).getLunch(),
								mealObject.get(count).getAfternoonSnacks(), mealObject.get(count).getDinner(),
								mealObject.get(count).getHydration());
					}
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
}
