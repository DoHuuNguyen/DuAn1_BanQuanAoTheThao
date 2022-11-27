package service.ServiceImpl;

import java.util.ArrayList;
import model.MauSac;
import reopsitory.MauSacRepository;
import service.QuanLyMauSac;

public class MauSacServiceImpl implements QuanLyMauSac{
    private MauSacRepository msR;
    
    public MauSacServiceImpl(){
        this.msR = new MauSacRepository();
    }

    @Override
    public ArrayList<MauSac> getList() {
        return this.msR.getList();
    }

    @Override
    public void insert(MauSac ms) {
        this.msR.insert(ms);
    }

    @Override
    public void update(MauSac ms, Integer id) {
        this.msR.update(id, ms);
    }

    @Override
    public void delete(Integer id) {
        this.msR.delete(id);
    }

    @Override
    public ArrayList<String> selectMa() {
        return this.msR.selectMa();
    }
}
