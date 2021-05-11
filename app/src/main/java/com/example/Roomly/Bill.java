package com.example.Roomly;

public class Bill {
    private String billName;
    private String dueDate;
    private String amount;
    private static int nextBiilID = 100;
    private final int billID;

    public Bill(String billName, String dueDate, String amount) {
        this.billName = billName;
        this.dueDate = dueDate;
        this.amount = amount;
        this.billID = nextBiilID++;
    }

    public int getBillID() {
        return billID;
    }



    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }


    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                ", billName='" + billName + '\'' +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                '}';
    }
}
