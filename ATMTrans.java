import java.util.Scanner;

class Account {
    private Double amount = 0.00;
    public void depositAmount(Double depositedAmount) {
        amount += depositedAmount;
        System.out.println("Balance Amount : " + amount);
        System.out.println("Transaction Successfull");
    }

    public void withdrawAmount(Double withdrawAmount) {
        try {
            if(withdrawAmount <= 0) {
                throw new InvalidAmountException("Invalid Amount");
            } else if(withdrawAmount > amount) {
                throw new InsufficientAmountException("Balance Insufficient");
            } else {
                amount -= withdrawAmount;
                System.out.println(amount);
                System.out.println("Transaction Successfull");
            }
        } catch (InvalidAmountException IAM) {
            System.out.println(IAM);
        } catch (InsufficientAmountException ISM) {
            System.out.println(ISM);
        }
        
    }

    public void checkBalance() {
        System.out.println(amount);
    }
}

class InsufficientAmountException extends Exception {
    InsufficientAmountException(String str) {
        super(str);
    }
}
class InvalidAmountException extends Exception {
    InvalidAmountException(String str) {
        super(str);
    }
} 

public class ATMTrans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account amount = new Account();
        System.out.println(" 1--> Deposit \n 2--> withdraw\n 3 --> Balance \n 4 -->Exit ");
        
        boolean count = true;
        while(count) {
            System.out.print("Enter a Number : ");
            int val = sc.nextInt();
            switch(val) {
            case 1:
                System.out.print("Enter Amount to Deposit  : ");
                Double n = sc.nextDouble();
                amount.depositAmount(n);
                break;
            
            case 2:
                System.out.print("Enter Amount to Withdraw  : ");
                Double m = sc.nextDouble();
                amount.withdrawAmount(m);
                break;

            case 3:
                amount.checkBalance();
                break;

            case 4:
                count = false;
                System.out.println("Thank You");
                break;
            }   
        }
        sc.close();
    }
}