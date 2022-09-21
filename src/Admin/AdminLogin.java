package Admin;

import java.io.*;
import java.util.*;

public class AdminLogin {
    public void Login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String Username = scanner.nextLine();
        System.out.println("Password:");
        String Password = scanner.nextLine();

        String line;
        String check = "no";
        try {
            while(check.equals("no")) {
                BufferedReader reader = new BufferedReader(new FileReader("Admin.csv"));
                while ((line = reader.readLine()) != null) {
                    String[] CurrentLine = line.split(",");
                    String user = (CurrentLine[0]);
                    String pass = (CurrentLine[1]);
                    if (Username.equals(user) && Password.equals(pass)) {
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
                    System.out.println("Welcome");
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
