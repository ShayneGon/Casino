package MenuOptions;
import GamesLogic.BlackJack;
import java.util.Scanner;
import java.util.ArrayList;

public class MainMenu {
    public static String red = "\033[31m";
    public static String colourReset = "\033[0m";
    public static String green = "\033[32m";
    private static Scanner input = new Scanner(System.in);
    protected static ArrayList<Accounts> userAccounts = new ArrayList<>();
    protected static Accounts loginAccount;
    
    public static void main(String[] args) {
        FileHandling.addToAccountList();
        System.out.println("Hello, welcome to my Casino. What Would you like to do?");
        System.out.println("You will need an account to play, if you don't have one you can register one.");
        while (true){
            try{
                System.out.println("1 - Set up an account");
                System.out.println("2 - Login to your account");
                System.out.println("Enter anything else to quit appliation");
                int userChoice = input.nextInt();
                input.nextLine();

                switch (userChoice){
                    case 1:
                        setupAccount();
                        break;
                    case 2:
                        login();
                        if (loginAccount != null){
                            userAccount.userOptions();
                            if (loginAccount != null) {
                                userAccounts.add(loginAccount);
                            }
                        }
                        break;
                    default:
                        System.out.println("Goodbye");
                        FileHandling.addToAccountFile();
                        System.exit(0);
                }
            }catch(Exception e){
                System.out.println("Goodbye");
                FileHandling.addToAccountFile();
                System.exit(0);
            }
        }
    }
    public static void setupAccount(){
        try{
            System.out.println("Enter your name:");
            String name = input.nextLine();
            System.out.println("Enter your email address");
            String emailAddress = input.nextLine();
            System.out.println("Confirm your Email Address");
            String confirmEmail = input.nextLine();
            while (!emailAddress.equals(confirmEmail)){
                System.out.println("Emails didn't match, please enter matching passwords");
                System.out.println("Enter your email address");
                emailAddress = input.nextLine();
                System.out.println("Re-enter your email address");
                confirmEmail = input.nextLine();
            }
            if (checkIfAccountExists(emailAddress)) {
                System.out.println("User account already exists, you cannot have two accounts, please login");
            }else{
                System.out.println("Create your password");
                String password = input.nextLine();
                System.out.println("Re-enter your password");
                String confirmPassword = input.nextLine();

                while (!password.equals(confirmPassword)){
                    System.out.println("Passowrds didn't match, please enter matching passwords");
                    System.out.println("Create your password");
                    password = input.nextLine();
                    System.out.println("Re-enter your password");
                    confirmPassword = input.nextLine();
                }
                Accounts account = new Accounts(name, emailAddress, password, 0, 0);
                userAccounts.add(account);
                System.out.println("Account succsefully created: " +account.toString());
            }
        }catch(Exception e){
            System.out.println("Error: " +e+ ", please try again");
        }
    }
    public static boolean checkIfAccountExists(String emailAddress){
        for (int i = 0; i < userAccounts.size(); i++) {
            if (emailAddress.equals(userAccounts.get(i).getEmailAddress())) {
                return true;
            }
        }return false;
    }
    public static int checkAccountDetails(String emailAddress, String password){
        for (int i = 0; i < userAccounts.size(); i++) {
            if (emailAddress.equals(userAccounts.get(i).getEmailAddress()) && password.equals(userAccounts.get(i).getPassword())) {
                return i;
            }
        }return -1;
    }
    public static void login(){
        int tries = 3;
        int index;
        String emailAddress;
        String password;
        boolean valid = false;
        while (tries > 0){
            System.out.println("Enter your email address");
            emailAddress = input.nextLine();
            System.out.println("Enter your password");
            password = input.nextLine();
            index = checkAccountDetails(emailAddress, password);
            if (index == -1){
                System.out.println("Incorrect email and/or password, please try again");
                tries--;
                System.out.println("You have " +tries+ " attempts");
            }else{
                valid = true;
                tries = 0;
            }if (valid){
                loginAccount = userAccounts.get(index);
                userAccounts.remove(index);
                System.out.println("You are logged in.");
                System.out.println("Welcome " +loginAccount.getName());
            }else{
                System.out.println("You are out off attempts, redirecting you back to the main menu.");
            }
        }
    }
}
