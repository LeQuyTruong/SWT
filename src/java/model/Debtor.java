/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author choip
 */
public class Debtor {

    private int debtor_id;
    private String debtor_name;
    private String address;
    private boolean gender;
    private String email;
    private String phone_number;
    private Date created_time;
    private Date updated_time;
    private int created_by;
    private double total_money;

    private ArrayList<Debt> debts = new ArrayList<>();

    public Debtor() {
    }

    public Debtor(int debtor_id, String debtor_name, String address, boolean gender, String email, String phone_number, Date created_time, Date updated_time, int created_by, double total_money) {
        this.debtor_id = debtor_id;
        this.debtor_name = debtor_name;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.created_time = created_time;
        this.updated_time = updated_time;
        this.created_by = created_by;
        this.total_money = total_money;
    }

    private int gen;

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public Debtor(String debtor_name, String address, int gender, String email, String phone_number) {
        this.debtor_name = debtor_name;
        this.address = address;
        this.gen = gender;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getDebtor_id() {
        return debtor_id;
    }

    public void setDebtor_id(int debtor_id) {
        this.debtor_id = debtor_id;
    }

    public String getDebtor_name() {
        return debtor_name;
    }

    public void setDebtor_name(String debtor_name) {
        this.debtor_name = debtor_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(Date updated_time) {
        this.updated_time = updated_time;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public ArrayList<Debt> getDebts() {
        return debts;
    }

    public void setDebts(ArrayList<Debt> debts) {
        this.debts = debts;
    }

}
