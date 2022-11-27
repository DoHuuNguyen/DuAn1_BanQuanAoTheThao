/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reopsitory;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.NguoiDung;
import org.hibernate.Session;

/**
 *
 * @author thean
 */
public class NguoiDungRepository {
    private Session session;

    public NguoiDungRepository() {
        this.session = HibernateConfig.getFACTORY().openSession();
    }

    public ArrayList<NguoiDung> getList() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "from NguoiDung where trangThai =:trangThai";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 1);
        ArrayList<NguoiDung> list = (ArrayList<NguoiDung>) q.getResultList();
        return list;
    }

    public void insert(NguoiDung nd) {
        session.beginTransaction();
        session.save(nd);
        session.getTransaction().commit();
    }

    public void update(Integer id, NguoiDung nd) {
        session.beginTransaction();
        String query = "Update NguoiDung set ma=:ma, HoTen=:HoTen,GioiTinh=:GioiTinh,NgaySinh=:NgaySinh,Email=:Email,DiaChi=:DiaChi,IdChucVu=:IdChucVu,Anh=:Anh, ngaySua=:ngaySua where id=:id";
        Query q = session.createQuery(query);
        q.setParameter("ma", nd.getMa());
        q.setParameter("HoTen", nd.getHoTen());
        q.setParameter("GioiTinh", nd.getGioiTinh());
        q.setParameter("NgaySinh", nd.getNgaySinh());
        q.setParameter("Email", nd.getEmail());
        q.setParameter("DiaChi", nd.getDiaChi());
        q.setParameter("IdChucVu", nd.getIdChucVu());
        q.setParameter("Anh", nd.getAnh());
        q.setParameter("ngaySua", nd.getNgayThem());
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    public void delete(Integer id){
        session.beginTransaction();
        String query = "update NguoiDung set trangThai =:trangThai WHERE id=:id";
        Query q = session.createQuery(query);
        q.setParameter("trangThai", 0);
        q.setParameter("id", id);
        q.executeUpdate();
        session.getTransaction().commit();
    }
    public ArrayList<String> selectMa() {
        String query = "SELECT s.ma from NguoiDung s";
        Query q = session.createQuery(query);
        ArrayList<String> list = (ArrayList<String>) q.getResultList();
        return list;
    }
    public NguoiDung searchByEmail(String email){
        String query = "from NguoiDung where email =:email";
        org.hibernate.query.Query q = session.createQuery(query);
        q.setParameter("email", email);
        List list = q.getResultList();
        return (NguoiDung) list.get(0);
    }
}
