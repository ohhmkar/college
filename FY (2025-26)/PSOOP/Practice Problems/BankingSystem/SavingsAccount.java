class SavingsAccount extends Account{
    double interestRate;
    double minBalance = 0.0;
    
    SavingsAccount(String name, double balance, long accountNo, double interestRate, double minBalance){
      super(name, balance, accountNo);
      this.interestRate = interestRate;
      this.minBalance = minBalance;
    }    

    @Override
    public void deposit(double amt) throws NegativeAmountException{
        if(!validDeposit(amt)){
          throw new NegativeAmountException("Deposit amount must be greater than zero.");
        }

        balance += amt;
        System.out.println("Transaction Successful. Rs."+amt+" deposited into Acc No."+accNo);
        System.out.println("Updated Balance: Rs."+balance);
    }

    boolean validDeposit(double amt){
            return amt > 0;
    }
    

    @Override
    public void withdraw(double amt) throws NegativeAmountException, InsufficientAmountException{
      if(amt <= 0){
          throw new NegativeAmountException("Withdrawal amount must be greater than zero.");
      }

      if(!validWithdrawl(amt)){
          throw new InsufficientAmountException("Balance cannot go below the minimum balance of Rs."+minBalance+".");
      }

      balance -= amt;
      System.out.println("Transaction Successful. Rs."+amt+" withdrawn from Acc No."+accNo);
      System.out.println("Updated Balance: Rs."+balance);
    }
    
    public void transfer(SavingsAccount sa1, double transferAmount) throws NegativeAmountException, InsufficientAmountException{
        if(transferAmount <= 0){
            throw new NegativeAmountException("Transfer amount must be greater than zero.");
        }

        if(!validTransfer(transferAmount)){
            throw new InsufficientAmountException("Insufficient balance to transfer while maintaining minimum balance of Rs."+minBalance+".");
        }

        balance -= transferAmount;
        sa1.balance += transferAmount;
        System.out.println("Transaction Successful. Rs."+transferAmount+" withdrawn from Acc No."+accNo+" and credited to Acc No."+sa1.accNo);
        System.out.println("Updated Balance: Rs."+balance);
        System.out.println("Recipient Updated Balance: Rs."+sa1.balance);
    }
    
    boolean validTransfer(double transferAmount){
                return (balance - transferAmount) >= minBalance && (balance - transferAmount) >= 0;
    }
    
    boolean validWithdrawl(double amt){
            return ((balance - amt) >= minBalance) && ((balance - amt) >= 0);
    }
    
    void addInterest(){
        try{
            if(interestRate == 0){
                throw new ArithmeticException("Interest rate cannot be zero.");
            }
            double interest = (balance * interestRate)/100.0;
            balance += interest;
            System.out.println("Interest added successfully. Updated Balance: Rs."+balance);
        }
        catch(ArithmeticException ex){
            System.out.println("Transaction Failed! Reason: "+ex.getMessage());
        }
    }
    
    @Override
    public void display(){
       System.out.println("=== ABC BANK ===");
       System.out.println("Account Holder: "+name);
       System.out.println("Account Number: "+accNo);
       System.out.println("Balance: Rs."+balance);
       System.out.println("Interest Rate: "+interestRate+"%");
       System.out.println("Minimum Balance: Rs."+minBalance);
       System.out.println();
    }
    
}
