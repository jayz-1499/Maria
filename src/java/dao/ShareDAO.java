package dao;

import context.DBContext;
import entity.Share;
import interfaces.ShareInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShareDAO extends DBContext implements ShareInterface{
@Override
    public List<Share> getShare() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Share> list = new ArrayList<>();
        try {
            String query = "select * from Share";
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Share share = new Share(rs.getString("icon"),
                        rs.getString("socialNetwork"),
                        rs.getString("URL"));
                list.add(share);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            super.closeConnection(rs, ps, conn);
        }
    }
}
