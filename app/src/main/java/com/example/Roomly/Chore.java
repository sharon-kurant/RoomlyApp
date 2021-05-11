package com.example.Roomly;

public class Chore {

    private String choreName;
    private String dueDate;
    private static int nextChoreID = 500;
    private final int choreID;

    public Chore(String choreName, String dueDate) {
        this.choreName = choreName;
        this.dueDate = dueDate;
        this.choreID = nextChoreID++;
    }



    public String getChoreName() {
        return choreName;
    }

    public void setChoreName(String choreName) {
        this.choreName = choreName;
    }


    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Chore{" +
                ", choreName='" + choreName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", choreName='" + choreID + '\'' +
                '}';
    }

    public int getChoreID() {
        return this.choreID;
    }
}
