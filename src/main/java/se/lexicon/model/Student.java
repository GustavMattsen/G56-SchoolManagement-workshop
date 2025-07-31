package se.lexicon.model;

public class Student {
    //Fields
    private final int id;
    private final String name;
    private final String email;
    private final String address;

    //Constructor
    public Student(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

}
