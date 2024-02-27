package OOP;



import java.sql.Connection;

public class UserRepositoryWrapper {
    private UserRepository userRepository;

    public UserRepositoryWrapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Connection connectToDB(String dbname, String user, String pass) {

        return userRepository.connect_to_db(dbname, user, pass);
    }


    public void createTableUser(Connection conn, String table_name) {
        userRepository.createTable_user(conn, table_name);
    }


}

