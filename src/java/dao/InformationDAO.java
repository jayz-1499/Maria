package dao;

import context.DBContext;
import entity.Information;
import interfaces.InfomationInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InformationDAO extends DBContext implements InfomationInterface{
@Override
    public Information getInfomation() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {
            String query = "select * from Information";
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Information information = new Information(rs.getString("shortDescription"),
                        rs.getString("address"),
                        rs.getString("tel"),
                        rs.getString("email"),
                        rs.getString("openingHours"),
                        rs.getString("signature"));
              
                return information;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            super.closeConnection(rs, ps, conn);
        }
        return null;
    }
}
