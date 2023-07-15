/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Debt;
import utils.Helper;

/**
 *
 * @author admin
 */
public class DebtDBContext extends DBContext {

    public ArrayList<Debt> getDebts(int debtorId) {
        ArrayList<Debt> debts = new ArrayList<>();
        try {
            String sql = "SELECT id, reason, role_debt, [money], debt_createdTime, createdAt\n"
                    + "FROM Debt WHERE debtor_id = ? AND isDeleted = 0";
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

    public boolean createDebt(int userId, Debt debt) {
        try {
            String sql = "INSERT INTO [dbo].[Debt]\n"
                    + "           ([reason]\n"
                    + "           ,[role_debt]\n"
                    + "           ,[money]\n"
                    + "           ,[debtor_id]\n"
                    + "           ,[debt_createdTime]\n"
                    + "           ,[createdBy]\n"
                    + "           ,[createdAt]\n"
                    + "           ,[isDeleted])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,GETDATE()\n"
                    + "           ,0)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, debt.getReason());
            stm.setBoolean(2, debt.isRoleDebt());
            stm.setInt(3, debt.getMoney());
            stm.setInt(4, debt.getDebtor().getDebtor_id());
            stm.setDate(5, Helper.toSQLDate(debt.getDebtCreatedTime()));
            stm.setInt(6, userId);
            int result = stm.executeUpdate();
            return result != 0;
        } catch (SQLException ex) {
            Logger.getLogger(DebtDBContext.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Debt> sortDebtList(int debtorID, String choice, String value) {
        try {
            ArrayList<Debt> debts = new ArrayList<>();
            String sql = "SELECT id, reason, role_debt, [money], debt_createdTime, createdAt\n"
                    + "FROM Debt WHERE debtor_id = ? AND isDeleted = 0 Order By ";
            if (choice.equals("reason")) {
                sql += "CONVERT(VARCHAR(MAX) ,reason) ";
            } else {
                sql += choice;
            }
            if (choice.equals("role_debt")) {
                if (value.equals("increase")) {
                    sql += " desc";
                } else {
                    sql += " asc";
                }
            } else {
                if (value.equals("increase")) {
                    sql += " asc";
                } else {
                    sql += " desc";
                }
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, debtorID);
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

    // debtId = -1 , reason = null or blank, from and to null (không truyền)
    public ArrayList<Debt> searchDebts(int debtorId, int debtId, String reason, Boolean roleDebt, int moneyFrom, int moneyTo, Date fromDebt,
            Date toDebt, Date fromRecord, Date toRecord) {
        ArrayList<Debt> debts = new ArrayList<>();
        try {
            String sql = "SELECT id, reason, role_debt, [money], debt_createdTime, createdAt\n"
                    + "FROM Debt WHERE debtor_id = ? AND isDeleted = 0";
            List<Object> params = new ArrayList<>();
            params.add(debtorId);

            if (debtId != -1) {
                sql += " AND id = ?";
                params.add(debtId);
            }

            if (reason != null && !reason.isEmpty()) {
                sql += " AND reason LIKE '%' + ? + '%' ";
                params.add(reason);
            }

            if (roleDebt != null) {
                sql += " AND role_debt = ?";
                params.add(roleDebt);
            }

            if (moneyFrom != -1) {
                sql += " AND money >= ?";
                params.add(moneyFrom);
            }

            if (moneyTo != -1) {
                sql += " AND money <= ?";
                params.add(moneyTo);
            }

            if (fromDebt != null) {
                sql += " AND debt_createdTime >= ?";
                params.add(fromDebt);
            }

            if (toDebt != null) {
                sql += " AND debt_createdTime <= ?";
                params.add(toDebt);
            }

            if (fromRecord != null) {
                sql += " AND createdAt >= ?";
                params.add(fromRecord);
            }

            if (toRecord != null) {
                sql += " AND createdAt <= ?";
                params.add(toRecord);
            }

            PreparedStatement stm = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                if (param instanceof Integer) {
                    stm.setInt(i + 1, (Integer) param);
                } else if (param instanceof String) {
                    stm.setString(i + 1, (String) param);
                } else if (param instanceof Boolean) {
                    stm.setBoolean(i + 1, (Boolean) param);
                } else if (param instanceof Date) {
                    stm.setDate(i + 1, (Date) param);
                }
            }

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

    // debtId = -1 , reason = null or blank, from and to null (không truyền)
    public ArrayList<Debt> paging(int debtorId, int debtId, String reason, Boolean roleDebt, int moneyFrom, int moneyTo, Date fromDebt,
            Date toDebt, Date fromRecord, Date toRecord, int pageIndex, int pageSize) {
        ArrayList<Debt> debts = new ArrayList<>();
        try {
            String sql = "SELECT id, reason, role_debt, [money], debt_createdTime, createdAt\n"
                    + " FROM (SELECT ROW_NUMBER() OVER (ORDER BY id ASC) AS rownum, id, reason, role_debt, [money], debt_createdTime, createdAt\n"
                    + " FROM Debt WHERE debtor_id = ? AND isDeleted = 0";
            List<Object> params = new ArrayList<>();
            params.add(debtorId);

            if (debtId != -1) {
                sql += " AND id = ?";
                params.add(debtId);
            }

            if (reason != null && !reason.isEmpty()) {
                sql += " AND reason LIKE '%' + ? + '%' ";
                params.add(reason);
            }

            if (roleDebt != null) {
                sql += " AND role_debt = ?";
                params.add(roleDebt);
            }

            if (moneyFrom != -1) {
                sql += " AND money >= ?";
                params.add(moneyFrom);
            }

            if (moneyTo != -1) {
                sql += " AND money <= ?";
                params.add(moneyTo);
            }

            if (fromDebt != null) {
                sql += " AND debt_createdTime >= ?";
                params.add(fromDebt);
            }

            if (toDebt != null) {
                sql += " AND debt_createdTime <= ?";
                params.add(toDebt);
            }

            if (fromRecord != null) {
                sql += " AND createdAt >= ?";
                params.add(fromRecord);
            }

            if (toRecord != null) {
                sql += " AND createdAt <= ?";
                params.add(toRecord);
            }

            sql += ") t\n"
                    + "WHERE rownum > (? - 1) * ? AND rownum <= ? * ?";

            params.add(pageIndex);
            params.add(pageSize);
            params.add(pageIndex);
            params.add(pageSize);

            PreparedStatement stm = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                if (param instanceof Integer) {
                    stm.setInt(i + 1, (Integer) param);
                } else if (param instanceof String) {
                    stm.setString(i + 1, (String) param);
                } else if (param instanceof Boolean) {
                    stm.setBoolean(i + 1, (Boolean) param);
                } else if (param instanceof Date) {
                    stm.setDate(i + 1, (Date) param);
                }
            }

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

    public int getCount(int debtorId) {
        PreparedStatement stm = null;
        try {
            String sql = "SELECT COUNT(*) as total FROM Debt WHERE debtor_id = ? AND isDeleted = 0";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, debtorId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DebtDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

}
