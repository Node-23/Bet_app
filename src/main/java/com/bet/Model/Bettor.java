package com.bet.Model;

public class Bettor {

    private String cpf;
    private String name;
    private String mainPhoneNumber;
    private String secondPhoneNumber;

    public Bettor(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public Bettor(String cpf, String name, String mainPhoneNumber) {
        this.cpf = cpf;
        this.name = name;
        this.mainPhoneNumber = mainPhoneNumber;
    }

    public Bettor(String cpf, String name, String mainPhoneNumber, String secondPhoneNumber) {
        this.cpf = cpf;
        this.name = name;
        this.mainPhoneNumber = mainPhoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainPhoneNumber() {
        return this.mainPhoneNumber;
    }

    public void setMainPhoneNumber(String mainPhoneNumber) {
        this.mainPhoneNumber = mainPhoneNumber;
    }

    public String getSecondPhoneNumber() {
        return this.secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    @Override
    public String toString() {
        return "CPF: " + getCpf() + "\n" + "Name: " + getName() + "\n" + "Main Phone Number: " + getMainPhoneNumber()
                + "\n" + "Second Phone Number: " + getSecondPhoneNumber();
    }

}
