package service.ServiceImpl;

import java.util.ArrayList;
import model.ChiTietSanPham;
import reopsitory.ChiTietSanPhamRepository;
import service.QuanLyChiTietSanPham;

public class ChiTietSanPhamServiceImpl implements QuanLyChiTietSanPham{
    private ChiTietSanPhamRepository ctspR;
    
    public ChiTietSanPhamServiceImpl(){
        this.ctspR = new ChiTietSanPhamRepository();
    }

    @Override
    public ArrayList<ChiTietSanPham> getList() {
        return this.ctspR.select();
    }

    @Override
    public void insert(ChiTietSanPham ctsp) {
        this.ctspR.insert(ctsp);
    }

    @Override
    public void update(ChiTietSanPham ctsp, Integer id) {
        this.ctspR.update(id, ctsp);
    }

    @Override
    public void delete(Integer id) {
        this.ctspR.delete(id);
    }

    @Override
    public ArrayList<String> selectMa() {
        return this.ctspR.selectMa();
    }

    @Override
    public ChiTietSanPham searchID(Integer id) {
        return this.ctspR.searchById(id);
    }

    @Override
    public void updateSL(Integer id, int soLuong) {
        this.ctspR.updateSoLuong(id, soLuong);
    }

    @Override
    public ArrayList<ChiTietSanPham> loc(ChiTietSanPham ctsp) {
        return this.ctspR.loc(ctsp);
    }

    @Override
    public Integer selectSoLuongTon(String id) {
        return this.ctspR.searchSoLuongTon(id);
    }

    @Override
    public void updateNe(String id, int soLuong) {
        this.ctspR.updateSoLuongTen(id, soLuong);
    }
}
