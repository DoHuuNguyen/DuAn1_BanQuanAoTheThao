package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.HoaDon;
import org.hibernate.Session;

public class HoaDonRepository {
    private Session session;
    
    public HoaDonRepository(){
        this.session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<HoaDon> getList(String nguoiDung){
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from HoaDon where idNguoiDung=:idNguoiDung";
        Query q = session.createQuery(query);
        q.setParameter("idNguoiDung", nguoiDung);
        return (ArrayList<HoaDon>)q.getResultList();
    }
    
    public ArrayList<HoaDon> getListTrangThai(String ng, String tinhTrang){
        session = HibernateConfig.getFACTORY().openSession();
        String query = "From HoaDon where idNguoiDung=:idNguoiDung and tinhTrang =: tinhTrang";
        Query q = session.createQuery(query);
        q.setParameter("tinhTrang", tinhTrang);
        q.setParameter("idNguoiDung", ng);
        ArrayList<HoaDon> list = (ArrayList<HoaDon>)q.getResultList();
        return list;
    }
    public void insert(HoaDon hd){
        session.beginTransaction();
        session.save(hd);
        session.getTransaction().commit();
    }
    public void update(HoaDon hd, Integer id){
        session.beginTransaction();
        String query = "Update HoaDon set tinhTrang =:tinhTrang where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("TinhTrang", 1);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    public HoaDon searchMa(String ma){
        session = HibernateConfig.getFACTORY().openSession();
        String query = "From HoaDon where ma=:ma";
        Query q = session.createQuery(query);
        q.setParameter("ma", ma);
        return (HoaDon) q.getResultList().get(0);
    }
    public void updateTongTien(Integer id, long tongTien){
        session.beginTransaction();
        String query = "update HoaDon set tongTien =:tongTien where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("tongTien", tongTien);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
}
