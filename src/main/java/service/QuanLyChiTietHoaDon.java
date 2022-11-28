package service;

import java.util.ArrayList;
import model.HoaDon;
import model.HoaDonChiTiet;

public interface QuanLyChiTietHoaDon {
    ArrayList<HoaDonChiTiet> select(HoaDon hd);
    void insert(HoaDonChiTiet hdct);
    HoaDonChiTiet search(Integer id);
    long getThanhTien(HoaDon hd);
    void delete(Integer id);
}
