package service;

import java.util.ArrayList;
import model.HoaDon;
import model.NguoiDung;

public interface QuanLyHoaDon {
    ArrayList<HoaDon> select(NguoiDung ng);
    ArrayList<HoaDon> select(int trang, NguoiDung ng);
    boolean insert(HoaDon hd);
    boolean update(String maHd);
    HoaDon searchByMa(String ma);
    void updateTongTien(Integer id, long tongTien);
    long turnover(int month);
}
