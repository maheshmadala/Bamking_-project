import org.example.model.Account;
import org.example.service.AccountService;
import org.example.service.AccountServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public  class Main {

    public static  void main(String[] args)throws SQLException {
        Scanner  sc = new Scanner(System.in);
        AccountService service = new AccountServiceImpl();

        while (true) {

            System.out.println("\n1 . Create Account");
            System.out.println("2 . View Account");
            System.out.println("3 . Deposit");
            System.out.println("4 . Withdraw");
            System.out.println("5 .Transfer ");
            System.out.println("6 . Transaction History");
            System.out.println("7 . Exit");
                    System.out.println(" .Enter Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Account acc = new Account();
                     System.out.println("Name:");
                     acc.setName(sc.nextLine());

                    System.out.println("Email:");
                    acc.setEmail(sc.nextLine());

                    System.out.println("AcctNo:");
                    acc.setAcctNo(sc.nextLine());

                    System.out.println("Phone:");
                    acc.setPhone(sc.nextLine());


                    System.out.println("City:");
                    acc.setCity(sc.nextLine());

                    System.out.println("Balance:");
                    acc.setBalance(sc.nextDouble());
                    sc.nextLine();


                    service.CreateAccount(acc);
                    break;

                case 2:
                    System.out.println("Enter Account No: ");
                    String acctNo = sc.nextLine();
                    Account result = service.getAccount(acctNo);
                    if (result != null){
                        System.out.println(result.getId() + ""+ result.getAcctNo() +""+ result.getName() +""+
                                result.getEmail()+""+result.getPhone()+""+result.getCity()+""+
                                result.getBalance() );

                    }else {
                        System.out.println("Account Not Identified");
                    }
                    break;

                case 3:
                    System.out.println("Enter Account No: ");
                    String dAcc = sc.next();
                    System.out.println("Enter Amount");
                    double dAmt = sc.nextDouble();
                    service.deposit( String.valueOf(dAcc), dAmt);
                    break;
                case 4:
                    System.out.println("Enter Account No: ");
                    String wAcc = sc.next();
                    System.out.println("Enter Amount");
                    double wAmt = sc.nextDouble();
                    service.withdraw(wAcc, wAmt);
                    break;
                case 5 :
                    System.out.println("From Account : ");
                    String fAcc = sc.next();
                    System.out.println("To Account");
                    String tAcc = sc.next();
                    System.out.println("Amount");
                    double tAmt = sc.nextDouble();
                    service.transfer(fAcc,tAcc, tAmt);
                    break;
                case 6 :

                    System.out.println("Enter  Account No : ");
                    String hAcc = sc.next();
                    service.transactionHistory(hAcc);
                    break;
                case 7:
                    System.out.println("Exit ");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }

        }
    }
}
