package OOP;
import java.util.Scanner;
public class Direction {
    UserController dd = new UserController();
    Scanner sc = new Scanner(System.in);
    public void Direction1(){
        System.out.println(" ");
        System.out.println("Where do you want to return?");
        System.out.println("1) Registration");
        System.out.println("2) Password");
        System.out.println("3) Finish program");
        int a = sc.nextInt();
        switch(a){
            case 1:
                dd.registration();
                break;
            case 2:
                dd.Password();
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
        }
    }
}
