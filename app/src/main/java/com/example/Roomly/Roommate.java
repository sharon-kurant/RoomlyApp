package com.example.Roomly;

public class Roommate {
    private int id;
    protected final String firstName;
    protected final String lastName;
    protected static String email;
    protected static String phone;
    protected static Gender gender;
    protected static String address;


    public Roommate(int id, String firstName,String lastName,String email,String phone, Gender gender, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public int getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPhone() {
        return phone;
    }

    public static Gender getGender() {
        return gender;
    }

    public static String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Roommate{" +
                "id='" + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
