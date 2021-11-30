package com.example.bankmanagement;
import java.util.*;
import java.time.*;

public class Transaction {
    private final Party sender;
    private final LocalDate date;
    private final Party recipient;
    private final Integer amount;
    private final String type;


    public Transaction(Party initiator, LocalDate date, Party recipient, Integer amount, String type){
        this.sender = initiator;
        this.date = date;
        this.recipient = recipient;
        this.amount = amount;
        System.out.println("Transaction created..");
        this.type = type;
        this.updateAccount();
    }
    private void updateAccount(){
        if(type.equals("deposit")){
            sender.addToBalance(amount);
        }
        else if(type.equals("transfer")){
            sender.removeFromBalance(amount);
            recipient.addToBalance(amount);
        }
        else{
            System.out.println("Wrong type of transaction");
        }
    }
    public List<String>  getTransactionDetails() {
        List<String> details = new ArrayList<>();
        details.add("Type: " + this.type);
        details.add("Sender " + this.sender.getName());
        details.add("Receiver " + this.recipient.getName());
        details.add("Amount: " + this.amount);
        details.add("Date-> " + date.getYear()+ "-"+date.getMonthValue()+"-"+date.getDayOfMonth());
        return details;
    }

    public Party getSender() {
        return sender;
    }

    public Party getRecipient() {
        return recipient;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }
}
