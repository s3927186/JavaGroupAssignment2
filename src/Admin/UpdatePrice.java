package Admin;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class UpdatePrice {
    public void Update(){
        int RowCount = 0;
        String Line;
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("Items.csv")));
            while ((scanner.hasNextLine())) {
                Line = scanner.nextLine();
                RowCount++;
                System.out.println(Line);
            }
            scanner.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("---------------------------------------------------------");
            System.out.println("Which item's price do you want to change?" + "\n Write \"back\" to go back");
            String choose = NewScanner.nextLine();
            if (choose.equalsIgnoreCase("back")) {
                System.out.println("go back");
            } else {
                //name must be character
                while(!choose.matches("[a-zA-Z]+")){
                    System.out.println("Invalid input, please try again");
                    choose = NewScanner.nextLine();
                }
                try {
                    File log = new File(("ItemsTemp.csv"));
                    BufferedReader reader = new BufferedReader(new FileReader("Items.csv"));
                    for (int i = 1; i <= RowCount; i++) {
                        String details = reader.readLine();
                        String[] CurrentLine = details.split(",");
                        int j = details.toLowerCase().indexOf(choose.toLowerCase());
                        if (j > 0) {
                            System.out.println("What is the new price?");
                            String NewPrice = NewScanner.nextLine();
                            CurrentLine[2] = NewPrice;
                            try{
                                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                                out.append(CurrentLine[0]).append(",").append(CurrentLine[1]).append(",")
                                        .append(CurrentLine[2]).append(",").append(CurrentLine[3]).append("\n");
                                out.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Price has been updated");
                            System.out.println(Arrays.toString(CurrentLine));
                        }else {
                            try{
                                PrintWriter out = new PrintWriter(new FileWriter(log, true));
                                out.append(CurrentLine[0]).append(",").append(CurrentLine[1]).append(",")
                                        .append(CurrentLine[2]).append(",").append(CurrentLine[3]).append("\n");
                                out.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.println("Write \"back\" to go back");
                    String back = NewScanner.nextLine();
                    if (back.equalsIgnoreCase("back")) {
                        System.out.println("go back");
                    } else {
                        while (!back.matches("[a-zA-Z]+")) {
                            System.out.println("Invalid input, please try again");
                            back = NewScanner.nextLine();
                        }
                    }
                    //Rewrite old data with new data
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Items.csv"));
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
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
