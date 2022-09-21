package Admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class View {
    Scanner scanner =new Scanner(System.in);
    public void ViewItems() {
        try {
            String empty;
            scanner = new Scanner(new BufferedReader(new FileReader("Items.csv")));
            while ((scanner.hasNextLine())) {
                empty = scanner.nextLine();
                System.out.println(empty);
            }
            scanner.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("Write \"back\" to go back");
            String user = NewScanner.nextLine();
            if (user.equalsIgnoreCase("back")) {
                System.out.println("go back");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ViewOrders(){
        try {
            String empty;
            scanner = new Scanner(new BufferedReader(new FileReader("Orders.csv")));
            while ((scanner.hasNextLine())) {
                empty = scanner.nextLine();
                System.out.println(empty);
            }
            scanner.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("Write \"back\" to go back");
            String user = NewScanner.nextLine();
            if (user.equalsIgnoreCase("back")) {
                System.out.println("go back");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ViewCustomers(){
        try {
            String empty;
            scanner = new Scanner(new BufferedReader(new FileReader("Customers.csv")));
            while ((scanner.hasNextLine())) {
                empty = scanner.nextLine();
                System.out.println(empty);
            }
            scanner.close();
            Scanner NewScanner = new Scanner(System.in);
            System.out.println("Write \"back\" to go back");
            String user = NewScanner.nextLine();
            if (user.equalsIgnoreCase("back")) {
                System.out.println("go back");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}