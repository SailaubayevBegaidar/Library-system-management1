package OOP;
import java.sql.Connection;
import java.util.Scanner;

public class User{
    UserRepository db = new UserRepository();
    Connection conn = db.connect_to_db("Library", "postgres", "0000");
    Scanner scanner = new Scanner(System.in);

    public void Staff(){
        System.out.println("Choose option:");
        System.out.println("1) Books");
        System.out.println("2) Students");
        System.out.println("3) VIP_Students");
        int ab = scanner.nextInt();
        scanner.nextLine();
        switch (ab) {
            case 1:
                System.out.println("Choose a table of books:");
                System.out.println("1) The table (Books)");
                System.out.println("2) The table (Books_for_Students)");
                int tt = scanner.nextInt();
                if(tt == 1) {
                    System.out.println("Choose act: ");
                    System.out.println(" 1) insert books");
                    System.out.println(" 2) update books");
                    System.out.println(" 3) search books by title");
                    System.out.println(" 4) delete row by title");
                    System.out.println(" 5) read table (Books)");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    if (number == 1) {

                        System.out.println("Enter book details:");
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("ISBN: ");
                        String ISBN = scanner.nextLine();
                        System.out.print("Genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Year: ");
                        String year = scanner.nextLine();



                        db.addBook(conn, "books", title, ISBN, genre, author, year);
                    } else {
                        if (number == 2) {

                            System.out.println("Choose a row for updating");
                            int a = scanner.nextInt();
                            System.out.print("Title: ");
                            String new_title = scanner.nextLine();
                            System.out.print("ISBN: ");
                            String new_ISBN = scanner.nextLine();
                            System.out.print("Genre: ");
                            String new_genre = scanner.nextLine();
                            System.out.print("Author: ");
                            String new_author = scanner.nextLine();
                            System.out.print("Year: ");
                            String new_year = scanner.nextLine();

                            db.updateBook(conn, "books", a, new_title, new_ISBN, new_genre, new_author, new_year);
                        } else {
                            if (number == 3) {

                                System.out.println("write a title:");
                                String tItle = scanner.next();
                                db.search_by_title(conn, "books", tItle);
                            } else {
                                if (number == 4) {

                                    System.out.println("Write a title for deleting a row:");
                                    String tiTle = scanner.next();
                                    db.delete_row_by_name(conn, "books", "tiTle");
                                } else {
                                    if (number == 5) {
                                        db.read_data(conn, "Books");
                                    }
                                }
                            }
                        }
                    }
                }else{
                    if(tt==2){
                        System.out.println("Choose act: ");
                        System.out.println(" 1) insert books");
                        System.out.println(" 2) update books");
                        System.out.println(" 3) search books by title");
                        System.out.println(" 4) delete row by title");
                        System.out.println(" 5) read table (Books_for_Students)");
                        int number = scanner.nextInt();
                        scanner.nextLine();
                        if (number == 1) {

                            System.out.println("Enter book details:");
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            System.out.print("ISBN: ");
                            String ISBN = scanner.nextLine();
                            System.out.print("Genre: ");
                            String genre = scanner.nextLine();
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            System.out.print("Year: ");
                            String year = scanner.nextLine();



                            db.addBook(conn, "books", title, ISBN, genre, author, year);
                            db.addBook(conn, "Books_for_Students", title, ISBN, genre, author, year);
                        } else {
                            if (number == 2) {

                                System.out.println("Choose a row for updating");
                                int a = scanner.nextInt();
                                System.out.print("Title: ");
                                String new_title = scanner.nextLine();
                                System.out.print("ISBN: ");
                                String new_ISBN = scanner.nextLine();
                                System.out.print("Genre: ");
                                String new_genre = scanner.nextLine();
                                System.out.print("Author: ");
                                String new_author = scanner.nextLine();
                                System.out.print("Year: ");
                                String new_year = scanner.nextLine();

                                db.updateBook(conn, "Books_for_Students", a, new_title, new_ISBN, new_genre, new_author, new_year);
                            } else {
                                if (number == 3) {

                                    System.out.println("write a title:");
                                    String tItle = scanner.next();
                                    db.search_by_title(conn, "Books_for_Students", tItle);
                                } else {
                                    if (number == 4) {

                                        System.out.println("Write a title for deleting a row:");
                                        String tiTle = scanner.next();
                                        db.delete_row_by_name(conn, "Books_for_Students", "tiTle");
                                    } else {
                                        if (number == 5) {
                                            db.read_data(conn, "Books_for_Students");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Choose act:");
                System.out.println("1) Read table (Students):");
                System.out.println("2) Search a student");
                System.out.println("3) Add a student");
                System.out.println("4) Delete a student");
                int bb = scanner.nextInt();
                if (bb == 1) {
                    db.read_data(conn, "Students");
                } else {
                    if (bb == 2) {
                        System.out.println(" Write name:");
                        String name = scanner.nextLine();
                        db.search_by_name(conn, "Students", name);
                    } else {
                        if (bb == 3) {
                            System.out.println("Name:");
                            String name = scanner.nextLine();
                            System.out.println("Address:");
                            String address = scanner.nextLine();
                            db.insertRow(conn, "Students", name, address);
                        } else {
                            if (bb == 4) {
                                System.out.println("Name");
                                String name = scanner.nextLine();
                                db.delete_row_by_name(conn, "Students", name);
                            }
                        }
                    }
                }
                break;
            case 3:
                System.out.println("Choose act:");
                System.out.println("1) Read table (VIP_Students):");
                System.out.println("2) Search a student");
                System.out.println("3) Add a student");
                System.out.println("4) Delete a student");
                int bbb = scanner.nextInt();
                if (bbb == 1) {
                    db.read_data(conn, "VIP_Students");
                } else {
                    if (bbb == 2) {
                        System.out.println(" Write name:");
                        String name = scanner.nextLine();
                        db.search_by_name(conn, "VIP_Students", name);
                    } else {
                        if (bbb == 3) {
                            System.out.println("Name:");
                            String name = scanner.nextLine();
                            System.out.println("Address:");
                            String address = scanner.nextLine();
                            db.insertRow(conn, "VIP_Students", name, address);
                        } else {
                            if (bbb == 4) {
                                System.out.println("Name");
                                String name = scanner.nextLine();
                                db.delete_row_by_name(conn, "VIP_Students", name);
                            }
                        }
                    }
                }
                break;



        }
    }



    public void Students(){
        System.out.println("Choose option:");
        System.out.println("1) Read table (Books for Students)");
        System.out.println("2) Borrow a book");
        System.out.println("3) Return a book");
        int kk = scanner.nextInt();
        switch (kk){
            case 1:
                db.read_data_books(conn,"books_for_students");
                break;
            case 2:
                System.out.println("Write all characteristics of book that you want to borrow:");
                System.out.println("Write a title:");
                String title = scanner.nextLine();

                System.out.println("ISBN: ");
                String ISBN = scanner.nextLine();
                System.out.print("Genre: ");
                String genre = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Year: ");
                String year = scanner.nextLine();

                db.delete_row_by_title(conn,"Books_for_Students",title);
                db.addBook(conn,"Borrowed_Books",title,ISBN,genre,author,year);
                break;
            case 3:
                System.out.println("Write all characteristics of book that you want to return:");
                System.out.println("Write a title:");
                String title1 = scanner.nextLine();

                System.out.print("ISBN: ");
                String ISBN1 = scanner.nextLine();
                System.out.print("Genre: ");
                String genre1 = scanner.nextLine();
                System.out.print("Author: ");
                String author1 = scanner.nextLine();
                System.out.print("Year: ");
                String year1 = scanner.nextLine();

                db.delete_row_by_title(conn,"Borrowed_Books",title1);
                db.addBook(conn,"Books_for_Students",title1,ISBN1,genre1,author1,year1);
                break;

        }
    }
    public void VIP_Students(){
        System.out.println("Choose option:");
        System.out.println("1) Read table (Books)");
        System.out.println("2) Borrow a book");
        System.out.println("3) Return a book");
        int kk = scanner.nextInt();
        switch (kk){
            case 1:
                db.read_data_books(conn,"books");
                break;
            case 2:
                System.out.println("Write all characteristics of book that you want to borrow:");
                System.out.println("Write a title:");
                String title = scanner.nextLine();

                System.out.print("ISBN: ");
                String ISBN = scanner.nextLine();
                System.out.print("Genre: ");
                String genre = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Year: ");
                String year = scanner.nextLine();

                db.delete_row_by_title(conn,"Books",title);
                db.addBook(conn,"Borrowed_Books",title,ISBN,genre,author,year);
                break;
            case 3:
                System.out.println("Write all characteristics of book that you want to return:");
                System.out.println("Write a title:");
                String title1 = scanner.nextLine();

                System.out.print("ISBN: ");
                String ISBN1 = scanner.nextLine();
                System.out.print("Genre: ");
                String genre1 = scanner.nextLine();
                System.out.print("Author: ");
                String author1 = scanner.nextLine();
                System.out.print("Year: ");
                String year1 = scanner.nextLine();

                db.delete_row_by_title(conn,"Borrowed_Books",title1);
                db.addBook(conn,"Books",title1,ISBN1,genre1,author1,year1);
                break;

        }
    }











}

