package com.praveen.drools.example.model;

public class AccountableParty {
    public String id;
    public String type;

    public AccountableParty() {}

    public AccountableParty(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}


}
