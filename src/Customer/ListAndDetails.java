package Customer;

import java.io.*;
import java.util.*;

public class ListAndDetails {
    //Print Lists and Product Details
    public void ListsDetails() {
        try {
            int RowCount = 0;
            String input;
            System.out.println("    ID       Title     Price  Category");
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("Items.csv")));
            while ((scanner.hasNextLine())) {
                input = scanner.nextLine();
                RowCount++;
                System.out.println(input);
            }
            scanner.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("---------------------------------------------------------");
            System.out.println("What items do you want to see?" + "\n write \"back\" to go back");
            String user = NewScanner.nextLine();
            if (user.equalsIgnoreCase("back")) {
                System.out.println("go back");
            } else {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("Items.csv"));
                    for (int i = 1; i <= RowCount; i++) {
                        String details = reader.readLine();
                        int j = details.toLowerCase().indexOf(user.toLowerCase());
                        if (j > 0) {
                            System.out.println(details);
                        } else if (j == -1) {
                            System.out.print("");
                        } else {
                            System.out.println("items not found");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}