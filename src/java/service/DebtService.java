/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.DebtDBContext;
import java.util.ArrayList;
import model.Debt;

/**
 *
 * @author admin
 */
public class DebtService {

    public ArrayList<Debt> getDebts(int debtorId) {
        DebtDBContext debtDB = new DebtDBContext();
        ArrayList<Debt> debts = debtDB.getDebts(debtorId);
        return debts;
    }

}
