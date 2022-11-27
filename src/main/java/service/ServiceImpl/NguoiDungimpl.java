/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.ServiceImpl;

import java.util.ArrayList;
import model.NguoiDung;
import reopsitory.NguoiDungRepository;
import service.QuanLyNguoiDung;

/**
 *
 * @author thean
 */
public class NguoiDungimpl implements QuanLyNguoiDung {

    private NguoiDungRepository ndrp;

    public NguoiDungimpl() {
        this.ndrp = new NguoiDungRepository();
    }

    @Override
    public ArrayList<NguoiDung> getList() {
        return this.ndrp.getList();
    }

    @Override
    public void insert(NguoiDung nd) {
        this.ndrp.insert(nd);
    }

    @Override
    public void update(NguoiDung nd, Integer id) {
        this.ndrp.update(id, nd);
    }

    @Override
    public void delete(Integer id) {
        this.ndrp.delete(id);
    }

    @Override
    public ArrayList<String> selectma() {
        return this.ndrp.selectMa();
    }

    @Override
    public NguoiDung email(String email) {
        return this.ndrp.searchByEmail(email);
    }

}
