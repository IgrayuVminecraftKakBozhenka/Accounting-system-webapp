package ru.sibadi.demowebapp.domain;

public class Payment {
    private final int id;
    private int salary;
    private int prize;
    private int personId;
    private String date;

    public Payment(int id, int salary, int prize, int personId, String date) {
        this.id = id;
        this.salary = salary;
        this.prize = prize;
        this.personId = personId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public int getPrize() {
        return prize;
    }

    public int getPersonId() {
        return personId;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getDate() { return date; }
}
