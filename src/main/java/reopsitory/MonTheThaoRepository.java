package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import model.MonTheThao;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MonTheThaoRepository {

    private Session session;

    public MonTheThaoRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<MonTheThao> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "From MonTheThao where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<MonTheThao> list = (ArrayList<MonTheThao>) q.getResultList();
        return list;
    }

    public void insert(MonTheThao mtt) {
        session.beginTransaction();
        session.save(mtt);
        session.getTransaction().commit();
    }

    public void update(Integer id, MonTheThao mtt) {
        session.beginTransaction();
        String query = "Update MonTheThao set ma=:ma, ten=:ten, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", mtt.getMa());
        q.setParameter("ten", mtt.getTen());
        q.setParameter("ngaySua", mtt.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        session.beginTransaction();
        String query = "Update MonTheThao set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }

    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from MonTheThao s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }

}
