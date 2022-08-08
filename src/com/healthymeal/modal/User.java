package com.healthymeal.modal;

public class User {
   static String name;
   static int age;
   static String email;
	public String getName() {
		return name;
	}
	public static void setName(String name1) {
		 name = name1;
	}
	public static int getAge() {
		return age;
	}
	public static void setAge(int age1) {
		age = age1;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email1) {
	    email = email1;
	}
}
