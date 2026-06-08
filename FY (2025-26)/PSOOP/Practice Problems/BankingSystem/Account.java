public abstract class Account{
    protected String name;
    protected double balance;
    protected long accNo;

    Account(String name, double balance, long accNo){
      this.name = name;
      this.balance = balance;
      this.accNo = accNo;
    }

    public abstract void deposit(double amt) throws NegativeAmountException;
    public abstract void withdraw(double amt) throws NegativeAmountException, InsufficientAmountException;
    public abstract void display();
}
