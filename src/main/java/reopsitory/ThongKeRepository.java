package reopsitory;

import hibernateConfig.HibernateConfig;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ChiTietSanPham;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.NguoiDung;
import org.hibernate.Session;

public class ThongKeRepository {

    Session session = HibernateConfig.getFACTORY().openSession();

    public ThongKeRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public Long tongHoaDon() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select COUNT(*) from HoaDon";
        Query q = session.createQuery(query);
        return (Long) q.getResultList().get(0);
    }

    public Long tongHoaDonTT(int tinhTrang) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select COUNT(*) from HoaDon where tinhTrang =: tinhTrang";
        Query q = session.createQuery(query);
        q.setParameter("tinhTrang", tinhTrang);
        return (Long) q.getResultList().get(0);
    }

    public Long tongTien() {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select SUM(tongTien) from HoaDon";
        Query q = session.createQuery(query);
        return (Long) q.getResultList().get(0);
    }

    public Long tongTienTT(int tinhTrang) {
        session = HibernateConfig.getFACTORY().openSession();
        String query = "select SUM(tongTien) from HoaDon where tinhTrang =: tinhTrang";
        Query q = session.createQuery(query);
        q.setParameter("tinhTrang", tinhTrang);
        return (Long) q.getResultList().get(0);
    }

    public ArrayList<HoaDon> select() {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDon where tinhTrang =: tinhTrang order by (ngayMua) desc");
        q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDon>) q.getResultList();
    }

    public ArrayList<HoaDonChiTiet> selectHDct() {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDonChiTiet order by (soLuong) desc");
        // q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDonChiTiet>) q.getResultList();
    }

    public ArrayList<HoaDon> selectMaHd(String ma) {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDon "
                + "where Ma like :ma and tinhTrang =: tinhTrang "
                + "order by (ngayMua) desc");
        q.setParameter("ma", "%" + ma + "%");
        q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDon>) q.getResultList();
    }
    public ArrayList<HoaDon> selectNgayMua(String ma) {
        session = HibernateConfig.getFACTORY().openSession();
        org.hibernate.query.Query q = session.createQuery("from HoaDon "
                + "where NgayMua like :ma and tinhTrang =: tinhTrang "
                + "order by (ngayMua) desc");
        q.setParameter("ma", "%" + ma + "%");
        q.setParameter("tinhTrang", 1);
        return (ArrayList<HoaDon>) q.getResultList();
    }
    

//    public List<SanPham> search() {
////        String text = "HoaDonChiTiet"
//        session = HibernateConfig.getFACTORY().openSession();
//        String query = "SELECT new ViewModel.SanPham(c.idSanPham as idSp, SUM(c.soLuong) as SoLuongSum, SUM(thanhTien) as ThanhTienSum) from HoaDonChiTiet c  ";
//        Query q = session.createQuery(query,SanPham.class);
//        List<SanPham> arr = new ArrayList<>();
//        arr = q.getResultList();
////        List<Object[]> list = q.getResultList();
////        list.forEach((t) -> {
////            arr.add(new HoaDonChiTiet((ChiTietSanPham) t[0], Integer.parseInt((String) t[1]), Integer.parseInt((String) t[2])));
////        });
//        return arr;
//    }
//    public static void main(String[] args) {
//        ThongKeRepository t = new ThongKeRepository();
//        List<SanPham> l = t.search();
//        for (SanPham x : l) {
//            System.out.println(x);
//        }
//    }
}
