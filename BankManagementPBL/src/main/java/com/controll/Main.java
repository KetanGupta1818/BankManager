package com.controll;

import com.database.ConnectorToMysql;
import com.domain.Details;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        ConnectorToMysql connectorToMysql = new ConnectorToMysql();
        System.out.println("Welcome ");
        while(true){
            connectorToMysql.main();
            System.out.println("1) List details ");
            System.out.println("2) Get Details by Name");
            System.out.println("3) Insert Details");
            System.out.println("4) Delete Details by id");
            System.out.println("Any other integer to exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    connectorToMysql.getAllDetails().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Enter name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    connectorToMysql.getDetailsByName(name).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter name");
                    scanner.nextLine();
                    String name1 = scanner.nextLine();
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter amount ");
                    float amount = scanner.nextFloat();
                    connectorToMysql.putDetails(new Details(id,name1,amount));
                    break;
                case 4:
                    System.out.println("Enter is");
                    int d = scanner.nextInt();
                    connectorToMysql.deleteDetailsById(d);
                    break;
                default:
                    return;
            }
        }
    }
}
//connectorToMysql.main();
//        System.out.println(connectorToMysql.getAllDetails());
//        connectorToMysql.main();
//        System.out.println(connectorToMysql.getDetailsByName("Tom"));
////        connectorToMysql.main();
////        connectorToMysql.putDetails(new Details(4,"Silly",340));
//        connectorToMysql.main();
//        connectorToMysql.deleteDetailsById(3);