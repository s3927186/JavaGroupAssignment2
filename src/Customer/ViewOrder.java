package Customer;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ViewOrder {

    private String CusID;

    private int total;

    private int RowCount;

    public int getRowCount(){
        return RowCount;
    }

    public int getTotal(){
        return total;
    }

    public String getCusID(){
        return CusID;
    }

    public void getCustomerID(){
        RowCount = 0;
        Scanner scanner0 = new Scanner(System.in);
        System.out.println("Enter your Username:");
        String getUsername = scanner0.nextLine();
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("Customers.csv")));
            while ((scanner.hasNextLine())) {
                RowCount++;
                String details = scanner.nextLine();
                int j = details.toLowerCase().indexOf(getUsername.toLowerCase());
                if (j > 0) {
                    String[] CusIDArray = details.split(",");
                    CusID = CusIDArray[0];
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void OrderInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter OrderID:");
        String orderID = scanner.nextLine();
        String Order;
        try {
            Scanner scanner2 = new Scanner(new BufferedReader(new FileReader("Orders.csv")));
            while ((scanner2.hasNextLine())) {
                Order = scanner2.nextLine();
                int j = Order.toLowerCase().indexOf(orderID.toLowerCase());
                if (j == 0) {
                    System.out.println(Order);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void Upgrade(){
        Scanner scanner3 = new Scanner(System.in);
        String ans;
        if(getTotal() > 25000000){
            System.out.println("""
                    You are qualified to get Platinum membership
                     with Platinum membership you will get 15% discount for every product purchased
                     Do you want to proceed? yes/no""");
            ans = scanner3.nextLine();
            while (!ans.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input, please try again");
                ans = scanner3.nextLine();
            }
            if(ans.equalsIgnoreCase("no")){
                System.out.println("go back");
            }else{
                try {
                    File log = new File(("ItemsTemp.csv"));
                    Scanner scanner4 = new Scanner(new BufferedReader(new FileReader("Customers.csv")));
                    while ((scanner4.hasNextLine())) {
                        String details = scanner4.nextLine();
                        String[] CurrentLine = details.split(",");
                        int j = details.toLowerCase().indexOf(getCusID().toLowerCase());
                        if (j == 0) {
                            CurrentLine[4] = "Platinum";
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
                            System.out.println("Your are a Platinum Member now!");
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
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Customers.csv"));
                    BufferedReader NewReader = new BufferedReader(new FileReader("ItemsTemp.csv"));
                    for (int i = 1; i <= getRowCount(); i++) {
                        String ItemSwitch = NewReader.readLine();
                        writer.write(ItemSwitch + "\n");
                    }
                    writer.close();
                    NewReader.close();
                    BufferedWriter NewWriter = new BufferedWriter(new FileWriter("ItemsTemp.csv"));
                    NewWriter.write("");
                    NewWriter.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }else if (getTotal() > 10000000){
            System.out.println("""
                    You are qualified to get Gold membership
                     with Gold membership you will get 10% discount for every product purchased
                     Do you want to proceed? yes/no""");
            ans = scanner3.nextLine();
            while (!ans.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input, please try again");
                ans = scanner3.nextLine();
            }
            if(ans.equalsIgnoreCase("no")){
                System.out.println("go back");
            }else{
                try {
                    File log = new File(("ItemsTemp.csv"));
                    Scanner scanner4 = new Scanner(new BufferedReader(new FileReader("Customers.csv")));
                    while ((scanner4.hasNextLine())) {
                        String details = scanner4.nextLine();
                        String[] CurrentLine = details.split(",");
                        int j = details.toLowerCase().indexOf(getCusID().toLowerCase());
                        if (j == 0) {
                            CurrentLine[4] = "Gold";
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
                            System.out.println("Your are a Gold Member now!");
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
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Customers.csv"));
                    BufferedReader NewReader = new BufferedReader(new FileReader("ItemsTemp.csv"));
                    for (int i = 1; i <= getRowCount(); i++) {
                        String ItemSwitch = NewReader.readLine();
                        writer.write(ItemSwitch + "\n");
                    }
                    writer.close();
                    NewReader.close();
                    BufferedWriter NewWriter = new BufferedWriter(new FileWriter("ItemsTemp.csv"));
                    NewWriter.write("");
                    NewWriter.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }else if (getTotal() > 5000000){
            System.out.println("""
                    You are qualified to get Silver membership
                     with Silver membership you will get 5% discount for every product purchased
                     Do you want to proceed? yes/no""");
            ans = scanner3.nextLine();
            while (!ans.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input, please try again");
                ans = scanner3.nextLine();
            }
            if(ans.equalsIgnoreCase("no")){
                System.out.println("go back");
            }else{
                try {
                    File log = new File(("ItemsTemp.csv"));
                    Scanner scanner4 = new Scanner(new BufferedReader(new FileReader("Customers.csv")));
                    while ((scanner4.hasNextLine())) {
                        String details = scanner4.nextLine();
                        String[] CurrentLine = details.split(",");
                        int j = details.toLowerCase().indexOf(getCusID().toLowerCase());
                        if (j == 0) {
                            CurrentLine[4] = "Silver";
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
                            System.out.println("Your are a Silver Member now!");
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
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Customers.csv"));
                    BufferedReader NewReader = new BufferedReader(new FileReader("ItemsTemp.csv"));
                    for (int i = 1; i <= getRowCount(); i++) {
                        String ItemSwitch = NewReader.readLine();
                        writer.write(ItemSwitch + "\n");
                    }
                    writer.close();
                    NewReader.close();
                    BufferedWriter NewWriter = new BufferedWriter(new FileWriter("ItemsTemp.csv"));
                    NewWriter.write("");
                    NewWriter.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("your total spending is not enough for higher memberships");
        }
    }
    public void runViewOrder(){
        getCustomerID();
        String AllOrder;
        int input;
        try {
            Scanner scanner1 = new Scanner(new BufferedReader(new FileReader("Orders.csv")));
            while ((scanner1.hasNextLine())) {
                AllOrder = scanner1.nextLine();
                String[] cost = AllOrder.split(",");
                int spending = Integer.parseInt(cost[4]);
                int j = AllOrder.toLowerCase().indexOf(getCusID().toLowerCase());
                if(j>0){
                    System.out.println(AllOrder);
                    if (cost[6].equalsIgnoreCase("paid")) {
                        total += spending;
                    }else {
                        System.out.print("");
                    }
                }else{
                    System.out.print("");
                }
            }
            scanner1.close();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your total spending is:" + getTotal() + " VND\n");
            do{
                System.out.println("""
                            What do you want to do?
                            1/View an Order
                            2/Upgrade memberships
                            0/back""");
                input = scanner.nextInt();
                switch (input){
                    case 0 -> System.out.print("");
                    case 1 -> OrderInfo();
                    case 2 -> Upgrade();
                    default -> System.out.println("Invalid input, try again");
                }
            }while (input !=0 );
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
