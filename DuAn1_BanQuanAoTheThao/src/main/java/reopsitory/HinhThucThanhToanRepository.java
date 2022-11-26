package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.HinhThucThanhToan;
import org.hibernate.Session;

public class HinhThucThanhToanRepository {
               private Session session;

    public HinhThucThanhToanRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<HinhThucThanhToan> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from HinhThucThanhToan where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<HinhThucThanhToan> list = (ArrayList<HinhThucThanhToan>) q.getResultList();
        return list;
    }

    public void insert(HinhThucThanhToan httt) {
        session.beginTransaction();
        session.save(httt);
        session.getTransaction().commit();
    }

    public void update(Integer id, HinhThucThanhToan httt) {
        session.beginTransaction();
        String query = "Update HinhThucThanhToan set ma=:ma, ten=:ten, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", httt.getMa());
        q.setParameter("ten", httt.getTen());
        q.setParameter("ngaySua", httt.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update HinhThucThanhToan set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from HinhThucThanhToan s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
