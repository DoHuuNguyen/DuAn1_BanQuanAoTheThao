package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.MauSac;
import model.Size;
import org.hibernate.Session;

public class SizeRepository {

    private Session session;

    public SizeRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<Size> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from Size where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<Size> list = (ArrayList<Size>) q.getResultList();
        return list;
    }

    public void insert(Size size) {
        session.beginTransaction();
        session.save(size);
        session.getTransaction().commit();
    }

    public void update(Integer id, Size size) {
        session.beginTransaction();
        String query = "Update Size set ma=:ma, size=:size, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", size.getMa());
        q.setParameter("size", size.getSize());
        q.setParameter("ngaySua", size.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update Size set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from Size s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }

}
