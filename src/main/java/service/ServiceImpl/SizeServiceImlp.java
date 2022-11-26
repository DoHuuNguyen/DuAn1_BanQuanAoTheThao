/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.ServiceImpl;

import java.util.ArrayList;
import model.Size;
import reopsitory.SizeRepository;
import service.QuanLySize;

/**
 *
 * @author Acer
 */
public class SizeServiceImlp implements QuanLySize{
    private SizeRepository sr;

    public SizeServiceImlp() {
        this.sr = new SizeRepository();
    }
    
    
    
    @Override
    public ArrayList<Size> getList() {
        return this.sr.getList();
    }

    @Override
    public void insert(Size size) {
        this.sr.insert(size);
    }

    @Override
    public void update(Integer id, Size size) {
        this.sr.update(id, size);
    }

    @Override
    public void delete(Integer id) {
        this.sr.delete(id);
    }

    @Override
    public boolean checkMa(Size size) {
        if(this.sr.selectMa().contains(size.getMa())){
            return false;
        }
        return true;
    }
    
}
