package OOP;

import java.sql.Connection;
import java.util.Scanner;

public class UserController {

    User L = new User();

    Scanner sc = new Scanner(System.in);
    public void registration() {
        UserRepository db = new UserRepository();
        Connection conn = db.connect_to_db("Library", "postgres", "0000");

        System.out.println("Welcome to Library of Astana IT University!");
        System.out.println("Who are you?");
        System.out.println("1) Consumer");
        System.out.println("2) Staff");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.println("Choose:");
            System.out.println("1) Student");
            System.out.println("2) VIP Student");
            int choiCe = sc.nextInt();
            sc.nextLine();
            if (choiCe == 1) {
                System.out.println("Login or Registration");
                System.out.println("1) Login");
                System.out.println("2) Registration");
                int choIce = sc.nextInt();
                sc.nextLine();
                switch (choIce) {
                    case 1:
                        System.out.println("Write your name");
                        String name = sc.nextLine();
                        db.search_by_name(conn, "Students", name);
                        break;
                    case 2:
                        System.out.println(" Write your details for registration");
                        System.out.println("Write your name");
                        String Name = sc.nextLine();
                        System.out.println("Write your address");
                        String Address = sc.nextLine();
                        db.insertRow(conn, "Students", Name, Address);
                        System.out.println("Password: 1234");
                        break;

                }
            }
            if (choiCe == 2) {
                System.out.println("Login or Registration");
                System.out.println("1) Login");
                System.out.println("2) Registration");
                int choIce = sc.nextInt();
                sc.nextLine();
                switch (choIce) {
                    case 1:
                        System.out.println("Write your name");
                        String name = sc.nextLine();
                        db.search_by_name_for_VIP_Students(conn, "VIP_Students", name);
                        break;
                    case 2:
                        System.out.println(" Write your details for registration");
                        System.out.println("Write your name");
                        String Name = sc.nextLine();
                        System.out.println("Write your address");
                        String Address = sc.nextLine();
                        db.insertRow(conn, "VIP_Students", Name, Address);
                        System.out.println("Password: 1111");
                        break;

                }

            }

        }
        if (choice == 2) {
            System.out.println("Please login:");
            System.out.println("Write your name");
            String name = sc.nextLine();
            db.search_by_name_for_staff(conn, "Staff", name);
        }
    }
    public void Password(){
        System.out.println("Write password:");
        int pass = sc.nextInt();
        switch(pass) {
            case 1111:
                L.VIP_Students();
                break;
            case 1234:
                L.Students();
                break;
            case 4321:
                L.Staff();
                break;
        }
    }

}



