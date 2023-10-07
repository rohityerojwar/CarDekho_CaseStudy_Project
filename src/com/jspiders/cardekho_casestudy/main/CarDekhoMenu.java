package com.jspiders.cardekho_casestudy.main;

import java.util.Scanner;

import com.jspiders.cardekho_casestudy.operation.CarOperation;

public class CarDekhoMenu extends CarOperation{

	public static void main(String[] args) {
		
		CarOperation carOperation = new CarOperation();
		carOperation.createList();
		menu();
	}
	
	public static void menu() {
		
		do {
			
			System.out.println("=============MENU===============");
			System.out.println("1.Add Car Details.\n2.Search Car Details.\n3.Update Car Details.\n4.Delete Car Details.\n5.Exit\n");
			
			Scanner inp = new Scanner(System.in);
			int choice = inp.nextInt();
			CarOperation carOperation = new CarOperation();
			
			switch(choice) {
			
			case 1: carOperation.addCarDetails();
			break;
			
			case 2: carOperation.searchCarDetails();
			break;
			
			case 3: carOperation.updateCarDetails();
			break;
			
			case 4: carOperation.deleteCarDetails();
			break;
			
			case 5:
				inp.close();
				System.exit(0);
				break;
			
			default:
				System.out.println("Invalid Choice");
				System.out.println("Try Again");
			
			}
		} while(true);
	}
}