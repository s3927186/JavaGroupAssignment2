package Customer;

import java.io.*;
import java.util.*;

public class CategorySearch {
    //views all items in one category
    public void Category(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What Category do you want to see?" + "\n write \"back\" to go back");
        String category = scanner.nextLine();
        if (category.equalsIgnoreCase("back")) {
            System.out.println("go back");
        }else{
            try {
                String empty;
                scanner = new Scanner(new BufferedReader(new FileReader("Items.csv")));
                    while ((scanner.hasNextLine())) {
                        empty = scanner.nextLine();
                        int j = empty.toLowerCase().indexOf(category.toLowerCase());
                        if (j > 0) {
                            System.out.println(empty);
                        } else if (j == -1) {
                            System.out.print("");
                        } else {
                            System.out.println("We don't have this category");
                        }
                    }
                }catch (IOException e) {
                e.printStackTrace();
                }
            }
    }
}
