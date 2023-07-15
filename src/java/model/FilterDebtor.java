package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author choip
 */
public class FilterDebtor {
    private String idFrom;
    private String idTo;
    private String name;
    private String address;
    private String phone;
    private String  email;
    private String totalDeptFrom;
    private String totalDeptTo;
    private String createDateForm;
    private String createDateTo;
    private String updateDateFrom;
    private String updateDateTo;

    public FilterDebtor() {
    }

    public FilterDebtor(String idFrom, String idTo, String name, String address, String phone, String email, String totalDeptFrom, String totalDeptTo, String createDateForm, String createDateTo, String updateDateFrom, String updateDateTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.totalDeptFrom = totalDeptFrom;
        this.totalDeptTo = totalDeptTo;
        this.createDateForm = createDateForm;
        this.createDateTo = createDateTo;
        this.updateDateFrom = updateDateFrom;
        this.updateDateTo = updateDateTo;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTotalDeptFrom() {
        return totalDeptFrom;
    }

    public void setTotalDeptFrom(String totalDeptFrom) {
        this.totalDeptFrom = totalDeptFrom;
    }

    public String getTotalDeptTo() {
        return totalDeptTo;
    }

    public void setTotalDeptTo(String totalDeptTo) {
        this.totalDeptTo = totalDeptTo;
    }

    public String getCreateDateForm() {
        return createDateForm;
    }

    public void setCreateDateForm(String createDateForm) {
        this.createDateForm = createDateForm;
    }

    public String getCreateDateTo() {
        return createDateTo;
    }

    public void setCreateDateTo(String createDateTo) {
        this.createDateTo = createDateTo;
    }

    public String getUpdateDateFrom() {
        return updateDateFrom;
    }

    public void setUpdateDateFrom(String updateDateFrom) {
        this.updateDateFrom = updateDateFrom;
    }

    public String getUpdateDateTo() {
        return updateDateTo;
    }

    public void setUpdateDateTo(String updateDateTo) {
        this.updateDateTo = updateDateTo;
    }

    
}
