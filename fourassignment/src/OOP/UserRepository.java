package OOP;

import java.sql.*;

public class UserRepository {


    public Connection connect_to_db(String dbname, String user, String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if (conn!=null){
                System.out.println("Connection Established");

            }
            else{
                System.out.println("Connection failed");
            }
        }catch( Exception e){
            System.out.println(e);
        }
        return conn;
    }
    public void createTable_user(Connection conn, String table_name){
        Statement statement;
        try{
            String query = "create table "+table_name+"(empid SERIAL,name varchar(200), address varchar(200), primary key(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void insertRow(Connection conn, String table_name, String name, String address) {
        try {
            String insertRowQuery = "INSERT INTO " + table_name + " (name, address) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertRowQuery)) {
                pstmt.setString(1, name);
                pstmt.setString(2, address);

                pstmt.executeUpdate();

                System.out.println("Row Inserted");

            } catch (SQLException e) {
                System.out.println("Error inserting row: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error inserting row: " + e.getMessage());
        }
    }
    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = String.format("select * from %s",table_name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address")+" ");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void update_name ( Connection conn, String table_name, /*String old_name,*/ int empid, String new_name){
        Statement statement;
        try{
            String query = String.format("update %s set name ='%s' where empid ='%s'",table_name, new_name,empid);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void search_by_name(Connection conn, String table_name, String name){
        Statement statement;
        ResultSet rs;
        try{
            String query = String.format("select * from %s where name = '%s'",table_name,name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            if(rs.next()){
                System.out.println(" Login succeed\n Password: 1234");
            }else{
                System.out.println("Login failed");

            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void search_by_name_for_VIP_Students(Connection conn, String table_name, String name){
        Statement statement;
        ResultSet rs;
        try{
            String query = String.format("select * from %s where name = '%s'",table_name,name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            if(rs.next()){
                System.out.println(" Login succeed\n Password: 1111");
            }else{
                System.out.println("Login failed");

            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void search_by_name_for_staff(Connection conn, String table_name, String name){
        Statement statement;
        ResultSet rs;
        try{
            String query = String.format("select * from %s where name = '%s'",table_name,name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            if(rs.next()){
                System.out.println(" Login succeed\n Password: 4321");
            }else{
                System.out.println("Login failed");

            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void delete_row_by_name_user(Connection conn, String table_name, String name){
        Statement statement;
        try{
            String query = String.format("delete from %s where name = '%s'",table_name,name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void delete_row_by_name(Connection conn, String table_name, String name){
        Statement statement;
        try{
            String query = String.format("delete from %s where name = %s",table_name,name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void delete_table(Connection conn, String table_name){
        Statement stament;
        try{
            String query = String.format("drop table %s",table_name);
            stament=conn.createStatement();
            stament.executeUpdate(query);
            System.out.println("table Deleted");
        }catch( Exception e){
            System.out.println(e);
        }
    }

    public void createTable(Connection conn){
        Statement statement;
        try{
            String query = "create table Books_for_Students (empid SERIAL, title varchar(200), ISBN varchar(200),  genre varchar(200), author varchar(200), year varchar(200), primary key(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");

        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public void addBook(Connection conn, String table_name, String title, String ISBN, String genre, String author, String year) {
        try {
            String insertBookQuery = "INSERT INTO " + table_name + " (title, ISBN, genre, author, year) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertBookQuery)) {
                pstmt.setString(1, title);
                pstmt.setString(2, ISBN);
                pstmt.setString(3, genre);
                pstmt.setString(4, author);
                pstmt.setString(5, year);


                pstmt.executeUpdate();

                System.out.println("Book added successfully.");
            } catch (SQLException e) {
                System.out.println("Error adding book: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }
    public void updateBook(Connection conn, String table_name, int empid, String new_title, String new_ISBN, String new_genre, String new_author, String new_year) {
        try {
            String updateBookQuery = String.format("UPDATE %s SET title=?, ISBN=?, genre=?, author=?, year=? WHERE empid=?", table_name);

            try (PreparedStatement pstmt = conn.prepareStatement(updateBookQuery)) {
                pstmt.setString(1, new_title);
                pstmt.setString(2, new_ISBN);
                pstmt.setString(3, new_genre);
                pstmt.setString(4, new_author);
                pstmt.setString(5, new_year);

                pstmt.setInt(7, empid);

                pstmt.executeUpdate();

                System.out.println("Book updated successfully.");
            } catch (SQLException e) {
                System.out.println("Error updating book: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }
    public void search_by_title(Connection conn, String table_name, String title) {
        try {
            String query = String.format("SELECT * FROM %s WHERE title = ?", table_name);

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, title);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.print(rs.getString("empid") + ' ');
                        System.out.print(rs.getString("title") + ' ');
                        System.out.print(rs.getString("isbn") + ' ');
                        System.out.print(rs.getString("genre") + ' ');
                        System.out.print(rs.getString("author") + ' ');
                        System.out.print(rs.getString("year") + ' ');

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete_row_by_title(Connection conn, String table_name, String title){
        try {
            String query = String.format("DELETE FROM %s WHERE title = ?", table_name);

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, title);
                pstmt.executeUpdate();
                System.out.println("Data Deleted");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void read_data_books(Connection conn, String table_name) {
        try {
            String query = String.format("SELECT * FROM %s", table_name);

            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.print(rs.getString("empid") + ' ');
                    System.out.print(rs.getString("title") + ' ');
                    System.out.print(rs.getString("isbn") + ' ');
                    System.out.print(rs.getString("genre") + ' ');
                    System.out.print(rs.getString("author") + ' ');
                    System.out.print(rs.getString("year") + ' ');

                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }




}

