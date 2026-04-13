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
            System.out.println("3 . Update Balance");
            System.out.println("4 . Exit");

                    System.out.println("6 .Enter Choice");
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
                    String accNo = sc.nextLine();
                    Account accData = service.getAccount(accNo);
                    if(accData != null) {
                        System.out.println("Enter New Balance:");
                                        double newBalance = sc.nextDouble();
                        service.UpdateBalance(accData.getId(),newBalance);
                    }else {
                        System.out.println(" Account Not Found ");
                    }
                    break;
                case 4:
                    System.out.println("Exit ");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }

        }
    }
}
