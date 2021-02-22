package MenuOptions;

public class Accounts {
    private String name;
    private String emailAddress;
    private String password;
    private int CasinoBling;
    private long CasinoPoints;

    public Accounts(String name, String emailAddress, String password, int CasinoBling, long CasinoPoints) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.CasinoBling = CasinoBling;
        this.CasinoPoints = CasinoPoints;
    }

    public Accounts(String name, String emailAddress, String password) {
        this(name, emailAddress, password, 0,0);
    }
    
    public String toFile(){
        return name +", " + emailAddress +", " + password +", " + CasinoBling +", " + CasinoPoints;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCasinoBling() {
        return CasinoBling;
    }
    
    public void setCasinoBling(int CasinoBling) {
        this.CasinoBling = CasinoBling;
    }

    public long getCasinoPoints() {
        return CasinoPoints;
    }

    public void setCasinoPoints(long CasinoPoints) {
        this.CasinoPoints = CasinoPoints;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Email Address = " + emailAddress + ", Casino Bling = " + CasinoBling + ", Casino Points = " + CasinoPoints;
    }
}
