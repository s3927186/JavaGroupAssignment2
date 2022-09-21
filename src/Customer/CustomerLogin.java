package Customer;

import java.io.*;
import java.util.*;

public class CustomerLogin {
    private String Username;
    private String Password;

    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
    public void Login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        Username = scanner.nextLine();
        System.out.println("Password:");
        Password = scanner.nextLine();

        String line;
        String check = "no";
        try {
            while(check.equals("no")) {
                BufferedReader reader = new BufferedReader(new FileReader("Customers.csv"));
                while ((line = reader.readLine()) != null) {
                    String[] CurrentLine = line.split(",");
                    String user = (CurrentLine[5]);
                    String pass = (CurrentLine[6]);
                    if (getUsername().equals(user) && getPassword().equals(pass)) {
                        check = "yes";
                        break;
                    } else {
                        check = "no";
                    }
                }
                if (check.equals("no")) {
                    System.out.println("Username or Password is incorrect");
                    System.out.println("Username: ");
                    Username = scanner.nextLine();
                    System.out.println("Password:");
                    Password = scanner.nextLine();
                } else {
                    System.out.println("Welcome " + getUsername());
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get information for Login user
    public void LoginInfo(){
        try {
            String info;
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("Customers.csv")));
            while ((scanner.hasNextLine())) {
                info = scanner.nextLine();
                int j = info.toLowerCase().indexOf(getUsername().toLowerCase());
                if (j > 0) {
                    System.out.println(info);
                    Scanner NewScanner = new Scanner(System.in);
                    System.out.println("Write \"back\" to go back");
                    String user = NewScanner.nextLine();
                    if (user.equalsIgnoreCase("back")) {
                        System.out.println("go back");
                    }
                } else if (j == -1) {
                    System.out.print("");
                } else {
                    System.out.println("Can't find the value");
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

