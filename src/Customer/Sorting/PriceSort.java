package Customer.Sorting;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PriceSort {

    public void printSort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                What order do you want to sort?
                1/Ascending
                2/Descending
                0/back""");
        String sortOrder = scanner.nextLine();
        while (!sortOrder.matches("[0-2]")) {
            System.out.println("Invalid input, please try again");
            sortOrder = scanner.nextLine();
        }
        if (sortOrder.equals("0")) {
            System.out.println("go back");
        }else if(sortOrder.equals("1")) {
            List<Ascending> priceSort = new ArrayList<>();
            String line;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Items.csv"));
                while ((line = reader.readLine()) != null) {
                    String[] emptyArr = line.split(",");
                    priceSort.add(new Ascending(emptyArr[0], emptyArr[1], emptyArr[2], emptyArr[3]));
                }
                Collections.sort(priceSort);
                for (Ascending sorted : priceSort) {
                    System.out.println(sorted + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            List<Descending> priceSort = new ArrayList<>();
            String line;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Items.csv"));
                while ((line = reader.readLine()) != null) {
                    String[] emptyArr = line.split(",");
                    priceSort.add(new Descending(emptyArr[0], emptyArr[1], emptyArr[2], emptyArr[3]));
                }
                Collections.sort(priceSort);
                for (Descending sorted : priceSort) {
                    System.out.println(sorted + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
