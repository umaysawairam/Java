package com.tokyo.quizApp.menu;
import java.util.*;

public class Admin {
	private static int AdminMenuOptions(Scanner sc) {
		System.out.println("\n===Admin Menu===");
		System.out.println("1.Create Quiz");
		System.out.println("2.List Quizzes");
		System.out.println("3.LogOut");
		return sc.nextInt();
	}
	
	public static void AdminMenu(Scanner sc) {
		int choice;
		do{
			//System.out.println("Enter choice : ");
			choice = AdminMenuOptions(sc);
			switch (choice) {
			case 1: {
				System.out.println("\nCreate Quiz");
				break;
			}
			case 2: {
				System.out.println("\nList Quizzes");
				break;
			}
			case 3:
				System.out.println("\nLogOut...");
				break;
			default:
				System.out.println("\nInvalid choice!");
			}
		}while(choice != 3);
	}

}
