package com.example.bankmanagement;
import java.util.*;

public class Party
{
    private final String account_id;
    public String name;
    private String password;
    private Integer balance;

    public Party(String account_id, String name, String password, Integer balance){
        this.account_id = account_id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public void addToBalance(Integer val){
        this.balance = this.balance + val;
    }
    public void removeFromBalance(Integer val){
        this.balance = this.balance - val;

    }
    public List<String> getDetails(){
        List<String> details = new ArrayList<>();
        details.add("Name: " + this.name);
        details.add("Account Id: " + this.account_id);
        details.add("Balance: " + this.balance);
        return details;
    }
    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return password;
    }
    public Integer getBalance(){
        return  balance;
    }
}
