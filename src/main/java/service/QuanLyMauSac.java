package service;

import java.util.ArrayList;
import model.MauSac;

public interface QuanLyMauSac {
    ArrayList<MauSac> getList();
    void insert(MauSac ms);
    void update(MauSac ms, Integer id);
    void delete(Integer id);
    ArrayList<String> selectMa();
}
