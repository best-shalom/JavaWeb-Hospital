package hospital.dao.impl;

import hospital.dbc.DbConnection;
import hospital.user.Hospital;
import hospital.user.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HospitalDaoImpl {
    public List<Hospital> findAll() {
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "select * from hospital";
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();

            List<Hospital> hospitalList = new ArrayList<>();

            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getInt(1));
                hospital.setName(rs.getString(2));
                hospital.setLevel(rs.getString(3));
                hospital.setAddress(rs.getString(4));
                hospital.setNumber(rs.getString(5));
                hospital.setPresidentname(rs.getString(6));
                hospital.setTime(rs.getString(7));
                hospital.setStatus(rs.getString(8));
                hospital.setIntroduction(rs.getString(9));

                hospitalList.add(hospital);
            }
            if (hospitalList == null) {
                System.out.println("no");
            }
            return hospitalList;
        } catch (Exception e) {
            System.out.println("NO");
            e.printStackTrace();
            return null;
        }
    }
}
