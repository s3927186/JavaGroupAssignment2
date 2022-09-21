import Admin.*;
import Customer.*;
import Customer.Sorting.PriceSort;

import java.util.*;

public class Main {
    //Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            WelcomeScreen();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.println("Program Exited");
                case 1 -> runCusMenu();
                case 2 -> runAdminLogin();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }
    //Welcome Screen
    public static void WelcomeScreen(){
        System.out.println("""
                COSC2081 GROUP ASSIGNMENT
                STORE ORDER MANAGEMENT SYSTEM
                Instructor: Mr. Minh Vu
                Group: Group 22
                s3927186, Nguyen Tan Thinh
                s3940677, Vu Phat Dai
                
                Are you a Customer or Admin?
                1/Customer
                2/Admin
                0/Exit Program""");
    }
    //Customer side
    public static void CustomerMenu(){
        System.out.println("""
                Login or Register
                1/Login
                2/Register
                0/Back""");
    }

    public static void CustomerChoices(){
        System.out.println("""
                What do you want to do?
                1/View Products
                2/Sorting by Prices
                3/Search Category
                4/Create Order
                5/View Order
                6/View Profile
                0/Log out""");
    }

    public static void CusLogin() {
        ListAndDetails ListAndDetails = new ListAndDetails();
        PriceSort priceSort = new PriceSort();
        CategorySearch CategorySearch = new CategorySearch();
        Order Order = new Order();
        ViewOrder viewOrder = new ViewOrder();
        CustomerLogin CustomerLogin = new CustomerLogin();
        CustomerLogin.Login();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            CustomerChoices();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> ListAndDetails.ListsDetails();
                case 2 -> priceSort.printSort();
                case 3 -> CategorySearch.Category();
                case 4 -> Order.CreateOrder();
                case 5 -> viewOrder.runViewOrder();
                case 6 -> CustomerLogin.LoginInfo();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }

    public static void CusRegister() {
        ListAndDetails ListAndDetails = new ListAndDetails();
        PriceSort priceSort = new PriceSort();
        CategorySearch CategorySearch = new CategorySearch();
        Order Order = new Order();
        ViewOrder viewOrder = new ViewOrder();
        CustomerRegister CustomerRegister = new CustomerRegister();
        CustomerRegister.Register();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            CustomerChoices();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> ListAndDetails.ListsDetails();
                case 2 -> priceSort.printSort();
                case 3 -> CategorySearch.Category();
                case 4 -> Order.CreateOrder();
                case 5 -> viewOrder.runViewOrder();
                case 6 -> CustomerRegister.RegisterInfo();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }

    public static void runCusMenu(){
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            CustomerMenu();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> CusLogin();
                case 2 -> CusRegister();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }
    //Admin side
    public static void AdminMenu(){
        System.out.println("""
                1/View Products
                2/View Orders
                3/View Members
                4/Add Or Remove Product
                5/Update price
                6/get Customer's orders
                0/Log out""");
    }
    public static void AddOrRemove(){
        System.out.println("""
                1/Add Product
                2/Remove Product
                0/back
                """);
    }
    public static void runAddOrRemove(){
        RemoveProduct removeproduct = new RemoveProduct();
        AddProduct addproduct = new AddProduct();
        Scanner scanner =new Scanner(System.in);
        int input;
        do{
            AddOrRemove();
            input =scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> addproduct.addProduct();
                case 2 -> removeproduct.removeProduct();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }

    public static void runAdminLogin() {
        View view = new View();
        UpdatePrice updatePrice =new UpdatePrice();
        OrdersInformation showOrder = new OrdersInformation();
        AdminLogin AdminLogin = new AdminLogin();
        AdminLogin.Login();
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            AdminMenu();
            input = scanner.nextInt();
            switch (input) {
                case 0 -> System.out.print("");
                case 1 -> view.ViewItems();
                case 2 -> view.ViewOrders();
                case 3 -> view.ViewCustomers();
                case 4 -> runAddOrRemove();
                case 5 -> updatePrice.Update();
                case 6 -> showOrder.ShowOrder();
                default -> System.out.println("Invalid input");
            }
        }while (input != 0);
    }
}
