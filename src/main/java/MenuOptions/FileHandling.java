package MenuOptions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;

public class FileHandling extends MainMenu {
    private static String userAccountsFile;
    private static void setUpAccounts(){
        userAccountsFile = System.getProperty("user.dir")+"\\bookings.text"; // Intialises file if it doesn't exist
    }
    public static void addToAccountList(){
        setUpAccounts();
        String currentLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(userAccountsFile));
            while ((currentLine = read.readLine()) != null) {
                String[] bookDetails = currentLine.split(", "); //Each field is split by a comma and space
                Accounts currrentAccount = new Accounts(bookDetails[0], bookDetails[1], bookDetails[2], Integer.parseInt(bookDetails[3]), Integer.parseInt(bookDetails[4])); // user account record created
                userAccounts.add(currrentAccount);
                
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public static void addToAccountFile(){
        if (!userAccounts.isEmpty()){
            try{
                FileWriter writeToFile = new FileWriter(userAccountsFile, false);
                PrintWriter printToFile = new PrintWriter(writeToFile);
                for (int i = 0; i < userAccounts.size(); i++) {
                    printToFile.println(userAccounts.get(i).toFile());
                    }
                printToFile.close();
                writeToFile.close();
            }catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }else{
            try{
            PrintWriter writer = new PrintWriter(userAccountsFile);
            writer.print("");
            writer.close();
            }catch(Exception e){
                System.out.println("Error "+e);
            }
        }
    }
}
