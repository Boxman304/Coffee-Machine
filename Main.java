package coffeeMachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static int coffeeCount = 0;
	private static int teaCount = 0;
    private static int hotChocolateCount = 0;
    private static int orangeJuiceCount = 0;
    private static double totalEarnings = 0;
    private static final String FILE_PATH = "C:\\Users\\Omen\\Desktop\\coffee_machine_data.txt";

	public static CoffeeMachineOrder order() {
		loadDataFromFile();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		DrinkType drink = DrinkType.TEA;
		char isHot = 'Y';
		int sugar=0;
		String message;
		while(true) {
		System.out.println("What would you like to drink?(T/H/C/O)");
		char choice=sc.next().charAt(0);
		if (choice=='T') {
			drink=DrinkType.TEA;
			teaCount++;
			saveDataToFile();
		}
	
		else if(choice=='H') {
			drink=DrinkType.HOT_CHOCOLATE;
			hotChocolateCount++;
			saveDataToFile();
		}
		else if (choice=='C') {
			drink=DrinkType.COFFEE;
			coffeeCount++;
			saveDataToFile();
		}
		else if (choice=='O') {
			drink=DrinkType.ORANGE_JUICE;
			orangeJuiceCount++;
			 saveDataToFile();
		}
		else if (choice=='M') {
			System.out.println("What would you like your message to be?");
			message=sc.next();
			CoffeeMachineOrder ord = new CoffeeMachineOrder.CoffeeMachineOrderBuilder().setMessage(message).build();
			return ord;
		}
		if (choice=='T' || choice=='H' || choice=='C') {
			System.out.println("Would you like your drink EXTRA hot? (Y/N)");
			isHot=sc.next().charAt(0);
		System.out.println("How many sugar cubes would you like with your drink? ");
		try {
			 sugar= sc.nextInt();
			 
				if(sugar<0) {
					System.out.println("Invalid Integer");
				}
			} catch (InputMismatchException e) {
			  e.printStackTrace();
			  System.err.println("Entered value is not an integer");
			
			}
		double price = CoffeeMachineOrder.calculatePrice(drink);
		totalEarnings+=price;
		saveDataToFile();
		System.out.println("Enter your balance:");
		double balance=sc.nextDouble();
		while (balance<price) {
			System.out.println("OMD, Les Pauvres");
			System.out.println("Add funds: ");
			double addFunds=sc.nextDouble();
			if (addFunds==0) {
				System.out.print("Lmao invalid transaction");
				}
			else {
				balance+=addFunds;
				
			}	
		}

		return new CoffeeMachineOrder.CoffeeMachineOrderBuilder().setDrink(drink).setSugar(sugar).setTouillete(sugar > 0? true: false).setAmount(price).setBalance(balance).setExtraHot(isHot=='Y'?true:false).build();	
		}
		if (choice=='O') {
			System.out.println("How many sugar cubes would you like with your drink? ");
			try {
				 sugar= sc.nextInt();
				 
					if(sugar<0) {
						System.out.println("Invalid Integer");
					}
				} catch (InputMismatchException e) {
				  e.printStackTrace();
				  System.err.println("Entered value is not an integer");
				
				}
			double price = CoffeeMachineOrder.calculatePrice(drink);
			totalEarnings+=price;
			saveDataToFile();
			System.out.println("Enter your balance:");
			double balance=sc.nextDouble();
			if (balance<price) {
				System.out.println("Omd, les pouvres");
			}
			else {
				return new CoffeeMachineOrder.CoffeeMachineOrderBuilder().setDrink(drink).setSugar(sugar).setTouillete(sugar > 0? true: false).setAmount(price).setBalance(balance).build();
		}}
		if (choice=='B') {
			break;
		}}
		return null;
		
	}
	
public static void main(String[] args) {
System.out.println(order().toString());

}

private static void loadDataFromFile() {
    try {
        File file = new File (FILE_PATH);
        if (!file.exists()) {
            System.out.println("No data file found. Starting with default values.");
            return;
        }
        Scanner scanner = new Scanner(file);
        String[] data = scanner.nextLine().split(",");
        coffeeCount = Integer.parseInt(data[0]);
        teaCount = Integer.parseInt(data[1]);
        hotChocolateCount = Integer.parseInt(data[2]);
        orangeJuiceCount = Integer.parseInt(data[3]);
        totalEarnings = Double.parseDouble(data[4]);
        scanner.close();
    } catch (IOException e) {
        System.err.println("Error loading data from file: " + e.getMessage());
    }
}

private static void saveDataToFile() {
    try {
        FileWriter writer = new FileWriter(new File(FILE_PATH));
        writer.write(coffeeCount + "," + teaCount + "," + hotChocolateCount + "," + orangeJuiceCount + "," + totalEarnings);
        writer.close();
    } catch (IOException e) {
        System.err.println("Error saving data to file: " + e.getMessage());
    }
}


}