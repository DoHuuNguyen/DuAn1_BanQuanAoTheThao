package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.ChucVu;
import org.hibernate.Session;

public class ChucVuRepository {

    private Session session;

    public ChucVuRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<ChucVu> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from ChucVu where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<ChucVu> list = (ArrayList<ChucVu>) q.getResultList();
        return list;
    }

    public void insert(ChucVu cv) {
        session.beginTransaction();
        session.save(cv);
        session.getTransaction().commit();
    }

    public void update(Integer id, ChucVu cv) {
        session.beginTransaction();
        String query = "Update ChucVu set ma=:ma, ten=:ten, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", cv.getMa());
        q.setParameter("ten", cv.getTen());
        q.setParameter("ngaySua", cv.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "update ChucVu set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from ChucVu s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
}
