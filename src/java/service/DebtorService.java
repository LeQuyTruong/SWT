/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.DebtorDBContext;
import model.Debtor;

/**
 *
 * @author admin
 */
public class DebtorService {

    public Debtor getDebtorById(int id) {
        DebtorDBContext debtorDB = new DebtorDBContext();
        Debtor debtor = debtorDB.getDebtorByID(id);
        return debtor;
    }
}
