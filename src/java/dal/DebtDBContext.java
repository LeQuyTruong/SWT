/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Debt;

/**
 *
 * @author admin
 */
public class DebtDBContext extends DBContext {

    public ArrayList<Debt> getDebts(int debtorId) {
        ArrayList<Debt> debts = new ArrayList<>();
        try {
            String sql = "SELECT id, reason, role_debt, [money], debt_createdTime, createdAt\n"
                    + "FROM Debt WHERE debtor_id = ? AND isDeleted = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, debtorId);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Debt debt = new Debt();
                debt.setId(rs.getInt("id"));
                debt.setReason(rs.getString("reason"));
                debt.setRoleDebt(rs.getBoolean("role_debt"));
                debt.setMoney(rs.getInt("money"));
                debt.setDebtCreatedTime(rs.getDate("debt_createdTime"));
                debt.setCreatedAt(rs.getDate("createdAt"));
                debts.add(debt);
            }
            return debts;
        } catch (SQLException ex) {
            Logger.getLogger(DebtDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
