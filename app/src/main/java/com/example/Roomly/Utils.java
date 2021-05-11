package com.example.Roomly;

import java.util.ArrayList;

public class Utils {

    private static Utils instance = null;

    private static ArrayList<Bill> allBills;

    //todo change Arraylist type:
    private static ArrayList<Chore> allChores;
    private static ArrayList<Bill> allRoomates;

    private Utils(){
        if (null == allBills){
            allBills = new ArrayList<>();
            initBills();
        }

        if (null == allChores){
            allChores = new ArrayList<>();
            initChores();
        }
    }

    private void initChores() {
        allChores.add(new Chore( "Wash Dishes",  "08/05/21"));
        allChores.add(new Chore("Clean Room",  "15/05/21"));
        allChores.add(new Chore("Buy Groceries",  "20/05/21"));
    }

    private void initBills() {
        allBills.add(new Bill( "Rent",  "01/05/21", "200.5"));
        allBills.add(new Bill("Water",  "04/05/21", "200.5"));
        allBills.add(new Bill("Electricity",  "10/05/21", "200.5"));
        allBills.add(new Bill("Groceries",  "11/05/21", "200.5"));
        allBills.add(new Bill("Plumber",  "14/05/21", "200.5"));
    }

    public static Utils getInstance(){
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }



    public static ArrayList<Bill> getAllBills() {
        return allBills;
    }

    public static ArrayList<Chore> getAllChores() {
        return allChores;
    }

    public static ArrayList<Bill> getAllRoomates() {
        return allRoomates;
    }

    public Bill getBillById(int id){
        for (Bill bill: allBills){
            if (bill.getBillID() == id)
                return bill;
        }
        return null;
    }

    public Chore getChoreById(int id){
        for (Chore chore: allChores){
            if (chore.getChoreID() == id)
                return chore;
        }
        return null;
    }


}
