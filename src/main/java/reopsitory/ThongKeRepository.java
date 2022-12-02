package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.NguoiDung;
import org.hibernate.Session;

public class ThongKeRepository {

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
    public ArrayList<HoaDon> select(){
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDon where tinhTrang =: tinhTrang order by (ngayMua) desc");
        q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDon>) q.getResultList();
    }
    public ArrayList<HoaDonChiTiet> selectHDct(){
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDonChiTiet order by (soLuong) desc");
       // q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDonChiTiet>) q.getResultList();
    }

   
}
