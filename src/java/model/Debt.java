/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Debt {

    private int id;
    private String reason;
    private boolean roleDebt;
    private int money;
    private Date debtCreatedTime;
    private int createdBy;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private boolean isDeleted;

    private Debtor debtor;

    public Debt() {
    }

    public Debt(int id, String reason, boolean roleDebt, int money, Date debtCreatedTime, int createdBy, Date createdAt, Date updatedAt, Date deletedAt, boolean isDeleted) {
        this.id = id;
        this.reason = reason;
        this.roleDebt = roleDebt;
        this.money = money;
        this.debtCreatedTime = debtCreatedTime;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isRoleDebt() {
        return roleDebt;
    }

    public void setRoleDebt(boolean roleDebt) {
        this.roleDebt = roleDebt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getDebtCreatedTime() {
        return debtCreatedTime;
    }

    public void setDebtCreatedTime(Date debtCreatedTime) {
        this.debtCreatedTime = debtCreatedTime;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }

    @Override
    public String toString() {
        return "Debt{" + "id=" + id + ", reason=" + reason + ", roleDebt=" + roleDebt + ", money=" + money + ", debtCreatedTime=" + debtCreatedTime + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", isDeleted=" + isDeleted + ", debtor=" + debtor + '}';
    }

}
