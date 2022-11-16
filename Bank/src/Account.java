import java.util.Scanner;
public class Account {
	//Class variables 
	int balance;
	int prevTrans;
	String custName;
	String custID;
	
	//class constructor
	public Account(String cname,String cid) {
		custName = cname;
		custID = cid;
	}
	
	//function for depositing money
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance+amount;
			prevTrans = amount;
		}
	}
	
	//function for withdrawing money
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			prevTrans = -amount;
		}
	}
	
	//function to show prev trans
	void getPreviousTrans() {
		if(prevTrans > 0) {
			System.out.println("Deposited: "+prevTrans);
		} 
		else if(prevTrans < 0) {
			System.out.println("Withdrew: "+Math.abs(prevTrans));
		}
		else {
			System.out.println("No previous transaction");
		}
	}
	
	//function calculating interest based on years you input
	void calcInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years)+balance;
		System.out.println("The current interest rate is "+(100*interestRate)+"%");
		System.out.println("After "+years+" years, your balance will be: "+newBalance);
	}
	
	//function showing the main menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, "+custName+"!");
		System.out.println("Your ID is: "+custID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Please enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			//case A allows users to check their balance
			case 'A':
				System.out.println("=============================");
				System.out.println("Balance = $"+balance);
				System.out.println("=============================");
				System.out.println();
				break;
			//case B allows users to deposit money into their account
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
			//Case C allows users to withdraw money from their account
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
				//case D allows users to view their prev trans on their account
			case 'D':
				System.out.println("===========================");
				getPreviousTrans();
				System.out.println("===========================");
				System.out.println();
				break;
				//case E calculates interest on users account after input of years
			case 'E':
				System.out.println("Enter how many years of accrued interest: ");
				int years = scanner.nextInt();
				calcInterest(years);
				break;
				//case F exits the user from their account
			case 'F':
				System.out.println("============================");
				break;
				//default is when the user entered an invalid option
			default:
				System.out.println("Error. Invalid option entered. Please enter A, B, C, D, E, or F");
				break;
			}
			
		}	while(option != 'F');
				System.out.println("Thank you for banking with us!");
	}
}
