package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.MauSac;
import org.hibernate.Session;

public class MauSacRepository {

    private Session session;

    public MauSacRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<MauSac> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from MauSac where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<MauSac> list = (ArrayList<MauSac>) q.getResultList();
        return list;
    }

    public void insert(MauSac ms) {
        session.beginTransaction();
        session.save(ms);
        session.getTransaction().commit();
    }

    public void update(Integer id, MauSac ms) {
        session.beginTransaction();
        String query = "Update MauSac set ma=:ma, ten=:ten, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", ms.getMa());
        q.setParameter("ten", ms.getTen());
        q.setParameter("ngaySua", ms.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "update MauSac set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from MauSac s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }

}
