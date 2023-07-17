/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.FilterDebtor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Debtor;

/**
 *
 * @author choip
 */
public class DebtorDBContext extends DBContext {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public List<Debtor> findById(String username, int page, int size, FilterDebtor filterDebtor, String column, String sort) throws SQLException {
        List<Debtor> listDebtor = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String FINDBYID = "SELECT * FROM Debtor d JOIN [User] u ON u.[id] = d.createdBy WHERE u.[email] = ? ";

        if (!filterDebtor.getIdFrom().isEmpty()) {
            FINDBYID += "and d.id >= '" + filterDebtor.getIdFrom() + "'";
        }
        if (!filterDebtor.getIdTo().isEmpty()) {
            FINDBYID += "and d.id <= '" + filterDebtor.getIdTo() + "'";
        }
        if (!filterDebtor.getName().isEmpty()) {
            FINDBYID += "and d.name like '%" + filterDebtor.getName() + "%'";
        }
        if (!filterDebtor.getAddress().isEmpty()) {
            FINDBYID += "and d.address like '%" + filterDebtor.getAddress() + "%'";
        }
        if (!filterDebtor.getPhone().isEmpty()) {
            FINDBYID += "and d.phone_number like '%" + filterDebtor.getPhone() + "%'";
        }
        if (!filterDebtor.getEmail().isEmpty()) {
            FINDBYID += "and d.email like '%" + filterDebtor.getEmail() + "%'";
        }
        if (!filterDebtor.getTotalDeptFrom().isEmpty()) {
            FINDBYID += "and d.total_money >= '" + filterDebtor.getTotalDeptFrom() + "'";
        }
        if (!filterDebtor.getTotalDeptTo().isEmpty()) {
            FINDBYID += "and d.total_money <= '" + filterDebtor.getTotalDeptTo() + "'";
        }

        if (!filterDebtor.getCreateDateForm().isEmpty()) {
            FINDBYID += "and d.createdAt >= '" + filterDebtor.getCreateDateForm() + "'";
        }

        if (!filterDebtor.getCreateDateTo().isEmpty()) {
            FINDBYID += "and d.createdAt <= '" + filterDebtor.getCreateDateTo() + "'";
        }

        if (!filterDebtor.getUpdateDateFrom().isEmpty()) {
            FINDBYID += "and d.updatedAt >= '" + filterDebtor.getUpdateDateFrom() + "'";
        }

        if (!filterDebtor.getUpdateDateTo().isEmpty()) {
            FINDBYID += "and d.updatedAt <= '" + filterDebtor.getUpdateDateTo() + "'";
        }

        try {
            con = connection;
            if (con != null) {
                if (!column.isEmpty()) {
                    FINDBYID += " ORDER BY (d." + column + ")" + sort;
                } else {
                    FINDBYID += "ORDER BY (SELECT NULL)";
                }
                FINDBYID += " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                ps = con.prepareStatement(FINDBYID);
                ps.setString(1, username);
                ps.setInt(2, page);
                ps.setInt(3, size);

                rs = ps.executeQuery();
                while (rs.next()) {
                    int debtor_id = rs.getInt(1);
                    String debtor_name = rs.getString(2);
                    String address = rs.getString(3);
                    boolean gender = rs.getBoolean(4);
                    String email = rs.getString(5);
                    String phone_number = rs.getString(6);
                    int created_by = rs.getInt(7);
                    Date created_time = rs.getTimestamp(8);
                    Date updated_time = rs.getTimestamp(9);
                    double total_money = rs.getDouble(12);
                    listDebtor.add(new Debtor(debtor_id, debtor_name, address, gender, email, phone_number, created_time, updated_time, created_by, total_money));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

        }

        return listDebtor;

    }

   public int countById(String username, FilterDebtor filterDebtor) throws SQLException {
        int count = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String COUNTBYID = "SELECT COUNT(*) FROM Debtor d JOIN [User] u ON u.[id] = d.createdBy WHERE u.[email] = ? ";
        if (!filterDebtor.getIdFrom().isEmpty()) {
            COUNTBYID += "and d.id >= '" + filterDebtor.getIdFrom() + "'";
        }
        if (!filterDebtor.getIdTo().isEmpty()) {
            COUNTBYID += "and d.id <= '" + filterDebtor.getIdTo() + "'";
        }
        if (!filterDebtor.getName().isEmpty()) {
            COUNTBYID += "and d.name like '%" + filterDebtor.getName() + "%'";
        }
        if (!filterDebtor.getAddress().isEmpty()) {
            COUNTBYID += "and d.address like '%" + filterDebtor.getAddress() + "%'";
        }
        if (!filterDebtor.getPhone().isEmpty()) {
            COUNTBYID += "and d.phone_number like '%" + filterDebtor.getPhone() + "%'";
        }
        if (!filterDebtor.getEmail().isEmpty()) {
            COUNTBYID += "and d.email like '%" + filterDebtor.getEmail() + "%'";
        }
        if (!filterDebtor.getTotalDeptFrom().isEmpty()) {
            COUNTBYID += "and d.total_money >= '" + filterDebtor.getTotalDeptFrom() + "'";
        }
        if (!filterDebtor.getTotalDeptTo().isEmpty()) {
            COUNTBYID += "and d.total_money <= '" + filterDebtor.getTotalDeptTo() + "'";
        }

        if (!filterDebtor.getCreateDateForm().isEmpty()) {
            COUNTBYID += "and d.createdAt >= '" + filterDebtor.getCreateDateForm() + "'";
        }

        if (!filterDebtor.getCreateDateTo().isEmpty()) {
            COUNTBYID += "and d.createdAt <= '" + filterDebtor.getCreateDateTo() + "'";
        }

        if (!filterDebtor.getUpdateDateFrom().isEmpty()) {
            COUNTBYID += "and d.updatedAt >= '" + filterDebtor.getUpdateDateFrom() + "'";
        }

        if (!filterDebtor.getUpdateDateTo().isEmpty()) {
            COUNTBYID += "and d.updatedAt <= '" + filterDebtor.getUpdateDateTo() + "'";
        }
        try {
            con = connection;
            if (con != null) {
                ps = con.prepareStatement(COUNTBYID);
                ps.setString(1, username);
                rs = ps.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }

        }

        return count;

    }

    public boolean save(Debtor debtorDTO) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;

        String INSERT = "insert into Debtor(name, address, gender, email, phone_number, createdAt, updatedAt,createdBy,total_money) values(?,?,?,?,?,?,?,?,?)";
        try {
            conn = connection;
            if (conn != null) {
                stm = conn.prepareStatement(INSERT);
                stm.setString(1, debtorDTO.getDebtor_name());
                stm.setString(2, debtorDTO.getAddress());
                stm.setBoolean(3, true);
                stm.setString(4, debtorDTO.getEmail());
                stm.setString(5, debtorDTO.getPhone_number());
                stm.setString(6, SDF.format(debtorDTO.getCreated_time()));
                stm.setString(7, SDF.format(debtorDTO.getUpdated_time()));
                stm.setInt(8, debtorDTO.getCreated_by());
                stm.setDouble(9, debtorDTO.getTotal_money());
                result = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createNewDebtor(Debtor debtorDTO, int user_id) {
        String sql
                = "INSERT INTO [dbo].[Debtor]\n"
                + "           ([name]\n"
                + "           ,[address]\n"
                + "           ,[gender]\n"
                + "           ,[email]\n"
                + "           ,[phone_number]\n"
                + "           ,[createdBy]\n"
                + "           ,[createdAt]    \n"
                + "           ,[isDeleted]\n"
                + "           ,[total_money])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE()\n"
                + "           ,0\n"
                + "           ,0)";
        try {
            PreparedStatement st1 = connection.prepareCall(sql);
            st1.setString(1, debtorDTO.getDebtor_name());
            st1.setString(2, debtorDTO.getAddress());
            st1.setInt(3, debtorDTO.getGen());
            st1.setString(4, debtorDTO.getEmail());
            st1.setString(5, debtorDTO.getPhone_number());
            st1.setInt(6, user_id);
            st1.executeUpdate();
            System.out.println("successs");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Debtor getDebtorByID(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[address]\n"
                + "      ,[phone_number]\n"
                + "  FROM [dbo].[Debtor] where [id] = ?";
        Debtor debtor = new Debtor();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                debtor.setDebtor_id(Integer.parseInt((rs.getString("id"))));
                debtor.setDebtor_name(rs.getString("name"));
                debtor.setAddress(rs.getString("address"));
                debtor.setPhone_number(rs.getString("phone_number"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return debtor;
    }

}
