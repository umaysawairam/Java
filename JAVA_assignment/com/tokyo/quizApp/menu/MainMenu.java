package com.tokyo.quizApp.menu;

import java.util.Scanner;

public class MainMenu {
	private static int MainMenuOption(Scanner sc) {
		System.out.println("\n===MainMenu===");
		System.out.println("1.AdminLogin");//Admin
		System.out.println("2.Student Register");//signup
		System.out.println("3.Student Login");//signIn
		System.out.println("4.Exit");
		return sc.nextInt();
	}

	public static void mainMenu(Scanner sc) {
		int choice;
		do{
			//System.out.println("Enter choice : ");
			choice = MainMenuOption(sc);
			switch (choice) {
			case 1: {
				System.out.println("AdminLogin");
				Admin.AdminMenu(sc);
				break;
			}
			case 2: {
				System.out.println("Student Register");
				SignUP.signUpMenu(sc);
				break;
			}
			case 3: {
				System.out.println("Student Login");
				signInmenu.signInMenu(sc);
				break;
			}
			case 4:{
				System.out.println("\nExiting.....");
				break;
			}
			default:
				System.out.println("Invalid choice");
			}
		}while(choice != 4);
		
	}

}

