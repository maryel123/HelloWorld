import java.util.Scanner;

    public class Atm {

    public static String accounts[][] = new String[3000][4], accountNumber = " ", accountName = " ";

    public static int pinTrial = 3;
    public static double balance = 0, withdrawn = 0;

    public static void main(String[] args) {

        //VARIABLES
        accounts[0][0] = "0123-4567-8901";
        accounts[0][1] = "John Doe";
        accounts[0][2] = "5000.00";
        accounts[0][3] = "1111";

        accounts[1][0] = "2345-6789-0123";
        accounts[1][1] = "Totie Marie";
        accounts[1][2] = "0.00";
        accounts[1][3] = "2222";

        accounts[2][0] = "3456-7890-1234";
        accounts[2][1] = "Jessica Martinez";
        accounts[2][2] = "10000";
        accounts[2][3] = "3333";




        pinEntering();
    }

    public static void pinEntering() {

        String pin;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pin");
        pin=sc.nextLine();

        //FOR LOOP
        for (int i = 0; i < accounts.length; i++) {

            //IF STATEMENT
            if (pin.equals(accounts[i][3])) {
                accountNumber = accounts[i][0];
                accountName = accounts[i][1];
                balance = Double.parseDouble(accounts[i][2]);
                choosingOfTransactions();}




        }




    }








    private static void choosingOfTransactions() {
        //SWITCH
        char transaction;

        Scanner t = new Scanner(System.in);

        System.out.print("Choose Transaction: \n C-check balance \n W-withdraw  \n D-deposit \n E-exit  \n  ");
        transaction = t.next().charAt(0);

        switch (Character.toUpperCase(transaction))
        {

            case 'C':
                checkingOfBalance();
                break;


            case 'W':
                withdraw();
                break;

            case 'D':
                deposit();
                break;

            case 'E':
                System.exit(0);
                break;

        }
    }




    private static void checkingOfBalance() {
        //TERNARY
        String result = (balance > 0) ? "Sufficient balance" : "Inufficient balance" ;

        System.out.println("You have" + result);


    }

    private static void withdraw() {
        int withdrawnAmount;
        Scanner b = new Scanner(System.in);
        System.out.println("Please input amount to withdraw:");
        withdrawnAmount=b.nextInt();


        if (withdrawnAmount< balance) {
            System.out.println("Insufficient Balance");
        }
        else if (withdrawnAmount<100) {
            System.out.println("Invalid amount");
        }


        else {

            balance=balance-withdrawnAmount;
            System.out.println("Transaction successful. Please get your cash.");
            System.exit(0);
        }



    }


    private static void deposit() {

        // WHILE LOOP
            int depositedAmount;
            Scanner b = new Scanner(System.in);
            System.out.println("Please input amount to deposit:");
            depositedAmount=b.nextInt();

            while(depositedAmount <=0) {
                System.out.println("Invalid Amount");
                System.out.println("Please input amount to deposit:");
                depositedAmount=b.nextInt();

        }


        balance= balance + depositedAmount;
        System.out.println("Your new balance is:" + balance);
        System.out.println("Transaction Successful. Thank you." );

        choosingOfTransactions();

    }


}