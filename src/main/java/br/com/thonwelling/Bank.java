package br.com.thonwelling;

import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAcounts() {
        return accounts;
    }

    public void setAcounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
