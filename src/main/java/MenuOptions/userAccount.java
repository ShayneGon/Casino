package MenuOptions;
import java.util.Scanner;

public class userAccount extends MainMenu{
    private static Scanner input = new Scanner(System.in);
    public static void userOptions(){
        boolean repeat = true;
        while (repeat){
            try{
                System.out.println("Hi " +loginAccount.getName()+ ", what would you like to do?");
                System.out.println("1 - Play a game");
                System.out.println("2 - View account details");
                System.out.println("3 - Add to your Casino Wallet");
                System.out.println("4 - Cash out your Bling  " +green+ "When the Fun Stops, Stop!"+colourReset);
                System.out.println("5 - Edit account details");
                System.out.println("6 - Delete your account");
                System.out.println("0 - Sign out");
                int userChoice = input.nextInt();
                input.nextLine();
                switch (userChoice){
                    case 1:
                        Games.gameOptions();
                        break;
                    case 2: 
                        System.out.println(loginAccount.toString());
                        break;
                    case 3:
                        loseMoney();
                        break;
                    case 4:
                        loseBling();
                        break;
                    case 5:
                        editAccountDetails();
                        break;
                    case 6:
                        repeat = deleteAccount();
                        break;
                    case 0:
                        repeat = false;
                        System.out.println("Goodbye " +loginAccount.getName());
                        break;
                    default:
                        System.out.println("Enter valid option");
                }
            }catch (Exception e){
                System.out.println(red+"An error occured, please enter a valid input");
                System.out.println("Error: "+e);
                input.nextLine();
            }
        }
    }
    public static boolean confirmPassword(){
        int tries = 5;
        while (tries>0){
            System.out.println("Confirm your password");
            String password = input.nextLine();
            if (loginAccount.getPassword().equals(password)){
                tries = 0;
                return true;
            }else{
                System.out.println(red+"Incorrect password, you have "+tries+" attempts"+colourReset);
                tries--;
            }
        }return false;
    }
    
    public static int[] exchangeCurrency(){
        int[] currency = new int[2];
        System.out.println("You currently have " +loginAccount.getCasinoBling()+ " Bling");
        System.out.println("£5 for 1 Bling");
        System.out.println("15 for 4 Bling");
        System.out.println("£30 for 10 Bling"+red+" MOST POPULAR!"+colourReset);
        System.out.println("£100 for for 40 Bling"+red+" BEST VALUE!"+colourReset);
        System.out.println("Enter the amount of Bling you want");
        currency[1] = input.nextInt();
        input.nextLine();
        int bling = currency[1];
        currency[0] = 0;
        while (bling != 0){
            if (bling>=40){
                currency[0] += 100;
                bling -= 40;
            }else if (currency[1]>=10){
                currency[0] += 30;
                bling -= 10;
            }else if (currency[1]>=4){
                currency[0] += 15;
                bling -= 4;
            }else if (currency[1]>=1){
                currency[0] += 5;
                bling -= 1;
            }
        }System.out.println("Your total is £"+currency[0]+" for "+currency[1]+" Bling");
        return currency;
    }
    public static void loseMoney(){
        try{
            System.out.println("How much Bling would you like to buy?");
            int[] currency = exchangeCurrency();
            if (confirmPassword()) {
                System.out.println(green+"PURCHASE SUCCESSFUL"+colourReset);
                loginAccount.setCasinoBling((loginAccount.getCasinoBling()+currency[1]));
                System.out.println("You now have " +loginAccount.getCasinoBling()+ " Bling");
            }else System.out.println(red+"Purchase cancelled, you will be redirected"+colourReset);
        }catch(Exception e){
            System.out.println(red+"Error has occured - please enter a valid input");
            System.out.println("Error: "+e+colourReset);
            input.nextLine();
        }
    }
    public static void loseBling(){
        try{
            System.out.println("How much Bling would you like to transfer out?");
            int[] currency = exchangeCurrency();
            if (confirmPassword()) {
                System.out.println(green+"TRANSFER COMPLETE"+colourReset);
                loginAccount.setCasinoBling((loginAccount.getCasinoBling()-currency[1]));
                System.out.println("You now have " +loginAccount.getCasinoBling()+ " Bling");
            }else System.out.println(red+"Transfer will be cancelled, you will be redirected"+colourReset);
        }catch(Exception e){
            System.out.println(red+"Error has occured - please enter a valid input");
            System.out.println("Error: "+e+colourReset);
            input.nextLine();
        }
    }
    public static void editAccountDetails(){
        try{
            System.out.println("What detatils would you like to change?");
            System.out.println("1 - Account name");
            System.out.println("2 - Account email address");
            System.out.println("3 - Account password");
            int optionChoice = input.nextInt();
            input.nextLine();
            switch (optionChoice){
                case 1:
                    System.out.println("Enter new name");
                    String name = input.nextLine();
                    loginAccount.setName(name);
                    break;
                case 2:
                    System.out.println("Enter the new email address");
                    String emailAddress = input.nextLine();
                    if (MainMenu.checkIfAccountExists(emailAddress)) {
                        System.out.println("That email is already used - you cannot create two accounts "
                                + "with the same email address");
                    }else loginAccount.setEmailAddress(emailAddress);
                    break;
                case 3:
                    if (confirmPassword()){
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
                        }loginAccount.setPassword(password);
                    }else{
                        System.out.println("Unable to change password - you will be redirected");
                    }break; 
            }
        }catch (Exception e){
            System.out.println(red+"Error has occured, please enter a valid input");
            System.out.println("Error: "+e+colourReset);
            input.nextLine();
        }
    }
    public static boolean deleteAccount(){
        System.out.println(red+"WARNING: THIS IS PERMANANENT AND YOU WILL LOOSE ANY BLING"
                + " IN YOUR CASINO WALLET"+colourReset);
        System.out.println("Are you still sure you would like to proceed? Yes[1] or No[2]");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice){
            case 1:
                if (confirmPassword()){
                    loginAccount = null;
                    System.out.println("Account terminated!");
                    return false;
                }else{
                    System.out.println("Unable to authenticate you, cannot delete your account");
                    System.out.println("You'll be redirected");
                }
                break;
            case 2:
                System.out.println("Good choice");
                break;
        }return true;
    }
}
