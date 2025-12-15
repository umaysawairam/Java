package com.tokyo.quizApp.menu;
import java.util.*;

public class SignUP {
	public static void signUpMenu(Scanner sc) {
		System.out.println("\nStudent Registration");
		System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter Email : ");
		String email = sc.next();
		System.out.println("Enter Password :");
		String password = sc.next();
		
		System.out.println("\nRegistration Succesfull");
		System.out.println("\nWelcome" + name + "\n");
	}
}
