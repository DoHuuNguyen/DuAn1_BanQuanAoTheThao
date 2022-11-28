package service.ServiceImpl;

import java.util.ArrayList;
import model.HoaDon;
import model.HoaDonChiTiet;
import reopsitory.HoaDonChiTietRepository;
import service.QuanLyChiTietHoaDon;

public class HoaDonChiTietServiceImpl implements QuanLyChiTietHoaDon{
    private HoaDonChiTietRepository hdctRp;
    
    public HoaDonChiTietServiceImpl(){
        this.hdctRp = new HoaDonChiTietRepository();
    }
    
    @Override
    public ArrayList<HoaDonChiTiet> select(HoaDon hd) {
        return hdctRp.select(hd);
    }

    @Override
    public void insert(HoaDonChiTiet hdct) {
        hdctRp.insert(hdct);
    }

    @Override
    public HoaDonChiTiet search(Integer id) {
        return hdctRp.search(id);
    }

    @Override
    public long getThanhTien(HoaDon hd) {
        return hdctRp.getTongTien(hd);
    }

    @Override
    public void delete(Integer id) {
        hdctRp.delete(id);
    }
}
