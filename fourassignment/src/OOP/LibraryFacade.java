package OOP;

public class LibraryFacade {
    private static LibraryFacade instance;
    private final UserController userController;
    private final Direction direction;
    private final UserRepository userRepository;

    public LibraryFacade() {
        this.userController = new UserController();
        this.direction = new Direction();
        this.userRepository = new UserRepository();
    }
    public static LibraryFacade getInstance() {
        if (instance == null) {
            instance = new LibraryFacade();
        }
        return instance;
    }

    // Пример высокоуровневого метода для регистрации пользователя
    public void registerUser() {
        userController.registration();
    }
    public void Dopassword(){
        userController.Password();
    }

    // Пример высокоуровневого метода для выполнения направления
    public void executeDirection() {
        direction.Direction1();
    }
}
