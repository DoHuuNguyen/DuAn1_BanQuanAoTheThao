package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import javax.persistence.Query;
import model.ChiTietSanPham;
import org.hibernate.Session;

public class ChiTietSanPhamRepository {
        private Session session;

    public ChiTietSanPhamRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }
    
    public ArrayList<ChiTietSanPham> select(){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from ChiTietSanPham where trangThai =:trangThai");
        q.setParameter("trangThai", 1);
        ArrayList<ChiTietSanPham> list = (ArrayList<ChiTietSanPham>) q.getResultList();
        return list;
    }
    
    public void insert(ChiTietSanPham ctsp){
        session.beginTransaction();
        session.save(ctsp);
        session.getTransaction().commit();
    }
    
    public void update(Integer id, ChiTietSanPham ctsp){
        session.beginTransaction();
        String query = "update ChiTietSanPham set ma =:ma, IdMonTheThao =:IdMonTheThao, "
                + "IdMauSac =:IdMauSac, IdSize =:IdSize, ngaySua =:ngaySua "
                + "where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", ctsp.getMa());
        q.setParameter("IdMonTheThao", ctsp.getIdMonTheThao());
        q.setParameter("IdMauSac", ctsp.getIdMauSac());
        q.setParameter("IdSize", ctsp.getIdSize());
        q.setParameter("ngaySua", ctsp.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update ChiTietSanPham set trangThai =:trangThai"
                + " where id =:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    
    public ArrayList<String> selectMa(){
        Query q = session.createQuery("select l.ma from ChiTietSanPham l");
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
    
    public ChiTietSanPham search(String ma){
        session = HibernateConfig.getFACTORY().openSession();
        Query q = session.createQuery("from ChiTietSanPham where ma =:ma");
        q.setParameter("ma", ma);
        return (ChiTietSanPham) q.getResultList().get(0);
    }
}
