package com.tokyo.quizApp.menu;
import java.util.*;

public class signInmenu {
	private static int signInMenuOptions(Scanner sc) {
		System.out.println("\n===SignIn Menu===");
		System.out.println("1.View Quizes");
		System.out.println("2.Take Quiz");
		System.out.println("3.View Scores");
		System.out.println("4.LogOut");
		return sc.nextInt();
	}
	
	public static void signInMenu(Scanner sc) {
		int choice;
		do{
			//System.out.println("Enter choice : ");
			choice = signInMenuOptions(sc);
			switch (choice) {
			case 1: {
				System.out.println("\nView Quizes");
				break;
			}
			case 2: {
				System.out.println("\nTake Quiz");
				break;
			}
			case 3: {
				System.out.println("\nView Scores");
				break;
			}
			case 4:
				System.out.println("\nLogOut...");
				break;
			default:
				System.out.println("\nInvalid choice!");
			}
		}while(choice !=4);
	}
}
