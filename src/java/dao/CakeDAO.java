package dao;

import context.DBContext;
import entity.Cake;
import interfaces.CakeInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CakeDAO extends DBContext implements CakeInterface {

    @Override
    public List<Cake> getTop2() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        ArrayList<Cake> list = new ArrayList<>();
        try {
            String query = "select top 2* from Products order by DateCreated desc";
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            super.closeConnection(rs, ps, conn);
        }
    }

    @Override
    public Cake getCakeDetail(int CakeID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
     
        try {
            String query = "select * from Products where ID = ?";
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, CakeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                return cake;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            super.closeConnection(rs, ps, conn);
        }
        return null;
    }

    @Override

    public int getTotalProducts() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String query = "select count(*) from Products";
            conn = super.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            super.closeConnection(rs, ps, conn);
        }
        return count;
    }

    @Override
    public List<Cake> getAllCakes(int startIndex, int endIndex) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
  
        ArrayList<Cake> list = new ArrayList<>();
        try {
            String sql = "select *from("
                    + "select ROW_NUMBER() over (order by ID ASC) as rn, * "
                    + "from Products"
                    + ")as x "
                    + "where rn between ? "
                    + "and ?";
            conn = super.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, startIndex);
            ps.setInt(2, endIndex);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            super.closeConnection(rs, ps, conn);
        }
    }

}
