package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.HoaDon;
import model.NguoiDung;
import org.hibernate.Session;

public class HoaDonRepository {
    private Session session;
    
    public HoaDonRepository(){
        this.session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<HoaDon> getList(NguoiDung nguoiDung){
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from HoaDon where idNguoiDung=:idNguoiDung ORDER BY NgayMua DESC";
        Query q = session.createQuery(query);
        q.setParameter("idNguoiDung", nguoiDung);
        return (ArrayList<HoaDon>)q.getResultList();
    }
    
    public ArrayList<HoaDon> getListTrangThai(NguoiDung ng, int tinhTrang){
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
    public void update(String maHd){
        session.beginTransaction();
        String query = "update HoaDon set tinhTrang =:tinhTrang where ma =:ma";
        org.hibernate.query.Query q = session.createQuery(query);
        q.setParameter("tinhTrang", 1);
        q.setParameter("ma", maHd);
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
    public long turnover(int month){
        String query = "select SUM(hd.tongTien) from HoaDon hd where month(hd.ngayMua) =:month and year(hd.ngayMua) = year(getdate())";
        org.hibernate.query.Query q = session.createQuery(query);
        q.setParameter("month", month);
        List list = q.getResultList();
        if (list.get(0) != null) {
            return (long) list.get(0);
        } else {
            return 0;
        }
    }
}
