
package dao;


import context.DBContext;
import entity.Introduction;
import interfaces.IntroductionInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IntroductionDAO extends DBContext implements IntroductionInterface{
    @Override
     public Introduction getIntroduction() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Intro";
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Introduction introduction = new Introduction(rs.getString("title"), 
                        rs.getString("picture"), 
                        rs.getString("shortDescription"), 
                        rs.getString("detailDescription"));
                return introduction;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            super.closeConnection(rs, ps, conn);
        }
        return null;
     }
    
}
