package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import model.HoaDon;
import model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HoaDonChiTietRepository {
    private Session session;

    public HoaDonChiTietRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<HoaDonChiTiet> select(HoaDon hd){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from HoaDonChiTiet where idHoaDon =:idHoaDon ");
        q.setParameter("idHoaDon", hd);
        return (ArrayList<HoaDonChiTiet>) q.getResultList();
    }
    
    public void insert(HoaDonChiTiet hdct){
        session.beginTransaction();
        session.save(hdct);
        session.getTransaction().commit();
    }
    
    public HoaDonChiTiet search(Integer id){
        String query = "from HoaDonChiTiet where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        return (HoaDonChiTiet) q.getResultList().get(0);
    }
    
    public long getTongTien(HoaDon hd){
        String query = "select sum(thanhTien) from HoaDonChiTiet where idHoaDon =:idHoaDon";
        Query q = session.createQuery(query);
        q.setParameter("idHoaDon", hd);
        return (long) q.getResultList().get(0);
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "delete from HoaDonChiTiet where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
}
