package com.example.minorchatbot;

public class DataBaseModel {
    int account_no;
    double balance;
    String name,phone_no;

    DataBaseModel(int acc_no, double bal, String username,String phone,String mail,String pswd)
    {
        this.account_no = acc_no;
        this.balance = bal;
        this.name = username;
        this.phone_no = phone;
    }

    public String getName(){ return name; }
    public void setName(String username){ this.name = username; }

    public String getPhone_no(){ return phone_no; }
    public void setPhone_not(String number){ this.phone_no = number; }

    public int getAccountNo(){ return account_no; }
    public void setAccount_no(int account_no){ this.account_no = account_no; }

    public double getBalance(){ return balance; }
    public void setBalance(int bal){ this.balance = bal; }

}
