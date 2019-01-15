import java.util.Scanner;
import java.lang.Math;

public class Account{

	public Scanner userInput = new Scanner(System.in);
    public String acctName;
    public double acctBalance;
    /*
    public double acctChequing;
    public double acctSavings;
     */
    private static final double INTEREST_RATE = 0.3; //investment interest rate

    //first line of every account class
    public void printCreate(){

   	 System.out.println("Creating a new Account ...");

    }

    //constructs new blank account
    public Account(){

   	 printCreate();
   	 acctName = null;
   	 acctBalance = 0.0;
    }

    //constructs new account with parameters
    public Account(String name, double balance){

   	 printCreate();
   	 this.acctName = name;
   	 this.acctBalance = balance;

    }
    /*
public Account(String name, double balSavings, balChequing){

    printCreate();
    this.acctName = name;
    this.acctSavings = balSavings;
    this.acctChequing = balChequing;

}
     */
    public void Deposit(){

   	 double deposit = 0.0;
   	 
   	 System.out.print("Enter amount to deposit: $");
   	 System.out.println("");
   	 deposit = userInput.nextDouble();
   	 if(deposit >= 0){
   		 acctBalance = acctBalance + deposit;
   		 System.out.println("***You deposited $" + deposit);
   	 }
   	 else{
   		 System.out.println("Invalid entry! May only deposit positive $ amounts. Returning to main menu...");
   	 }
   	 
    }

    public void Withdraw(){

   	 double withdraw = 0.0;

   	 System.out.print("Enter amount to withdraw $");
   	 System.out.println("");
   	 withdraw = userInput.nextDouble();
   	 if(withdraw <= acctBalance && withdraw >= 0){
   		 acctBalance = acctBalance - withdraw;
   		 System.out.println("***You withdrew $" + withdraw);
   	 }
   	 else{
   		 System.out.println("Invalid entry! May only withdraw available funds. Returning to main menu...");
   	 }
   	
    }

    public void BalanceInquiry(){

   	 System.out.println(acctName + "'s balance: $" + acctBalance);
    }

    public void InvestYears(){

   	 double future = 0.0;
   	 double years = 0.0;

   	 System.out.print("Enter the investment time (in years): ");
   	 years = userInput.nextDouble();
   	 if(years > 0.0){
   		 System.out.println("");
   		 future = acctBalance * Math.pow((1 + INTEREST_RATE), years);
   		 System.out.println("***After " + years + " year(s): $" + future);
   	 }
   	 else{
   		 System.out.println("Invalid entry! Set time to future date. Returning to main menu...");
   	 }


    }

    public void InvestMoney(){

   	 double future = 0.0;
   	 double years = 0.0;

   	 System.out.print("Enter your goal value: $");
   	 future = userInput.nextDouble();
   	 if(future >= acctBalance){
   		 System.out.println("");
   		 years = Math.log((future/acctBalance)) / Math.log((1 + INTEREST_RATE));
   		 System.out.println("***It will take " + years + " years to reach your goal!");
   	 }
   	 else{
   		 System.out.println("Invalid entry! Goal must be greater than account balance. Returning to main menu...");
   	 }
   	

    }

    public String getAcctName() {
   	 return acctName;
    }

    public void setAcctName(String acctName) {
   	 this.acctName = acctName;
    }

    public double getAcctBalance() {
   	 return acctBalance;
    }

    public void setAcctBalance(double acctBalance) {
   	 this.acctBalance = acctBalance;
    }

}



