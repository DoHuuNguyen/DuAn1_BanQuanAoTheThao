package reopsitory;

import hibernateConfig.HibernateConfig;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.ChiTietSanPham;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.NguoiDung;
import org.hibernate.Session;

public class ThongKeRepository {

    String instance = "";
    String serverName = "localhost";
    String portNumber = "1433";
    String dbName = "DuAn1_BanQuanAoSport";
    String userID = "sa";
    String password = "123456";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    Session session = HibernateConfig.getFACTORY().openSession();

    public ThongKeRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public Long tongHoaDon() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select COUNT(*) from HoaDon";
        Query q = session.createQuery(query);
        return (Long) q.getResultList().get(0);
    }

    public Long tongHoaDonTT(int tinhTrang) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select COUNT(*) from HoaDon where tinhTrang =: tinhTrang";
        Query q = session.createQuery(query);
        q.setParameter("tinhTrang", tinhTrang);
        return (Long) q.getResultList().get(0);
    }

    public Long tongTien() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select SUM(tongTien) from HoaDon";
        Query q = session.createQuery(query);
        return (Long) q.getResultList().get(0);
    }

    public Long tongTienTT(int tinhTrang) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select SUM(tongTien) from HoaDon where tinhTrang =: tinhTrang";
        Query q = session.createQuery(query);
        q.setParameter("tinhTrang", tinhTrang);
        return (Long) q.getResultList().get(0);
    }

    public ArrayList<HoaDon> select() {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDon where tinhTrang =: tinhTrang order by (ngayMua) desc");
        q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDon>) q.getResultList();
    }

    public ArrayList<HoaDonChiTiet> selectHDct() {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDonChiTiet order by (soLuong) desc");
        // q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDonChiTiet>) q.getResultList();
    }

    public ArrayList<HoaDon> selectMaHd(String ma) {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDon "
                + "where Ma like :ma and tinhTrang =: tinhTrang "
                + "order by (ngayMua) desc");
        q.setParameter("ma", "%" + ma + "%");
        q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDon>) q.getResultList();
    }

    public ArrayList<HoaDon> selectNgayMua(String ma) {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDon "
                + "where NgayMua like :ma and tinhTrang =: tinhTrang "
                + "order by (ngayMua) desc");
        q.setParameter("ma", "%" + ma + "%");
        q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDon>) q.getResultList();
    }

//    public ArrayList<HoaDonChiTiet> search() {
//        session = HibernateConfig.getFACTORY().openSession();
//        String query = "SELECT c.idSanPham, SUM(c.soLuong), SUM(thanhTien) from HoaDonChiTiet c  "
//                + "group by c.idSanPham "
//                + "order by SUM(thanhTien) desc";
//        Query q = session.createQuery(query).setMaxResults(1);
//        ArrayList<HoaDonChiTiet> arr = new ArrayList<>();
//        List<Object[]>  list = q.getResultList();
//        list.forEach((t)->{
//            arr.add(new HoaDonChiTiet((ChiTietSanPham)t[0], (Integer)t[1], (Integer)t[2]));
//        });
//        return arr;
//    }
    public ArrayList<Top> SelectTopSP() {
        ArrayList<Top> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            String sql = "SELECT top 5 s.Ma,s.Ten, SUM(c.soLuong) as sl, SUM(c.ThanhTien) as tt from HoaDonChiTiet c  \n"
                    + "join HoaDon h on c.IdHoaDon=h.Id\n"
                    + "join ChiTietSanPham s on c.IdSanPham=s.Id\n"
                    + "group by s.Ma,s.Ten\n"
                    + "order by SUM(c.ThanhTien) desc;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString("Ten");
                String ma = rs.getString("Ma");
                int sl = rs.getInt("sl");
                int tien = rs.getInt("tt");
                list.add(new Top(ma, ten, sl, tien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Top> SelectTopND() {
        ArrayList<Top> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            String sql = "select top 5 n.Ma,n.HoTen, COUNT(h.Ma) as sl, SUM(TongTien) as tt from HoaDon h\n"
                    + "join NguoiDung n on h.IDNguoiDung=n.Id\n"
                    + "group by n.Ma,n.HoTen\n"
                    + "order by SUM(TongTien) desc";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString("HoTen");
                String ma = rs.getString("Ma");
                int sl = rs.getInt("sl");
                int tien = rs.getInt("tt");
                list.add(new Top(ma, ten, sl, tien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
