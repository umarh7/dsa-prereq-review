
public class BankAccount {
    private String owner;
    private double Balance;
    static int totalAccounts = 0;;
    public BankAccount(String n){
        owner = n;
        Balance = 100;
        totalAccounts++;
    }

    public String deposit(int n){
        if(n>=0){
            Balance += n;
            return "done";
        }
        return "deposit cannot be negative";
    }

    public boolean withdraw(double a){
        if(a<=Balance && a>0){
            Balance-=a;
            return true;
        }
        return false;
    }

    public String ownerGet(){
        return this.owner;
    }

    public double balanceGet(){
        return this.Balance;
    }

    public static void main(String[] args){
        System.out.println(BankAccount.totalAccounts);
        BankAccount b1 = new BankAccount("umr");
        BankAccount b2 = new BankAccount("vic");

        System.out.println(b1.ownerGet());
        System.out.println(BankAccount.totalAccounts);
        
    }

    
    
}
