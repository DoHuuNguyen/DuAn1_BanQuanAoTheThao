package service;

import java.util.ArrayList;
import model.ChiTietSanPham;

public interface QuanLyChiTietSanPham {
    ArrayList<ChiTietSanPham> getList();
    void insert(ChiTietSanPham ctsp);
    void update(ChiTietSanPham ctsp, Integer id);
    void delete(Integer id);
    ArrayList<String> selectMa();
}