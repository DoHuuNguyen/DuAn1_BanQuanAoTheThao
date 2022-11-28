package service.ServiceImpl;

import java.util.ArrayList;
import model.HoaDon;
import model.NguoiDung;
import reopsitory.HoaDonChiTietRepository;
import reopsitory.HoaDonRepository;
import service.QuanLyHoaDon;

public class HoaDonServiceImpl implements QuanLyHoaDon{
    private HoaDonRepository hdrp;
    
    public HoaDonServiceImpl(){
        this.hdrp = new HoaDonRepository();
    }

    @Override
    public ArrayList<HoaDon> select(NguoiDung ng) {
        return this.hdrp.getList(ng);
    }

    @Override
    public ArrayList<HoaDon> select(int trang, NguoiDung ng) {
        return this.hdrp.getListTrangThai(ng, trang);
    }


    @Override
    public boolean insert(HoaDon hd) {
        try {
            hdrp.insert(hd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(String maHd) {
        try {
            hdrp.update(maHd);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public HoaDon searchByMa(String ma) {
        return this.hdrp.searchMa(ma);
    }

    @Override
    public void updateTongTien(Integer id, long tongTien) {
        this.hdrp.updateTongTien(id, tongTien);
    }
    @Override
    public long turnover(int month) {
        return hdrp.turnover(month);
    }
    
}
