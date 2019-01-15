import java.util.Scanner;

public class BankManagement{


	
	public static void main(String[] args){
	
		int menuSelect = 0;
	
		
		Scanner acctInput = new Scanner(System.in);
		//program start
		System.out.println("Welcome to Bank Management System\n");
		//create new account
		Account acct1 = new Account();

		System.out.print("Enter the account holder's name: ");
		//set acctName to user string
		acct1.setAcctName(acctInput.nextLine());

		System.out.print("Enter the initial balance: $");
		//set acctBalance to user double
		acct1.setAcctBalance(acctInput.nextDouble());


		System.out.println("... successfully created a new Account.");
		System.out.println("");
		
		do{
			System.out.println(">> MAIN MENU <<");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Balance Inquiry");
			System.out.println("4. Get future value");
			System.out.println("5. Get investment period");
			System.out.println("6. Exit");
			System.out.print(">> Select your option (1-6): ");
			
			menuSelect = acctInput.nextInt();
		
			System.out.println("");

			if(menuSelect == 1)
				acct1.Deposit();
			else if(menuSelect == 2)
				acct1.Withdraw();
			else if(menuSelect == 3)
				acct1.BalanceInquiry();
			else if(menuSelect == 4)
				acct1.InvestYears();
			else if(menuSelect == 5)
				acct1.InvestMoney();

			System.out.println("");
		
		} while(menuSelect != 6);
		
		acctInput.close();

		
	}
	
}
