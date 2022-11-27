/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.ServiceImpl;

import java.util.ArrayList;
import model.HinhThucThanhToan;
import reopsitory.HinhThucThanhToanRepository;
import service.QuanLyHinhThucThanhToan;

/**
 *
 * @author duong
 */
public class HinhThucThanhToanSeviceimpl implements QuanLyHinhThucThanhToan {
    private HinhThucThanhToanRepository Httrp = new HinhThucThanhToanRepository();
    
    
    
    @Override
    public ArrayList<HinhThucThanhToan> getlist() {
        return this. Httrp.getList();
    }

    @Override
    public void insert(HinhThucThanhToan Httt) {
        this.Httrp.insert(Httt);
    }

    @Override
    public void update(HinhThucThanhToan Httt, Integer id) {
        this.Httrp.update(id, Httt);
    }

    @Override
    public void delete(Integer id) {
        this.Httrp.delete(id);
    }

    @Override
    public ArrayList<String> selectma() {
        return this.Httrp.selectMa();
    }
}
