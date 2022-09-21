package Admin;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AddProduct {
    //generated Customer ID
    private String ID;

    public String getID() {
        return ID;
    }

    public void ProductID() {
        Random random =new Random();
        String line;
        String s;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Items.csv"));
            while((line = reader.readLine()) != null) {
                String[] CurrentLine = line.split(",");
                String[] LeadId = CurrentLine[0].split("");
                int k = Integer.parseInt(LeadId[3]);
                k += 1;
                String t = Integer.toString(k);
                LeadId[3] = t;
                for(int i=5; i < 9;i++) {
                    int j = random.nextInt(9);
                    s = Integer.toString(j);
                    LeadId[i] = s;
                }
                ID = Arrays.toString(LeadId).replaceAll("[^-a-zA-Z\\d]","");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProduct() {
        ProductID();
        //Input items information
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        String Title = scanner.nextLine();
        System.out.println("Price:");
        String Price = scanner.nextLine();
        while(!Price.matches("\\d+")){
            System.out.println("Invalid input, please try again");
            Price = scanner.nextLine();
        }
        System.out.println("Category: ");
        String Category= scanner.nextLine();
        //append new information to csv file
        File log = new File(("Items.csv"));
        try{
            if (!log.exists()){
                System.out.println("no file found, need new file");
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(getID()).append(",").append(Title).append(",").append(Price).append(",").append(Category)
                    .append("\n");
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
