package service;

import dal.DebtDBContext;
import java.sql.Date;
import java.util.ArrayList;
import model.Debt;
import utils.Helper;

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

    public boolean createDebt(int userId, Debt debt) {
        DebtDBContext debtDb = new DebtDBContext();
        boolean result = debtDb.createDebt(userId, debt);
        return result;
    }

    public ArrayList<Debt> searchDebts(int debtorId, int debtId, String reason, Boolean roleDebt, int moneyFrom, int moneyTo, java.util.Date debtFrom,
            java.util.Date debtTo, java.util.Date recordFrom, java.util.Date recordTo) {

        DebtDBContext debtDB = new DebtDBContext();
        Date fromDebt = debtFrom == null ? null : Helper.toSQLDate(debtFrom);
        Date toDebt = debtTo == null ? null : Helper.toSQLDate(debtTo);
        Date fromRecord = recordFrom == null ? null : Helper.toSQLDate(recordFrom);
        Date toRecord = recordTo == null ? null : Helper.toSQLDate(recordTo);
        ArrayList<Debt> debts = debtDB.searchDebts(debtorId, debtId, reason, roleDebt, moneyFrom, moneyTo, fromDebt, toDebt, fromRecord, toRecord);

        return debts;

    }

    public ArrayList<Debt> paging(int debtorId, int debtId, String reason, Boolean roleDebt, int moneyFrom, int moneyTo, java.util.Date debtFrom, java.util.Date debtTo, java.util.Date recordFrom, java.util.Date recordTo, int pageIndex, int pageSize) {

        DebtDBContext debtDB = new DebtDBContext();
        Date fromDebt = debtFrom == null ? null : Helper.toSQLDate(debtFrom);
        Date toDebt = debtTo == null ? null : Helper.toSQLDate(debtTo);
        Date fromRecord = recordFrom == null ? null : Helper.toSQLDate(recordFrom);
        Date toRecord = recordTo == null ? null : Helper.toSQLDate(recordTo);
        ArrayList<Debt> debts = debtDB.paging(debtorId, debtId, reason, roleDebt, moneyFrom, moneyTo, fromDebt, toDebt, fromRecord, toRecord, pageIndex, pageSize);

        return debts;
    }

    public int getCount(int debtorId) {
        DebtDBContext debtDB = new DebtDBContext();
        return debtDB.getCount(debtorId);
    }
}
