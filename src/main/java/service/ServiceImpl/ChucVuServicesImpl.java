/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.ServiceImpl;

import java.util.ArrayList;
import model.ChucVu;
import reopsitory.ChucVuRepository;
import service.QuanLyChucVuServices;

/**
 *
 * @author vuong
 */
public class ChucVuServicesImpl implements QuanLyChucVuServices {

    private ChucVuRepository cvr = new ChucVuRepository();

    @Override
    public ArrayList<ChucVu> getList() {
        return cvr.getList();
    }

    @Override
    public void insert(ChucVu cv) {
        cvr.insert(cv);
    }

    @Override
    public void update(ChucVu cv, Integer id) {
        cvr.update(id, cv);
    }

    @Override
    public void delete(Integer id) {
        cvr.delete(id);
    }

    @Override
    public ArrayList<String> selectMa() {
        return cvr.selectMa();

    }

}
