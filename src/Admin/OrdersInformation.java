package Admin;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class OrdersInformation {

    public void FindOrder(){
        String Line;
        try {
            Scanner scanner0 = new Scanner(new BufferedReader(new FileReader("Orders.csv")));
            while ((scanner0.hasNextLine())) {
                Line = scanner0.nextLine();
                System.out.println(Line);
            }
            scanner0.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("---------------------------------------------------------");
            System.out.println("Which Customer's order do you want to see? Enter Customer ID"
                    + "\n Write \"back\" to go back");
            String name = NewScanner.nextLine();
            if (name.equalsIgnoreCase("back")) {
                System.out.println("go back");
            } else {
                try {
                    Scanner scanner = new Scanner(new BufferedReader(new FileReader("Orders.csv")));
                    while ((scanner.hasNextLine())) {
                        String details = scanner.nextLine();
                        int j = details.toLowerCase().indexOf(name.toLowerCase());
                        if (j > 0) {
                            System.out.println(details);
                        } else {
                            System.out.print("");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ChangeStatus(){
        int RowCount = 0;
        String Line;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("Orders.csv")));
            while ((scanner.hasNextLine())) {
                Line = scanner.nextLine();
                RowCount++;
                System.out.println(Line);
            }
            scanner.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("---------------------------------------------------------");
            System.out.println("Which order do you want to change? Enter Order ID" + "\n Write \"back\" to go back");
            String order = NewScanner.nextLine();
            if (order.equalsIgnoreCase("back")) {
                System.out.println("go back");
            } else {
                try {
                    File log = new File(("ItemsTemp.csv"));
                    BufferedReader reader = new BufferedReader(new FileReader("Orders.csv"));
                    for (int i = 1; i <= RowCount; i++) {
                        String details = reader.readLine();
                        String[] CurrentLine = details.split(",");
                        int j = details.toLowerCase().indexOf(order.toLowerCase());
                        if (j == 0) {
                            CurrentLine[6] = "PAID";
                            try {
                                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                                out.append(CurrentLine[0]).append(",").append(CurrentLine[1]).append(",")
                                        .append(CurrentLine[2]).append(",").append(CurrentLine[3]).append(",")
                                        .append(CurrentLine[4]).append(",").append(CurrentLine[5]).append(",")
                                        .append(CurrentLine[6]).append("\n");
                                out.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Order has been updated");
                            System.out.println(Arrays.toString(CurrentLine));
                        } else {
                            try {
                                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                                out.append(CurrentLine[0]).append(",").append(CurrentLine[1]).append(",")
                                        .append(CurrentLine[2]).append(",").append(CurrentLine[3]).append(",")
                                        .append(CurrentLine[4]).append(",").append(CurrentLine[5]).append(",")
                                        .append(CurrentLine[6]).append("\n");
                                out.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Orders.csv"));
                    BufferedReader NewReader = new BufferedReader(new FileReader("ItemsTemp.csv"));
                    for (int i = 1; i <= RowCount; i++) {
                        String ItemSwitch = NewReader.readLine();
                        writer.write(ItemSwitch + "\n");
                    }
                    writer.close();
                    NewReader.close();
                    BufferedWriter NewWriter = new BufferedWriter(new FileWriter("ItemsTemp.csv"));
                    NewWriter.write("");
                    NewWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Revenue(){
        String AllOrder;
        int total = 0;
        int executed = 0;
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("Orders.csv")));
            while ((sc.hasNextLine())) {
                AllOrder = sc.nextLine();
                String[] Rev = AllOrder.split(",");
                int spending = Integer.parseInt(Rev[4]);
                if (Rev[6].equalsIgnoreCase("paid")) {
                    total += spending;
                    executed++;
                } else {
                    System.out.print("");
                }
            }
            sc.close();
            System.out.println("Store total revenue is: " + total + " VND");
            System.out.println("There are " + executed + " executed orders today\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void ShowOrder() {
        Scanner scanner = new Scanner(System.in);
        int input;
        do{
            System.out.println("""
                           What do you want to do?
                           1/Get customer's orders
                           2/Change order status
                           3/Store Total Revenue
                           0/back""");
            input = scanner.nextInt();
            switch (input){
                case 0 -> System.out.print("");
                case 1 -> FindOrder();
                case 2 -> ChangeStatus();
                case 3 -> Revenue();
                default -> System.out.println("Invalid input, try again");
            }
        }while (input !=0 );
    }
}
