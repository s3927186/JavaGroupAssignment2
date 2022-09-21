package Admin;

import java.io.*;
import java.util.Scanner;

public class RemoveProduct {
    public void removeProduct(){
        String Line;
        try {
            Scanner scanner1 = new Scanner(new BufferedReader(new FileReader("Items.csv")));
            while ((scanner1.hasNextLine())) {
                Line = scanner1.nextLine();
                System.out.println(Line);
            }
            scanner1.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("---------------------------------------------------------");
            System.out.println("Which item's price do you want to remove?" + "\n Write \"back\" to go back");
            String choose = NewScanner.nextLine();
            if (choose.equalsIgnoreCase("back")) {
                System.out.println("go back");
            } else {
                //name must be character
                while(!choose.matches("[a-zA-Z\\s]+")){
                    System.out.println("Invalid input, please try again");
                    choose = NewScanner.nextLine();
                }
                try {
                    File log = new File(("ItemsTemp.csv"));
                    Scanner scanner2 = new Scanner(new BufferedReader(new FileReader("Items.csv")));
                    while ((scanner2.hasNextLine())) {
                        String details = scanner2.nextLine();
                        String[] CurrentLine = details.split(",");
                        int j = details.toLowerCase().indexOf(choose.toLowerCase());
                        if (j == -1) {
                            try{
                                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                                out.append(CurrentLine[0]).append(",").append(CurrentLine[1]).append(",")
                                        .append(CurrentLine[2]).append(",").append(CurrentLine[3]).append("\n");
                                out.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("Product have been removed");
                        }
                    }scanner2.close();
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Items.csv"));
                    Scanner scanner3 = new Scanner(new BufferedReader(new FileReader("ItemsTemp.csv")));
                    while ((scanner3.hasNextLine())) {
                        String ItemSwitch = scanner3.nextLine();
                        writer.write(ItemSwitch + "\n");
                    }
                    writer.close();
                    scanner3.close();
                    BufferedWriter NewWriter = new BufferedWriter(new FileWriter("ItemsTemp.csv"));
                    NewWriter.write("");
                    NewWriter.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
