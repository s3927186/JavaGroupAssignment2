package Customer;

import java.io.*;
import java.util.*;

public class CustomerRegister {
    private String Username;
    private String ID;

    public String getUsername(){
        return Username;
    }
    public String getID() {
        return ID;
    }

    public void CustomerID() {
        //generated Customer ID
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Customers.csv"));
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


    public void Register() {
        CustomerID();
        //name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String Name = scanner.nextLine();
        System.out.println("Address:");
        String Address = scanner.nextLine();
        System.out.println("Phone: ");
        String Phone= scanner.nextLine();
        //phone in suitable length and must be number
        while(Phone.length() < 4 || Phone.length() > 12 || !Phone.matches("\\d+")){
            System.out.println("Invalid phone, please try again");
            Phone = scanner.nextLine();
        }
        String Type= "Regular";
        System.out.println("Username: ");
        Username= scanner.nextLine();
        while(Username.length() < 5 || Username.length() > 12) {
            System.out.println("Username must be between 5 and 12 characters, please try again");
            Username = scanner.nextLine();
        }
        System.out.println("Password: ");
        String Password= scanner.nextLine();
        //append new information to csv file
        File log = new File(("Customers.csv"));
        try{
            if (!log.exists()){
                System.out.println("no file found, need new file");
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(getID()).append(",").append(Name).append(",").append(Address).append(",").append(Phone)
                    .append(",").append(Type).append(",").append(Username).append(",").append(Password).append("\n");
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Get Information of register user
    public void RegisterInfo(){
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