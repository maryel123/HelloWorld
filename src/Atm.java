import java.util.Arrays;
import java.util.Scanner;

public class Atm {

    public static String accounts[][] = new String[3000][4], accountNumber = " ", accountName = " ";
    //VARIABLES
    public static int pinTrial = 3, currentuser = -1;
    public static double balance = 0, withdrawn = 0;


    public static void main(String[] args) {


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
            //CONTINUE


            //NESTED IF ELSE STATEMENT
            if (pin.equals(accounts[i][3])) {
                accountNumber = accounts[i][0];
                accountName = accounts[i][1];
                balance = Double.parseDouble(accounts[i][2]);


                if (pin.equals("1111")) {
                    currentuser = 0;
                } else if (pin.equals("2222")) {
                    currentuser = 1;
                } else if (pin.equals("3333")) {
                    currentuser = 2;
                }

                choosingOfTransactions();

            }
            //DO WHILE

                do {

                    pinTrial = pinTrial - 1;
                    System.out.println("Invalid pin number. \nPlease try again. ");
                    System.out.println("You have " + pinTrial + " attempts left.");
                    System.exit(0);

                    //IF STATEMENT
                    //CONTINUE
                    if (pin.equals("0000")) {
                        continue;

                    }

                } while (pin != accounts[currentuser][3]);

        }










    }

    private static void choosingOfTransactions() {

        char transaction;

        Scanner t = new Scanner(System.in);

        System.out.print("Choose Transaction: \n C-check balance \n W-withdraw  \n D-deposit \n E-exit  \n  ");
        transaction = t.next().charAt(0);

        //SWITCH
        //BREAK
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
                System.out.println("Thank you for using Marielle's Atm Machine. Please come back again.");

                pinEntering();
                currentuser = -1;
                break;

        }
    }



    private static void checkingOfBalance() {

        String answer;

        System.out.println("You currently have " + accounts[currentuser][2] + " pesos ");


        Scanner d = new Scanner(System.in);
        System.out.println("\n Would like to choose another transaction?(Yes/No) ");
        answer=d.nextLine();

        //TERNARY
        String result = (answer.equalsIgnoreCase("Yes")) ? "Rerun the program and enter your pin." : "Thank you for using Marielle's Atm Machine.";
        System.out.println(result);
        System.exit(0);

    }

    private static void withdraw() {
        int withdrawnAmount;
        Scanner b = new Scanner(System.in);
        System.out.println("Please input amount to withdraw:");
        withdrawnAmount = b.nextInt();

        //IF ELSE
            if (withdrawnAmount > balance) {
                System.out.println("Insufficient Balance");
                System.exit(0);
            } else if (withdrawnAmount < 100) {
                System.out.println("Invalid amount");
                System.exit(0);
            } else {

                balance = balance - withdrawnAmount;
                System.out.println("Transaction successful. Please get your cash.");
                System.exit(0);
            }


        }


    private static void deposit() {

        // WHILE LOOP
        float depositedAmount = 0f;
        Scanner b = new Scanner(System.in);
        System.out.println("Please input amount to deposit:");
        depositedAmount=b.nextFloat();

        while(depositedAmount <=0) {
            System.out.println("Invalid Amount");
            System.out.println("Please input amount to deposit:");
            depositedAmount=b.nextFloat();
        }
        accounts[currentuser][2] = String.valueOf(depositedAmount + Float.parseFloat(accounts[currentuser][2]));
        System.out.println("Your new balance is:" + accounts[currentuser][2]);
        System.out.println("Transaction Successful. Thank you." );
        choosingOfTransactions();
    }

    //when the users Exit
    // Garbage Collection Applied
    private static void exitMethod() {
        //clear the income and outcome Arraylist
        accounts[][].clear();

        //garbage collection to free up memory
        System.gc();

        //printing
        System.out.println("Garbage collection completed");
        System.exit(0);
    }


}