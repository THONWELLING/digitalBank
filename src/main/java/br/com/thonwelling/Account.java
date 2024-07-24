package br.com.thonwelling;

public abstract class Account implements AccountInterface{
    private static final int STANDARD_AGENCY = 3149;
    private static int SEQUENTIAL = 9336179;

    protected int agency;
    protected int accountNumber;
    protected double balance;
    protected Client client;

    public Account(Client client) {
        this.client = client;
        this.agency = Account.STANDARD_AGENCY;
        this.accountNumber = SEQUENTIAL++;
    }

    @Override
    public void withdrawMoney(double withdrawValue) {
        balance -= withdrawValue;
    }

    @Override
    public void depositMoney(double depositValue) {
        balance += depositValue;
    }

    @Override
    public void transferMoney(double transferValue, AccountInterface targetAccount) {
        this.withdrawMoney(transferValue);
        targetAccount.depositMoney(transferValue);
    }

    public int getAgency() {
        return agency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void printCommonInfos(){
        System.out.println(String.format("Titular Da Conta: %s"   , this.client.getFirstName() + this.client.getLastName()));
        System.out.println(String.format("Agência         : %d"   , this.agency));
        System.out.println(String.format("Número Da Conta : %d"   , this.accountNumber));
        System.out.println(String.format("Saldo           : %.2f" , this.balance));
    }
}
