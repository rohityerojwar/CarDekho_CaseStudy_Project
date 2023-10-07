 package com.jspiders.cardekho_casestudy.operation;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

import com.jspiders.cardekho_casestudy.entity.Car;
import com.jspiders.cardekho_casestudy.main.CarDekhoMenu;

public class CarOperation {
	
	int id;
	String name;
	String brand;
	String model;
	String fuelType;
	double price;
	boolean found = false;
	
	static ArrayList<Car> cars=createList();
	public static ArrayList<Car> createList(){
	ArrayList<Car> car = new ArrayList<Car>();
	return car;	
}

public void addCarDetails() {
	Scanner inp = new Scanner(System.in);
	System.out.println("HOW MANY CARS DO YOU WANT TO ADD");
	int carNo = inp.nextInt();
	
	for(int i=1; i<=carNo; i++) {
		
		System.out.println("Enter Your Car Id: ");
		int carId=inp.nextInt();
		System.out.println("Enter Your Car Name: ");
		String name=inp.nextLine();
		System.out.println("Enter Your Car Brand: ");
		String brand=inp.nextLine();
		System.out.println("Enter Your Car Model: ");
		String model=inp.nextLine();
		System.out.println("Enter Your Car FuelType: ");
		String fuelType=inp.nextLine();
		System.out.println("Enter Your Car Price: ");
		double price=inp.nextDouble();
		
		cars.add(new Car(carId, name, brand, model, fuelType, price));
		System.out.println("\n\n"+name+"Car Details Added Successfully !!!");
		
	}
}


public void searchCarDetails() {
	Scanner inp = new Scanner(System.in);
	System.out.println("==========Search By Car===========");
	System.out.println("1.Car Name\n2.Car Brand\n3.Car FuelType\n4.Go Back\n");
	int choice=inp.nextInt();
	
	switch(choice) {
	
	case 1:
		System.out.println("Enter Your Car Name");
		String name=inp.nextLine();
		for(Car e:cars) {
			if(e.getName().equals(name)) {
				System.out.println(e);
				found=true;
			}
		}
		if(!found) {
			System.out.println("Car with this "+ name +" is not present");
			}
		break;
		
	case 2:
		System.out.println("Enter Your Car Brand");
		String brand=inp.nextLine();
		for(Car e:cars) {
			if(e.getBrand().equals(brand)) {
				System.out.println(e);
				found=true;
			}
		}
		if(!found) {
			System.out.println("Car with this "+ brand +" is not present");
		}
		break;
		
	case 3:
		System.out.println("Enter Your Car FuelType");
		String fuelType=inp.nextLine();
		for(Car e:cars) {
			if(e.getFuelType().equals(fuelType)) {
				System.out.println(e);
				found=true;
			}
		}
		if(!found) {
			System.out.println("Car with this"+fuelType+"is not present");
		}
		break;
	
	case 4:
		CarDekhoMenu.menu();
		break;
		
	default:
		System.out.println("Invalid choice \n please choose the correct choice \n Try again...");
	}
}

public void updateCarDetails() {
	Scanner inp = new Scanner(System.in);
	System.out.println("==========All Cars Details==========");
	for(Car e:cars) {
		System.out.println(e);
	}
	System.out.println("=====Update Details===== ");
	System.out.println("1.Find car for update details\n2.Go Back");
	int choice=inp.nextInt();
	
	switch(choice) {
	
	case 1:
		System.out.println("Enter Car Id");
		int id = inp.nextInt();
		for(Car e:cars) {
			if(e.getCarId()==id) {
				System.out.println("Enter Car Name");
				String name=inp.nextLine();
				System.out.println("Enter Car Brand");
				String brand=inp.nextLine();
				System.out.println("Enter Car Model");
				String model=inp.nextLine();
				System.out.println("Enter Car FuelType");
				String fuelType=inp.nextLine();
				System.out.println("Enter Car Price");
				double price=inp.nextDouble();
				e.setName(name);
				e.setBrand(brand);
				e.setModel(model);
				e.setFuelType(fuelType);
				e.setPrice(price);
				System.out.println("!!! Updated Successfully !!!");
				found=true;
			}
		}
		if(!found) {
			System.out.println("Car with this "+id+"is not present");
		}
		break;
	
	case 2:
		CarDekhoMenu.menu();
		break;
		
	default:
		System.out.println("Invalid choice \n please choose correct option \n Try again \n");
	}
}

public void deleteCarDetails() throws ConcurrentModificationException {
	Scanner inp = new Scanner(System.in);
	System.out.println("Enter Car Id");
	int id = inp.nextInt();
	for(Car e:cars) {
		if(e.getCarId()==id) {
			cars.remove(cars.indexOf(e));
			System.out.println("!!! Delete Successfully !!!");
			found=true;
		}
	}
	if(!found) {
		System.out.println("car with this"+id+"is not present");
	}
	inp.close();
}

}