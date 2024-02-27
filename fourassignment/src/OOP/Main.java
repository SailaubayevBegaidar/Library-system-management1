package OOP;

public class Main {
    public static void main (String[] args){
        UserRepository userRepository = new UserRepository();
        UserRepositoryWrapper userRepositoryWrapper = new UserRepositoryWrapper(userRepository);
        LibraryFacade libraryFacade = LibraryFacade.getInstance();
        libraryFacade.registerUser();
        libraryFacade.Dopassword();
        libraryFacade.executeDirection();




        //db.createTable(conn);
        //db.insert_row(conn, "Staff", "Nursultan","Astana");
        //db.update_name(conn,"employee",2,"Alisher");
        //db.search_by_name(conn,"employee","Alisher");
        //db.delete_row_by_name(conn, "employee","Alisher");
        //db.delete_table(conn,"books");
        //db.read_data(conn,"clients");

    }
}
