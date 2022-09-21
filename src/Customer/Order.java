package Customer;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Order {
    //generated Order Id
    private String ID;
    private String CusID;
    private String Type;

    public String getType(){
        return Type;
    }

    public String getCusID(){
        return CusID;
    }

    public String getID() {
        return ID;
    }

    public void OrderID() {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Orders.csv"));
            while((line = reader.readLine()) != null) {
                String[] CurrentLine = line.split(",");
                String[] LeadId = CurrentLine[0].split("");
                int i = Integer.parseInt(LeadId[3]);
                i += 1;
                String s = Integer.toString(i);
                LeadId[3] = s;
                ID = Arrays.toString(LeadId).replaceAll("[^a-zA-Z\\d]","");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //get customer ID
    public void getCustomerID(){
        Scanner scanner0 = new Scanner(System.in);
        System.out.println(" what is your Username?");
        String getUsername = scanner0.nextLine();
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("Customers.csv")));
            while ((scanner.hasNextLine())) {
                String details = scanner.nextLine();
                int j = details.toLowerCase().indexOf(getUsername.toLowerCase());
                if (j > 0) {
                    String[] CusIDArray = details.split(",");
                    CusID = CusIDArray[0];
                    Type = CusIDArray[4];
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //show Order
    public void ShowOrder() {
        try {
            String empty;
            System.out.println("  ID          Title     Price  Category");
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("Items.csv")));
            while ((scanner.hasNextLine())) {
                empty = scanner.nextLine();
                System.out.println(empty);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create order
    public void CreateOrder(){
        getCustomerID();
        ShowOrder();
        String check = "no";
        Scanner NewScanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        while(check.equals("no")) {
            System.out.println("What items do you want to Ordered?" + "\n write \"no\" to go back");
            String user = NewScanner.nextLine();
            if (user.equalsIgnoreCase("no")) {
                check = "yes";
                System.out.println("go back");
            } else {
                OrderID();
                int NewPrice;
                try {
                    Scanner scanner = new Scanner(new BufferedReader(new FileReader("Items.csv")));
                    while ((scanner.hasNextLine())) {
                        String details = scanner.nextLine();
                        int j = details.toLowerCase().indexOf(user.toLowerCase());
                        String[] types = details.split(",");
                        int price = Integer.parseInt(types[2]);
                        if(getType().equalsIgnoreCase("silver")){
                            NewPrice = price-(price*5/100);
                        }else if(getType().equalsIgnoreCase("gold")){
                            NewPrice = price - (price*10/100);
                        }else if (getType().equalsIgnoreCase("platinum")){
                            NewPrice = price - (price*15/100);
                        }else{
                            NewPrice = price;
                        }
                        StringBuilder NewDetails =new StringBuilder();
                        NewDetails.append(types[1]).append(",").append(NewPrice).append(",").append(types[3]);
                        if (j > 0) {
                            System.out.println(NewDetails + ",PENDING");
                            //append new information to csv file
                            File log = new File(("Orders.csv"));
                            try {
                                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                                out.append(getID()).append(",").append(getCusID()).append(",").append(getType())
                                        .append(",").append(NewDetails).append(",").append("ORDERED").append("\n");
                                out.close();
                                System.out.println("Item ordered, do you want to add more? (yes/no)");
                                String ans = NewScanner.nextLine();
                                if (ans.equalsIgnoreCase("no")) {
                                    check = "yes";
                                } else {
                                    check = "no";
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (j == -1) {
                            System.out.print("");
                        } else {
                            System.out.println("items not found");
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
